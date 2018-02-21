/**
 * 
 */
package cn.daetech.uglify;

/**
 * @author zjx
 *
 */
public class ScannerHelp {

	public static boolean isWhiteSpace(char ch) {
		switch (ch) {
		case '\r':
		case '\n':
			return true;
		default:
			return false;
		}
	}
	
	public static boolean isStringPrefix(char ch)
	{
		switch (ch) {
		case '"':
		case '\'':
			return true;
		default:
			return false;
		}		
	}
	
	public static boolean isDigital(char ch)
	{
		return ch >= 48 && ch <= 57;
	}

}
