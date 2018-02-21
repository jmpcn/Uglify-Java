package cn.daetech.uglify;

public class Location {

	private int line;
	
	private int column;
	
	/**
	 * @param line
	 * @param column
	 */
	public Location(int line, int column) {
		super();
		this.line = line;
		this.column = column;
	}
	
	public Location() {
		this.line = 1;
		this.column = 0;
	}
	
	
	
	
	
	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void next()
	{
		column++;
	}
	
	public void newLine()
	{
		line++;
		column = 0;
	}


	@Override
	public String toString() {
		return "Location [line=" + line + ", column=" + column + "]";
	}
		
}
