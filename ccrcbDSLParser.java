// Generated from ccrcbDSL.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ccrcbDSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, CMP=24, OP=25, 
		ID=26, EOL=27, WS=28, STRING=29, COMMA=30, FLOAT=31;
	public static final int
		RULE_recipe = 0, RULE_step = 1, RULE_use_spec = 2, RULE_data_spec = 3, 
		RULE_location_spec = 4, RULE_repository_spec = 5, RULE_local_spec = 6, 
		RULE_logical_criteria = 7, RULE_filter_spec = 8, RULE_diff_expr_spec = 9, 
		RULE_entity = 10, RULE_contrast = 11, RULE_cmap_spec = 12, RULE_comment = 13, 
		RULE_id_list = 14, RULE_datatype_spec = 15, RULE_conn_type_spec = 16, 
		RULE_expr_list = 17;
	public static final String[] ruleNames = {
		"recipe", "step", "use_spec", "data_spec", "location_spec", "repository_spec", 
		"local_spec", "logical_criteria", "filter_spec", "diff_expr_spec", "entity", 
		"contrast", "cmap_spec", "comment", "id_list", "datatype_spec", "conn_type_spec", 
		"expr_list"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'use'", "'as'", "'dataset'", "'accession'", "'to create'", "'from'", 
		"'calculate'", "'of'", "'using'", "'with'", "'multiple testing correction'", 
		"'group'", "'gene list'", "'differential expression'", "'plot'", "'vs'", 
		"'find'", "'connections for gene list'", "'##'", "'table'", "'negative'", 
		"'postive'", "'all'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"CMP", "OP", "ID", "EOL", "WS", "STRING", "COMMA", "FLOAT"
	};
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
	public String getGrammarFileName() { return "ccrcbDSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ccrcbDSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RecipeContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ccrcbDSLParser.EOF, 0); }
		public List<StepContext> step() {
			return getRuleContexts(StepContext.class);
		}
		public StepContext step(int i) {
			return getRuleContext(StepContext.class,i);
		}
		public RecipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recipe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterRecipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitRecipe(this);
		}
	}

	public final RecipeContext recipe() throws RecognitionException {
		RecipeContext _localctx = new RecipeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_recipe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__16) | (1L << T__18))) != 0)) {
				{
				{
				setState(36);
				step();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
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

	public static class StepContext extends ParserRuleContext {
		public Use_specContext use_spec() {
			return getRuleContext(Use_specContext.class,0);
		}
		public Diff_expr_specContext diff_expr_spec() {
			return getRuleContext(Diff_expr_specContext.class,0);
		}
		public Cmap_specContext cmap_spec() {
			return getRuleContext(Cmap_specContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitStep(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_step);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				use_spec();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				diff_expr_spec();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				cmap_spec();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				comment();
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

	public static class Use_specContext extends ParserRuleContext {
		public Filter_specContext filter_spec() {
			return getRuleContext(Filter_specContext.class,0);
		}
		public Data_specContext data_spec() {
			return getRuleContext(Data_specContext.class,0);
		}
		public Use_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterUse_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitUse_spec(this);
		}
	}

	public final Use_specContext use_spec() throws RecognitionException {
		Use_specContext _localctx = new Use_specContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_use_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(51);
				filter_spec();
				}
				break;
			case 2:
				{
				setState(52);
				data_spec();
				}
				break;
			}
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

	public static class Data_specContext extends ParserRuleContext {
		public Token dataset_id;
		public Location_specContext location_spec() {
			return getRuleContext(Location_specContext.class,0);
		}
		public TerminalNode ID() { return getToken(ccrcbDSLParser.ID, 0); }
		public Data_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterData_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitData_spec(this);
		}
	}

	public final Data_specContext data_spec() throws RecognitionException {
		Data_specContext _localctx = new Data_specContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_data_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			location_spec();
			setState(56);
			match(T__1);
			setState(57);
			((Data_specContext)_localctx).dataset_id = match(ID);
			setState(58);
			match(T__2);
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

	public static class Location_specContext extends ParserRuleContext {
		public Repository_specContext repository_spec() {
			return getRuleContext(Repository_specContext.class,0);
		}
		public Local_specContext local_spec() {
			return getRuleContext(Local_specContext.class,0);
		}
		public Location_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterLocation_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitLocation_spec(this);
		}
	}

	public final Location_specContext location_spec() throws RecognitionException {
		Location_specContext _localctx = new Location_specContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_location_spec);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				repository_spec();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				local_spec();
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

	public static class Repository_specContext extends ParserRuleContext {
		public Token repository_id;
		public Token dataset_id;
		public List<TerminalNode> ID() { return getTokens(ccrcbDSLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ccrcbDSLParser.ID, i);
		}
		public Repository_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repository_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterRepository_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitRepository_spec(this);
		}
	}

	public final Repository_specContext repository_spec() throws RecognitionException {
		Repository_specContext _localctx = new Repository_specContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_repository_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			((Repository_specContext)_localctx).repository_id = match(ID);
			setState(65);
			match(T__3);
			setState(66);
			((Repository_specContext)_localctx).dataset_id = match(ID);
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

	public static class Local_specContext extends ParserRuleContext {
		public Token directory;
		public TerminalNode STRING() { return getToken(ccrcbDSLParser.STRING, 0); }
		public Local_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterLocal_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitLocal_spec(this);
		}
	}

	public final Local_specContext local_spec() throws RecognitionException {
		Local_specContext _localctx = new Local_specContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_local_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			((Local_specContext)_localctx).directory = match(STRING);
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

	public static class Logical_criteriaContext extends ParserRuleContext {
		public Token name;
		public Token comparator;
		public Token value;
		public Token operator;
		public TerminalNode ID() { return getToken(ccrcbDSLParser.ID, 0); }
		public TerminalNode CMP() { return getToken(ccrcbDSLParser.CMP, 0); }
		public TerminalNode FLOAT() { return getToken(ccrcbDSLParser.FLOAT, 0); }
		public List<TerminalNode> STRING() { return getTokens(ccrcbDSLParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ccrcbDSLParser.STRING, i);
		}
		public List<Logical_criteriaContext> logical_criteria() {
			return getRuleContexts(Logical_criteriaContext.class);
		}
		public Logical_criteriaContext logical_criteria(int i) {
			return getRuleContext(Logical_criteriaContext.class,i);
		}
		public TerminalNode OP() { return getToken(ccrcbDSLParser.OP, 0); }
		public Logical_criteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_criteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterLogical_criteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitLogical_criteria(this);
		}
	}

	public final Logical_criteriaContext logical_criteria() throws RecognitionException {
		return logical_criteria(0);
	}

	private Logical_criteriaContext logical_criteria(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_criteriaContext _localctx = new Logical_criteriaContext(_ctx, _parentState);
		Logical_criteriaContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_logical_criteria, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(71);
				((Logical_criteriaContext)_localctx).name = match(ID);
				setState(72);
				((Logical_criteriaContext)_localctx).comparator = match(CMP);
				setState(73);
				((Logical_criteriaContext)_localctx).value = match(FLOAT);
				}
				break;
			case STRING:
				{
				setState(74);
				((Logical_criteriaContext)_localctx).name = match(STRING);
				setState(75);
				((Logical_criteriaContext)_localctx).comparator = match(CMP);
				setState(76);
				((Logical_criteriaContext)_localctx).value = match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Logical_criteriaContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logical_criteria);
					setState(79);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(80);
					((Logical_criteriaContext)_localctx).operator = match(OP);
					setState(81);
					logical_criteria(4);
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Filter_specContext extends ParserRuleContext {
		public Token entity_id;
		public Token dataset_id;
		public Logical_criteriaContext logical_criteria() {
			return getRuleContext(Logical_criteriaContext.class,0);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public Datatype_specContext datatype_spec() {
			return getRuleContext(Datatype_specContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(ccrcbDSLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ccrcbDSLParser.ID, i);
		}
		public Filter_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterFilter_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitFilter_spec(this);
		}
	}

	public final Filter_specContext filter_spec() throws RecognitionException {
		Filter_specContext _localctx = new Filter_specContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_filter_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			logical_criteria(0);
			setState(88);
			match(T__4);
			setState(89);
			entity();
			setState(90);
			((Filter_specContext)_localctx).entity_id = match(ID);
			setState(91);
			match(T__5);
			setState(92);
			((Filter_specContext)_localctx).dataset_id = match(ID);
			setState(93);
			datatype_spec();
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

	public static class Diff_expr_specContext extends ParserRuleContext {
		public Token dexpr_id;
		public Token algorithm;
		public Token correction_algorithm;
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public ContrastContext contrast() {
			return getRuleContext(ContrastContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(ccrcbDSLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ccrcbDSLParser.ID, i);
		}
		public Diff_expr_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_diff_expr_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterDiff_expr_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitDiff_expr_spec(this);
		}
	}

	public final Diff_expr_specContext diff_expr_spec() throws RecognitionException {
		Diff_expr_specContext _localctx = new Diff_expr_specContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_diff_expr_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__6);
			setState(96);
			entity();
			setState(97);
			((Diff_expr_specContext)_localctx).dexpr_id = match(ID);
			setState(98);
			match(T__7);
			setState(99);
			contrast();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(100);
				match(T__8);
				setState(101);
				((Diff_expr_specContext)_localctx).algorithm = match(ID);
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(104);
				match(T__9);
				setState(105);
				((Diff_expr_specContext)_localctx).correction_algorithm = match(ID);
				setState(106);
				match(T__10);
				}
			}

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

	public static class EntityContext extends ParserRuleContext {
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitEntity(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class ContrastContext extends ParserRuleContext {
		public Token group1;
		public Token group0;
		public List<TerminalNode> ID() { return getTokens(ccrcbDSLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ccrcbDSLParser.ID, i);
		}
		public ContrastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contrast; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterContrast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitContrast(this);
		}
	}

	public final ContrastContext contrast() throws RecognitionException {
		ContrastContext _localctx = new ContrastContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_contrast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			((ContrastContext)_localctx).group1 = match(ID);
			setState(112);
			match(T__15);
			setState(113);
			((ContrastContext)_localctx).group0 = match(ID);
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

	public static class Cmap_specContext extends ParserRuleContext {
		public Token gene_list;
		public Conn_type_specContext conn_type_spec() {
			return getRuleContext(Conn_type_specContext.class,0);
		}
		public TerminalNode ID() { return getToken(ccrcbDSLParser.ID, 0); }
		public Cmap_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmap_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterCmap_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitCmap_spec(this);
		}
	}

	public final Cmap_specContext cmap_spec() throws RecognitionException {
		Cmap_specContext _localctx = new Cmap_specContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmap_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__16);
			setState(116);
			conn_type_spec();
			setState(117);
			match(T__17);
			setState(118);
			((Cmap_specContext)_localctx).gene_list = match(ID);
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

	public static class CommentContext extends ParserRuleContext {
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitComment(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__18);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(121);
					matchWildcard();
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(127);
			match(T__18);
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

	public static class Id_listContext extends ParserRuleContext {
		public Token first_id;
		public List<TerminalNode> ID() { return getTokens(ccrcbDSLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ccrcbDSLParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ccrcbDSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ccrcbDSLParser.COMMA, i);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterId_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitId_list(this);
		}
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			((Id_listContext)_localctx).first_id = match(ID);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(130);
				match(COMMA);
				setState(131);
				match(ID);
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class Datatype_specContext extends ParserRuleContext {
		public Datatype_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterDatatype_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitDatatype_spec(this);
		}
	}

	public final Datatype_specContext datatype_spec() throws RecognitionException {
		Datatype_specContext _localctx = new Datatype_specContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_datatype_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Conn_type_specContext extends ParserRuleContext {
		public Conn_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conn_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterConn_type_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitConn_type_spec(this);
		}
	}

	public final Conn_type_specContext conn_type_spec() throws RecognitionException {
		Conn_type_specContext _localctx = new Conn_type_specContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_conn_type_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Expr_listContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(ccrcbDSLParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ccrcbDSLParser.STRING, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ccrcbDSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ccrcbDSLParser.COMMA, i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ccrcbDSLListener ) ((ccrcbDSLListener)listener).exitExpr_list(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(STRING);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(142);
				match(COMMA);
				setState(143);
				match(STRING);
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return logical_criteria_sempred((Logical_criteriaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logical_criteria_sempred(Logical_criteriaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0098\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\63"+
		"\n\3\3\4\3\4\3\4\5\48\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\5\6A\n\6\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tP\n\t\3\t\3\t\3\t\7\t"+
		"U\n\t\f\t\16\tX\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13i\n\13\3\13\3\13\3\13\5\13n\n\13\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\7\17}\n\17\f\17\16\17\u0080"+
		"\13\17\3\17\3\17\3\20\3\20\3\20\7\20\u0087\n\20\f\20\16\20\u008a\13\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\7\23\u0093\n\23\f\23\16\23\u0096\13"+
		"\23\3\23\3~\3\20\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\5\3\2"+
		"\16\21\4\2\5\5\26\26\3\2\27\31\2\u0092\2)\3\2\2\2\4\62\3\2\2\2\6\64\3"+
		"\2\2\2\b9\3\2\2\2\n@\3\2\2\2\fB\3\2\2\2\16F\3\2\2\2\20O\3\2\2\2\22Y\3"+
		"\2\2\2\24a\3\2\2\2\26o\3\2\2\2\30q\3\2\2\2\32u\3\2\2\2\34z\3\2\2\2\36"+
		"\u0083\3\2\2\2 \u008b\3\2\2\2\"\u008d\3\2\2\2$\u008f\3\2\2\2&(\5\4\3\2"+
		"\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\2\2"+
		"\3-\3\3\2\2\2.\63\5\6\4\2/\63\5\24\13\2\60\63\5\32\16\2\61\63\5\34\17"+
		"\2\62.\3\2\2\2\62/\3\2\2\2\62\60\3\2\2\2\62\61\3\2\2\2\63\5\3\2\2\2\64"+
		"\67\7\3\2\2\658\5\22\n\2\668\5\b\5\2\67\65\3\2\2\2\67\66\3\2\2\28\7\3"+
		"\2\2\29:\5\n\6\2:;\7\4\2\2;<\7\34\2\2<=\7\5\2\2=\t\3\2\2\2>A\5\f\7\2?"+
		"A\5\16\b\2@>\3\2\2\2@?\3\2\2\2A\13\3\2\2\2BC\7\34\2\2CD\7\6\2\2DE\7\34"+
		"\2\2E\r\3\2\2\2FG\7\37\2\2G\17\3\2\2\2HI\b\t\1\2IJ\7\34\2\2JK\7\32\2\2"+
		"KP\7!\2\2LM\7\37\2\2MN\7\32\2\2NP\7\37\2\2OH\3\2\2\2OL\3\2\2\2PV\3\2\2"+
		"\2QR\f\5\2\2RS\7\33\2\2SU\5\20\t\6TQ\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2"+
		"\2\2W\21\3\2\2\2XV\3\2\2\2YZ\5\20\t\2Z[\7\7\2\2[\\\5\26\f\2\\]\7\34\2"+
		"\2]^\7\b\2\2^_\7\34\2\2_`\5 \21\2`\23\3\2\2\2ab\7\t\2\2bc\5\26\f\2cd\7"+
		"\34\2\2de\7\n\2\2eh\5\30\r\2fg\7\13\2\2gi\7\34\2\2hf\3\2\2\2hi\3\2\2\2"+
		"im\3\2\2\2jk\7\f\2\2kl\7\34\2\2ln\7\r\2\2mj\3\2\2\2mn\3\2\2\2n\25\3\2"+
		"\2\2op\t\2\2\2p\27\3\2\2\2qr\7\34\2\2rs\7\22\2\2st\7\34\2\2t\31\3\2\2"+
		"\2uv\7\23\2\2vw\5\"\22\2wx\7\24\2\2xy\7\34\2\2y\33\3\2\2\2z~\7\25\2\2"+
		"{}\13\2\2\2|{\3\2\2\2}\u0080\3\2\2\2~\177\3\2\2\2~|\3\2\2\2\177\u0081"+
		"\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\25\2\2\u0082\35\3\2\2\2\u0083\u0088"+
		"\7\34\2\2\u0084\u0085\7 \2\2\u0085\u0087\7\34\2\2\u0086\u0084\3\2\2\2"+
		"\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\37"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\t\3\2\2\u008c!\3\2\2\2\u008d"+
		"\u008e\t\4\2\2\u008e#\3\2\2\2\u008f\u0094\7\37\2\2\u0090\u0091\7 \2\2"+
		"\u0091\u0093\7\37\2\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095%\3\2\2\2\u0096\u0094\3\2\2\2\r)\62"+
		"\67@OVhm~\u0088\u0094";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}