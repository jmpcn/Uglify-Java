/**
 * 
 */
package cn.daetech.uglify;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjx
 *
 */
public class ScannerHelp {
	
	
	private static Map<String, String> KEYWORDS = new HashMap<>();
	
	
	private static Map<String, String> KEYWORDS_ATOM = new HashMap<>();
	
	
	private static Map<String, String> OPERATORS = new HashMap<>();
	
	
	
	static {
		KEYWORDS.put("break", "break");
		KEYWORDS.put("case", "break");
		KEYWORDS.put("catch", "catch");
		KEYWORDS.put("const", "const");
		KEYWORDS.put("continue", "continue");
		KEYWORDS.put("debugger", "debugger");
		KEYWORDS.put("default", "default");
		KEYWORDS.put("delete", "delete");
		KEYWORDS.put("do", "do");
		KEYWORDS.put("else", "A");
		KEYWORDS.put("finally", "A");
		KEYWORDS.put("for", "A");
		KEYWORDS.put("function", "A");
		KEYWORDS.put("if", "A");
		KEYWORDS.put("in", "A");		
		KEYWORDS.put("instanceof", "A");
		KEYWORDS.put("new", "A");
		KEYWORDS.put("return", "A");
		KEYWORDS.put("switch", "A");	
		KEYWORDS.put("throw", "A");
		KEYWORDS.put("try", "A");
		KEYWORDS.put("typeof", "A");
		KEYWORDS.put("var", "A");		
		KEYWORDS.put("void", "A");
		KEYWORDS.put("while", "A");
		KEYWORDS.put("with", "A");
		
		KEYWORDS_ATOM.put("false", "A");
		KEYWORDS_ATOM.put("null", "A");
		KEYWORDS_ATOM.put("true", "A");	
		
		OPERATORS.put("in", "");
		OPERATORS.put("instanceof", "");
		OPERATORS.put("typeof", "");
		OPERATORS.put("new", "");
		OPERATORS.put("void", "");
		OPERATORS.put("delete", "");
		OPERATORS.put("++", "");
		OPERATORS.put("--", "");	
		OPERATORS.put("+", "");
		OPERATORS.put("-", "");	
		OPERATORS.put("!", "");			
		OPERATORS.put("~", "");			
		OPERATORS.put("&", "");	
		OPERATORS.put("|", "");	
		OPERATORS.put("^", "");	
		OPERATORS.put("*", "");	
		OPERATORS.put("/", "");	
		OPERATORS.put("%", "");	
		OPERATORS.put(">>", "");			
		OPERATORS.put("<<", "");			
		OPERATORS.put(">>>", "");			
		OPERATORS.put("<", "");	
		OPERATORS.put(">", "");	
		OPERATORS.put("<=", "");	
		OPERATORS.put(">=", "");
		
		OPERATORS.put("==", "");	
		OPERATORS.put("===", "");	
		OPERATORS.put("!=", "");	
		OPERATORS.put("!==", "");	
		OPERATORS.put("?", "");	
		
		OPERATORS.put("=", "");	
		OPERATORS.put("+=", "");
		OPERATORS.put("-=", "");
		OPERATORS.put("/=", "");
		OPERATORS.put("*=", "");
		OPERATORS.put("%=", "");
		OPERATORS.put(">>=", "");
		OPERATORS.put("<<=", "");
		OPERATORS.put(">>>=", "");
		OPERATORS.put("|=", "");
		OPERATORS.put("^=", "");
		OPERATORS.put("&=", "");
		OPERATORS.put("&&", "");
		OPERATORS.put("||", "");
		
	}
	
	public static boolean isLetter(char ch) {
	    return (ch >= 97 && ch <= 122)
	            || (ch >= 65 && ch <= 90)
	            || (ch >= 0xaa );		
	}
	
	public static boolean isIdentifierStart(char ch)
	{
		return ch == 36 || ch == 95 || isLetter(ch);
	}
	
	
	public static boolean isIdentifierChar(char ch) {
	    return isIdentifierStart(ch)
	        || isDigital(ch)
	        || ch == 8204 // \u200c: zero-width non-joiner <ZWNJ>
	        || ch == 8205 // \u200d: zero-width joiner <ZWJ> (in my ECMA-262 PDF, this is also 200c)
//	        || is_unicode_combining_mark(ch)
//	        || is_unicode_connector_punctuation(ch)
	    ;
	};

	public static boolean isWhiteSpace(char ch) {
		switch (ch) {
		case ' ':
		case '\u00a0':
		case '\n':
		case '\r':
		case '\t':
		case '\f':	
		case '\u000b':	
		case '\u200b':			
			return true;
		default:
			return false;
		}
	}
	
	public static boolean isStringQuote(char ch)
	{
		switch (ch) {
		case '"':
		case '\'':
			return true;
		default:
			return false;
		}		
	}
	
	public static boolean isDot(char ch)
	{
		return ch == '.';
	}
	
	public static boolean isSlash(char ch)
	{
		return ch == '/';
	}
	
	public static boolean isDigital(char ch)
	{
		return ch >= '0' && ch <= '9';
	}
	
	
	public static boolean isPunc(char ch) {
		switch (ch) {
		case '[':
		case ']':
		case '{':
		case '}':
		case '(':
		case ')':	
		case ',':	
		case ';':
		case ':':			
			return true;
		default:
			return false;
		}
	}

	public static boolean isOperatorChar(char ch) {
		switch (ch) {
		case '+':
		case '-':
		case '*':
		case '&':
		case '%':
		case '=':	
		case '<':	
		case '>':
		case '!':	
		case '?':	
		case '|':	
		case '~':	
		case '^':
			return true;
		default:
			return false;
		}
	}
	
	
	public static boolean isKeywords(String name)
	{
		return KEYWORDS.containsKey(name);				
	}
	
	
	public static boolean isOperators(String name)
	{
		return OPERATORS.containsKey(name);				
	}
	
	public static int getTokenType(String name)
	{
		if (KEYWORDS_ATOM.containsKey(name))
		{
			return TokenType.ATOM;
		}
		
		if (!KEYWORDS.containsKey(name))
		{
			return TokenType.NAME;
		}
		
		if (OPERATORS.containsKey(name))
		{
			return TokenType.OPERATOR;
		}
				
		return TokenType.KEYWORD;		
	}
	
	
}
