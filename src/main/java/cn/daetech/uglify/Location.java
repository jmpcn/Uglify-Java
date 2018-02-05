package cn.daetech.uglify;

public class Location {

	private int line;
	
	private int column;
	
	
	public Location() {
		this.line = 1;
		this.column = 0;
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
