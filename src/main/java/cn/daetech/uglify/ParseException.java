/**
 * 
 */
package cn.daetech.uglify;

/**
 * @author zjx
 *
 */
public class ParseException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1255544266616223403L;
	

	private int line = -1;
	
	private int column = -1;
	
	private int position = -1;

	/**
     * @param message
	 * @param line
	 * @param column
	 * @param position
	 */
	public ParseException(String message, int line, int column, int position) {
		super(message);
		this.line = line;
		this.column = column;
		this.position = position;
	}
	
    /**
     * @param message
     */
    public ParseException(String message) {
        super(message);
    }
	
	
}
