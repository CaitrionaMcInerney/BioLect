# Generated from ccrcbDSL.g4 by ANTLR 4.7
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .ccrcbDSLParser import ccrcbDSLParser
else:
    from ccrcbDSLParser import ccrcbDSLParser

# This class defines a complete generic visitor for a parse tree produced by ccrcbDSLParser.

class ccrcbDSLVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by ccrcbDSLParser#recipe.
    def visitRecipe(self, ctx:ccrcbDSLParser.RecipeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#step.
    def visitStep(self, ctx:ccrcbDSLParser.StepContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#use_spec.
    def visitUse_spec(self, ctx:ccrcbDSLParser.Use_specContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#data_spec.
    def visitData_spec(self, ctx:ccrcbDSLParser.Data_specContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#location_spec.
    def visitLocation_spec(self, ctx:ccrcbDSLParser.Location_specContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#repository_spec.
    def visitRepository_spec(self, ctx:ccrcbDSLParser.Repository_specContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#local_spec.
    def visitLocal_spec(self, ctx:ccrcbDSLParser.Local_specContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#logical_criteria.
    def visitLogical_criteria(self, ctx:ccrcbDSLParser.Logical_criteriaContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#filter_spec.
    def visitFilter_spec(self, ctx:ccrcbDSLParser.Filter_specContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#diff_expr_spec.
    def visitDiff_expr_spec(self, ctx:ccrcbDSLParser.Diff_expr_specContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#entity.
    def visitEntity(self, ctx:ccrcbDSLParser.EntityContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#contrast.
    def visitContrast(self, ctx:ccrcbDSLParser.ContrastContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#cmap_spec.
    def visitCmap_spec(self, ctx:ccrcbDSLParser.Cmap_specContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#comment.
    def visitComment(self, ctx:ccrcbDSLParser.CommentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#id_list.
    def visitId_list(self, ctx:ccrcbDSLParser.Id_listContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#datatype_spec.
    def visitDatatype_spec(self, ctx:ccrcbDSLParser.Datatype_specContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#conn_type_spec.
    def visitConn_type_spec(self, ctx:ccrcbDSLParser.Conn_type_specContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ccrcbDSLParser#expr_list.
    def visitExpr_list(self, ctx:ccrcbDSLParser.Expr_listContext):
        return self.visitChildren(ctx)



del ccrcbDSLParser