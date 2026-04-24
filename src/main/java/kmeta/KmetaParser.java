// Generated from kmeta/Kmeta.g4 by ANTLR 4.13.1
package kmeta;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class KmetaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE=1, PROP=2, HAS=3, KNOWS=4, LIST=5, LBRACE=6, RBRACE=7, LPAREN=8, 
		RPAREN=9, COMMA=10, STRING=11, WS=12;
	public static final int
		RULE_kmeta_file = 0, RULE_type_definition = 1, RULE_rule_list = 2, RULE_rule = 3, 
		RULE_prop_rule = 4, RULE_has_rule = 5, RULE_knows_rule = 6, RULE_rule_value = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"kmeta_file", "type_definition", "rule_list", "rule", "prop_rule", "has_rule", 
			"knows_rule", "rule_value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'type'", "'prop'", "'has'", "'knows'", "'list'", "'{'", "'}'", 
			"'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TYPE", "PROP", "HAS", "KNOWS", "LIST", "LBRACE", "RBRACE", "LPAREN", 
			"RPAREN", "COMMA", "STRING", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Kmeta.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KmetaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Kmeta_fileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(KmetaParser.EOF, 0); }
		public List<Type_definitionContext> type_definition() {
			return getRuleContexts(Type_definitionContext.class);
		}
		public Type_definitionContext type_definition(int i) {
			return getRuleContext(Type_definitionContext.class,i);
		}
		public Kmeta_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kmeta_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KmetaVisitor ) return ((KmetaVisitor<? extends T>)visitor).visitKmeta_file(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Kmeta_fileContext kmeta_file() throws RecognitionException {
		Kmeta_fileContext _localctx = new Kmeta_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_kmeta_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(16);
				type_definition();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_definitionContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(KmetaParser.TYPE, 0); }
		public List<TerminalNode> STRING() { return getTokens(KmetaParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(KmetaParser.STRING, i);
		}
		public TerminalNode LBRACE() { return getToken(KmetaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KmetaParser.RBRACE, 0); }
		public Rule_listContext rule_list() {
			return getRuleContext(Rule_listContext.class,0);
		}
		public Type_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KmetaVisitor ) return ((KmetaVisitor<? extends T>)visitor).visitType_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_definitionContext type_definition() throws RecognitionException {
		Type_definitionContext _localctx = new Type_definitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(TYPE);
			setState(25);
			match(STRING);
			setState(26);
			match(STRING);
			setState(27);
			match(LBRACE);
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0)) {
				{
				setState(28);
				rule_list();
				}
			}

			setState(31);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rule_listContext extends ParserRuleContext {
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public Rule_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KmetaVisitor ) return ((KmetaVisitor<? extends T>)visitor).visitRule_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule_listContext rule_list() throws RecognitionException {
		Rule_listContext _localctx = new Rule_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rule_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				rule_();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleContext extends ParserRuleContext {
		public Prop_ruleContext prop_rule() {
			return getRuleContext(Prop_ruleContext.class,0);
		}
		public Has_ruleContext has_rule() {
			return getRuleContext(Has_ruleContext.class,0);
		}
		public Knows_ruleContext knows_rule() {
			return getRuleContext(Knows_ruleContext.class,0);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KmetaVisitor ) return ((KmetaVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rule);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROP:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				prop_rule();
				}
				break;
			case HAS:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				has_rule();
				}
				break;
			case KNOWS:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				knows_rule();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Prop_ruleContext extends ParserRuleContext {
		public TerminalNode PROP() { return getToken(KmetaParser.PROP, 0); }
		public TerminalNode LPAREN() { return getToken(KmetaParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(KmetaParser.STRING, 0); }
		public TerminalNode COMMA() { return getToken(KmetaParser.COMMA, 0); }
		public Rule_valueContext rule_value() {
			return getRuleContext(Rule_valueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KmetaParser.RPAREN, 0); }
		public Prop_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prop_rule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KmetaVisitor ) return ((KmetaVisitor<? extends T>)visitor).visitProp_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prop_ruleContext prop_rule() throws RecognitionException {
		Prop_ruleContext _localctx = new Prop_ruleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_prop_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(PROP);
			setState(44);
			match(LPAREN);
			setState(45);
			match(STRING);
			setState(46);
			match(COMMA);
			setState(47);
			rule_value();
			setState(48);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Has_ruleContext extends ParserRuleContext {
		public TerminalNode HAS() { return getToken(KmetaParser.HAS, 0); }
		public TerminalNode LPAREN() { return getToken(KmetaParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(KmetaParser.STRING, 0); }
		public TerminalNode COMMA() { return getToken(KmetaParser.COMMA, 0); }
		public Rule_valueContext rule_value() {
			return getRuleContext(Rule_valueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KmetaParser.RPAREN, 0); }
		public Has_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_has_rule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KmetaVisitor ) return ((KmetaVisitor<? extends T>)visitor).visitHas_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Has_ruleContext has_rule() throws RecognitionException {
		Has_ruleContext _localctx = new Has_ruleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_has_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(HAS);
			setState(51);
			match(LPAREN);
			setState(52);
			match(STRING);
			setState(53);
			match(COMMA);
			setState(54);
			rule_value();
			setState(55);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Knows_ruleContext extends ParserRuleContext {
		public TerminalNode KNOWS() { return getToken(KmetaParser.KNOWS, 0); }
		public TerminalNode LPAREN() { return getToken(KmetaParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(KmetaParser.STRING, 0); }
		public TerminalNode COMMA() { return getToken(KmetaParser.COMMA, 0); }
		public Rule_valueContext rule_value() {
			return getRuleContext(Rule_valueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KmetaParser.RPAREN, 0); }
		public Knows_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knows_rule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KmetaVisitor ) return ((KmetaVisitor<? extends T>)visitor).visitKnows_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Knows_ruleContext knows_rule() throws RecognitionException {
		Knows_ruleContext _localctx = new Knows_ruleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_knows_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(KNOWS);
			setState(58);
			match(LPAREN);
			setState(59);
			match(STRING);
			setState(60);
			match(COMMA);
			setState(61);
			rule_value();
			setState(62);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rule_valueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(KmetaParser.STRING, 0); }
		public TerminalNode LIST() { return getToken(KmetaParser.LIST, 0); }
		public TerminalNode LPAREN() { return getToken(KmetaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KmetaParser.RPAREN, 0); }
		public Rule_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KmetaVisitor ) return ((KmetaVisitor<? extends T>)visitor).visitRule_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule_valueContext rule_value() throws RecognitionException {
		Rule_valueContext _localctx = new Rule_valueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rule_value);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(STRING);
				}
				break;
			case LIST:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(LIST);
				setState(66);
				match(LPAREN);
				setState(67);
				match(STRING);
				setState(68);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\fH\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0005\u0000\u0012\b\u0000\n\u0000\f\u0000\u0015\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u001e\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002"+
		"#\b\u0002\u000b\u0002\f\u0002$\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003*\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007F\b\u0007\u0001"+
		"\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0000E"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0002\u0018\u0001\u0000\u0000\u0000"+
		"\u0004\"\u0001\u0000\u0000\u0000\u0006)\u0001\u0000\u0000\u0000\b+\u0001"+
		"\u0000\u0000\u0000\n2\u0001\u0000\u0000\u0000\f9\u0001\u0000\u0000\u0000"+
		"\u000eE\u0001\u0000\u0000\u0000\u0010\u0012\u0003\u0002\u0001\u0000\u0011"+
		"\u0010\u0001\u0000\u0000\u0000\u0012\u0015\u0001\u0000\u0000\u0000\u0013"+
		"\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014"+
		"\u0016\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0016"+
		"\u0017\u0005\u0000\u0000\u0001\u0017\u0001\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0005\u0001\u0000\u0000\u0019\u001a\u0005\u000b\u0000\u0000\u001a"+
		"\u001b\u0005\u000b\u0000\u0000\u001b\u001d\u0005\u0006\u0000\u0000\u001c"+
		"\u001e\u0003\u0004\u0002\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f"+
		" \u0005\u0007\u0000\u0000 \u0003\u0001\u0000\u0000\u0000!#\u0003\u0006"+
		"\u0003\u0000\"!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\"\u0001"+
		"\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\u0005\u0001\u0000\u0000"+
		"\u0000&*\u0003\b\u0004\u0000\'*\u0003\n\u0005\u0000(*\u0003\f\u0006\u0000"+
		")&\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)(\u0001\u0000\u0000"+
		"\u0000*\u0007\u0001\u0000\u0000\u0000+,\u0005\u0002\u0000\u0000,-\u0005"+
		"\b\u0000\u0000-.\u0005\u000b\u0000\u0000./\u0005\n\u0000\u0000/0\u0003"+
		"\u000e\u0007\u000001\u0005\t\u0000\u00001\t\u0001\u0000\u0000\u000023"+
		"\u0005\u0003\u0000\u000034\u0005\b\u0000\u000045\u0005\u000b\u0000\u0000"+
		"56\u0005\n\u0000\u000067\u0003\u000e\u0007\u000078\u0005\t\u0000\u0000"+
		"8\u000b\u0001\u0000\u0000\u00009:\u0005\u0004\u0000\u0000:;\u0005\b\u0000"+
		"\u0000;<\u0005\u000b\u0000\u0000<=\u0005\n\u0000\u0000=>\u0003\u000e\u0007"+
		"\u0000>?\u0005\t\u0000\u0000?\r\u0001\u0000\u0000\u0000@F\u0005\u000b"+
		"\u0000\u0000AB\u0005\u0005\u0000\u0000BC\u0005\b\u0000\u0000CD\u0005\u000b"+
		"\u0000\u0000DF\u0005\t\u0000\u0000E@\u0001\u0000\u0000\u0000EA\u0001\u0000"+
		"\u0000\u0000F\u000f\u0001\u0000\u0000\u0000\u0005\u0013\u001d$)E";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}