library(Biobase)
library(GEOquery)
library(limma)
library(gplots)
library(RColorBrewer)


gset <- getGEO("GSE36000", GSEMatrix =TRUE)

if (length(gset) > 1) idx <- grep("GPL570", attr(gset, "names")) else idx <- 1
gset <- gset[[idx]]

fvarLabels(gset) <- make.names(fvarLabels(gset))

# group names for all samples
groupZeroSamples <- c("GSM879126", "GSM879148", "GSM879147", "GSM879119", "GSM879140", "GSM879120", "GSM879129", "GSM879118", "GSM879125", "GSM879127", "GSM879154", "GSM879122", "GSM879121", "GSM879155");
groupContrastSamples <- c("GSM879149", "GSM879136", "GSM879139", "GSM879124", "GSM879145", "GSM879142", "GSM879144", "GSM879130", "GSM879132", "GSM879153", "GSM879150", "GSM879138", "GSM879146", "GSM879141", "GSM879152", "GSM879123", "GSM879151", "GSM879131", "GSM879137", "GSM879128", "GSM879134", "GSM879143", "GSM879135", "GSM879133");

# eliminate samples marked as "X"
groupZeroIndices <- which(sampleNames(gset) %in% groupZeroSamples)
groupZeroLabels = rep(c("G0"), length(groupZeroIndices))
groupContrastIndices <- which(sampleNames(gset) %in% groupContrastSamples)
groupContrastLabels = rep(c("G1"), length(groupContrastIndices))

groupsOfInterestIndices = c(groupZeroIndices, groupContrastIndices)

sml <- c(groupZeroLabels, groupContrastLabels)
gset <- gset[ ,groupsOfInterestIndices]
count <- dim(gset)
numgenes <- count[1]

# log2 transform
ex <- exprs(gset)
qx <- as.numeric(quantile(ex, c(0., 0.25, 0.5, 0.75, 0.99, 1.0), na.rm=T))
LogC <- (qx[5] > 100) ||
  (qx[6]-qx[1] > 50 && qx[2] > 0) ||
  (qx[2] > 0 && qx[2] < 1 && qx[4] > 1 && qx[4] < 2)
if (LogC) { ex[which(ex <= 0)] <- NaN
            exprs(gset) <- log2(ex) }

# set up the data and proceed with analysis
fl <- as.factor(sml)
gset$description <- fl
design <- model.matrix(~ description + 0, gset)
colnames(design) <- levels(fl)
fit <- lmFit(gset, design)
cont.matrix <- makeContrasts(G1-G0, levels=design)
fit2 <- contrasts.fit(fit, cont.matrix)
fit2 <- eBayes(fit2, 0.01)
tT <- topTable(fit2, adjust="BH", sort.by="M", number=numgenes)

# load NCBI platform annotation
gpl <- annotation(gset)
platf <- getGEO(gpl, AnnotGPL=TRUE)
ncbifd <- data.frame(attr(dataTable(platf), "table"))

# replace original platform annotation
tT <- tT[setdiff(colnames(tT), setdiff(fvarLabels(gset), "ID"))]
tT <- merge(tT, ncbifd, by="ID")
tT <- subset(tT, select=c("ID","adj.P.Val","P.Value","t","B","logFC","Gene.symbol","Gene.title"))
tT <- tT[order(tT$P.Value), ]  # restore correct order
write.csv(tT,"/tmp/IGHVstatusMCL.csv")

# find DE genes
degenes <- subset(tT, tT$adj.P.Val<0.15)
up <- subset(degenes, degenes$logFC>0.0)
down <- subset(degenes, degenes$logFC< -0.0)

# Combine up/down reg genes into single csv
degenescsv <- rbind(up, down)
degenes <- degenescsv[order(degenescsv$P.Value), ]
write.csv(degenes, "/tmp/IGHVstatusMCL_de.csv", row.names=TRUE)

# Volcano Plot
png(file = "/tmp/IGHVstatusMCL_volcano.png", 490, 350)
par(mar=c(3,3,2,1), mgp=c(2,.7,0), tck=-.01)
volcano <- plot(degenes$logFC, -log10(degenes$P.Value),
                xlim=c(-5, 5), ylim=c(0, 10), #Set limits
                xlab="log2 fold change", ylab="-log10 p-value")
dev.off()


#Heat Mapping
allprobes <- read.csv(file = "/tmp/IGHVstatusMCL.csv", header=TRUE)
deprobes <- read.csv(file = "/tmp/IGHVstatusMCL_de.csv", header=TRUE)[ ,2]
de <- data.frame(deprobes)

select <- allprobes$X %in% de$deprobes
plotDE <- allprobes[select,]

rnames <- plotDE[,1]
columnnum <- ncol(plotDE)
mat_data <- data.matrix(plotDE[,2:columnnum])
rownames(mat_data) <- rnames

png(file = "/tmp/IGHVstatusMCL_heatmap.png")
palette <- colorRampPalette(c("red", "green"))(n = 299)
heatmap(mat_data, col=palette)
dev.off()



