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
	
	
	private static Map<String, Integer> KEYWORDS = new HashMap<>();
	
	static {
		KEYWORDS.put("break", TokenType.KEYWORD);
		KEYWORDS.put("case", TokenType.KEYWORD);
		KEYWORDS.put("catch", TokenType.KEYWORD);
		KEYWORDS.put("const", TokenType.KEYWORD);
		KEYWORDS.put("continue", TokenType.KEYWORD);
		KEYWORDS.put("debugger", TokenType.KEYWORD);
		KEYWORDS.put("default", TokenType.KEYWORD);
		KEYWORDS.put("delete", TokenType.KEYWORD);
		KEYWORDS.put("do", TokenType.KEYWORD);
		KEYWORDS.put("else", TokenType.KEYWORD);
		KEYWORDS.put("finally", TokenType.KEYWORD);
		KEYWORDS.put("for", TokenType.KEYWORD);
		KEYWORDS.put("function", TokenType.KEYWORD);
		KEYWORDS.put("if", TokenType.KEYWORD);
		KEYWORDS.put("in", TokenType.KEYWORD);		
		KEYWORDS.put("instanceof", TokenType.KEYWORD);
		KEYWORDS.put("new", TokenType.KEYWORD);
		KEYWORDS.put("return", TokenType.KEYWORD);
		KEYWORDS.put("switch", TokenType.KEYWORD);	
		KEYWORDS.put("throw", TokenType.KEYWORD);
		KEYWORDS.put("try", TokenType.KEYWORD);
		KEYWORDS.put("typeof", TokenType.KEYWORD);
		KEYWORDS.put("var", TokenType.KEYWORD);		
		KEYWORDS.put("void", TokenType.KEYWORD);
		KEYWORDS.put("while", TokenType.KEYWORD);
		KEYWORDS.put("with", TokenType.KEYWORD);
		
		KEYWORDS.put("false", TokenType.ATOM);
		KEYWORDS.put("null", TokenType.ATOM);
		KEYWORDS.put("true", TokenType.ATOM);		
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

	public static boolean isOperator(char ch) {
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
		Integer a = KEYWORDS.get(name);
		return a.intValue() == TokenType.KEYWORD;
				
	}
	
	public static int getTokenType(String name)
	{
		Integer a = KEYWORDS.get(name);
		
		if (a != null)
		{
			return a.intValue();
		}
		
		return TokenType.NAME;
		
	}
	
	
}
