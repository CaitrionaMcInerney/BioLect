grammar ccrcbDSL;

//This grammar has been developed using RegEx principles as stated within the Antlr v4 tutorials

recipe : (step)* EOF ;

step : use_spec | diff_expr_spec | cmap_spec | comment ;

//Specifications for data set
use_spec: 'use' (filter_spec | data_spec) ;

//What to store data set as
data_spec: location_spec 'as' dataset_id=ID 'dataset' ;

//Where to find data
location_spec: repository_spec | local_spec ;

//What GEO Dataset to return
repository_spec: repository_id=ID 'accession' dataset_id=ID ;

//Where the data is being stored locally
local_spec: directory=STRING ;

logical_criteria: logical_criteria operator=OP logical_criteria
                | name=ID comparator=CMP value=FLOAT
                | name=STRING comparator=CMP value=STRING ;

//To specify grouping critera
filter_spec: logical_criteria 'to create' entity entity_id=ID 'from' dataset_id=ID datatype_spec ;


//To colculate differential expresion
diff_expr_spec: 'calculate' entity dexpr_id=ID 'of' contrast ('using' algorithm=ID )? ('with' correction_algorithm=ID 'multiple testing correction')? ;

//Type of data entity
entity: 'group' | 'gene list' | 'differential expression' | 'plot' ;

//Giving group objects for differential expression
contrast: group1=ID 'vs' group0=ID ;

//Connecting to QUADrATiC to run the connection mapping analysis via cMap
cmap_spec: 'find' conn_type_spec 'connections for gene list' gene_list=ID ;

//Additional Rule Boundaries
//Add comments
comment: '##' .*? '##';

//Giving ID to lists
id_list : first_id=ID (COMMA ID)* ;

//Datatype storage
datatype_spec: 'table' | 'dataset' ;

//Specify positive or negative connections
conn_type_spec: 'negative' | 'postive' | 'all' ;

//Gene expression list
expr_list : STRING (COMMA STRING)* ;

CMP: '<' | '<=' | '>=' | '>' | '=' | '=/=' ;
OP : 'and' | 'or' ;
ID : [a-zA-Z_]* [a-zA-Z0-9_-]+ ;
EOL : '\r'?'\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
STRING : '"' (~'"'|'\\"')* '"'  ;
COMMA : ','+ ;
FLOAT
    :   '-'? INT '.' DPLACES EXP?   // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP            // 1e10 -3e4
    |   '-'? INT                // -3, 45
    ;

fragment INT :   '0' | [1-9] [0-9]* ;
fragment DPLACES: [0-9]* ;
fragment EXP :   [Ee] [+\-]? INT ;

