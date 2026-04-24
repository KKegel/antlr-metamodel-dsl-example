// Generated from kmeta/Kmeta.g4 by ANTLR 4.13.1
package kmeta;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KmetaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE=1, PROP=2, HAS=3, KNOWS=4, LIST=5, LBRACE=6, RBRACE=7, LPAREN=8, 
		RPAREN=9, COMMA=10, STRING=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TYPE", "PROP", "HAS", "KNOWS", "LIST", "LBRACE", "RBRACE", "LPAREN", 
			"RPAREN", "COMMA", "STRING", "WS"
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


	public KmetaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Kmeta.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\fN\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\nA\b\n\n\n\f\nD\t\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0004\u000bI\b\u000b\u000b\u000b\f\u000bJ\u0001\u000b\u0001\u000b\u0000"+
		"\u0000\f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0001\u0000"+
		"\u0002\u0003\u0000\n\n\r\r\"\"\u0003\u0000\t\n\r\r  P\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001\u0019\u0001\u0000\u0000"+
		"\u0000\u0003\u001e\u0001\u0000\u0000\u0000\u0005#\u0001\u0000\u0000\u0000"+
		"\u0007\'\u0001\u0000\u0000\u0000\t-\u0001\u0000\u0000\u0000\u000b2\u0001"+
		"\u0000\u0000\u0000\r4\u0001\u0000\u0000\u0000\u000f6\u0001\u0000\u0000"+
		"\u0000\u00118\u0001\u0000\u0000\u0000\u0013:\u0001\u0000\u0000\u0000\u0015"+
		"<\u0001\u0000\u0000\u0000\u0017H\u0001\u0000\u0000\u0000\u0019\u001a\u0005"+
		"t\u0000\u0000\u001a\u001b\u0005y\u0000\u0000\u001b\u001c\u0005p\u0000"+
		"\u0000\u001c\u001d\u0005e\u0000\u0000\u001d\u0002\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0005p\u0000\u0000\u001f \u0005r\u0000\u0000 !\u0005o\u0000"+
		"\u0000!\"\u0005p\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000#$\u0005h"+
		"\u0000\u0000$%\u0005a\u0000\u0000%&\u0005s\u0000\u0000&\u0006\u0001\u0000"+
		"\u0000\u0000\'(\u0005k\u0000\u0000()\u0005n\u0000\u0000)*\u0005o\u0000"+
		"\u0000*+\u0005w\u0000\u0000+,\u0005s\u0000\u0000,\b\u0001\u0000\u0000"+
		"\u0000-.\u0005l\u0000\u0000./\u0005i\u0000\u0000/0\u0005s\u0000\u0000"+
		"01\u0005t\u0000\u00001\n\u0001\u0000\u0000\u000023\u0005{\u0000\u0000"+
		"3\f\u0001\u0000\u0000\u000045\u0005}\u0000\u00005\u000e\u0001\u0000\u0000"+
		"\u000067\u0005(\u0000\u00007\u0010\u0001\u0000\u0000\u000089\u0005)\u0000"+
		"\u00009\u0012\u0001\u0000\u0000\u0000:;\u0005,\u0000\u0000;\u0014\u0001"+
		"\u0000\u0000\u0000<B\u0005\"\u0000\u0000=>\u0005\\\u0000\u0000>A\t\u0000"+
		"\u0000\u0000?A\b\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000@?\u0001\u0000"+
		"\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001"+
		"\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000"+
		"EF\u0005\"\u0000\u0000F\u0016\u0001\u0000\u0000\u0000GI\u0007\u0001\u0000"+
		"\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0006"+
		"\u000b\u0000\u0000M\u0018\u0001\u0000\u0000\u0000\u0004\u0000@BJ\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}