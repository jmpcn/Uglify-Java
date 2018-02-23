/**
 * 
 */
package cn.daetech.uglify;

/**
 * @author zjx
 *
 */
public class ScannerHelp {
	
	public static boolean isLetter(char ch) {
	    return (ch >= 97 && ch <= 122)
	            || (ch >= 65 && ch <= 90)
	            || (ch >= 0xaa );		
	}
	
	public static boolean isIdentifierStart(char ch)
	{
		return ch == 36 || ch == 95 || isLetter(ch);
	}

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
	
}
