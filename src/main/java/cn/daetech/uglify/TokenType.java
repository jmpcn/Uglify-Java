/**
 * 
 */
package cn.daetech.uglify;

/**
 * @author zjx
 *
 */
public class TokenType {
	
	/**
	 * Node type constant indicating a node of type
	 * <code>AnonymousClassDeclaration</code>.
	 * @see AnonymousClassDeclaration
	 */
		
	public static final int NUM = 1;
	
	public static final int STRING = 2;
	
	public static final int REGEXP = 3;
	
	public static final int OPERATOR = 4;
	
	public static final int PUNC = 5;
	
	public static final int ATOM = 6;
	
	public static final int NAME = 7;
	
	public static final int KEYWORD = 8;
	
	public static final int SINGLE_COMMENT = 9;
	
	public static final int MULTI_COMMENT = 10;
	
	public static final int EOF = -1;

}
