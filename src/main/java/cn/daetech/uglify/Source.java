package cn.daetech.uglify;

public class Source {
	
	private String fileName;
	
	private char[] buffer;
	
	private int position;
	
	private Location location;
	
	/**
	 * @param fileName
	 * @param buffer
	 */
	public Source(String fileName, char[] buffer) {
		super();
		this.fileName = fileName;
		this.buffer = buffer;
		this.position = 0;
		this.location = new Location();
	}
	
	public int getLine()
	{
		return location.getLine();
	}
	
	
	public int getColumn() {
		return location.getColumn();
	}
		
	public String getFileName() {
		return fileName;
	}

	public int getPosition() {
		return position;
	}


	public char getNextChar()
	{
		if (position >= buffer.length)
		{
			return (char) -1;
		}
		
		char ch = buffer[position++];

		if (isNewLineChar(ch))
		{
			location.newLine();
			
			// treat a \r\n sequence as a single \n
			if((ch == '\r') && (getPeekChar() == '\n'))
			{
				position++;
				ch = '\n';
			}
		}
		else
		{
			location.next();	
		}
		
		
		return ch;
		
	}
	
	private boolean isNewLineChar(char ch) {
		if (ch == '\r')
		{
			return true;
		}
		
		if (ch == '\n')
		{
			return true;
		}
		
		return false;
	}

	public char getPeekChar()
	{
		if (position >= buffer.length)
		{
			return (char) -1;
		}
		
		return buffer[position];
		
	}
	
	
}
