// Generated from kmeta/Kmeta.g4 by ANTLR 4.13.1
package kmeta;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KmetaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KmetaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KmetaParser#kmeta_file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKmeta_file(KmetaParser.Kmeta_fileContext ctx);
	/**
	 * Visit a parse tree produced by {@link KmetaParser#type_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_definition(KmetaParser.Type_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KmetaParser#rule_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_list(KmetaParser.Rule_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link KmetaParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(KmetaParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link KmetaParser#prop_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProp_rule(KmetaParser.Prop_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link KmetaParser#has_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHas_rule(KmetaParser.Has_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link KmetaParser#knows_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKnows_rule(KmetaParser.Knows_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link KmetaParser#rule_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_value(KmetaParser.Rule_valueContext ctx);
}