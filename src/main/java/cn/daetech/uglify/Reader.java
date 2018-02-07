package cn.daetech.uglify;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Reader {
	
	
	private Location location;
	
	private boolean isPeek;
	
	private char peekChar;
	
	private InputStreamReader reader;

	public Reader(String fileName) {
		
		File fl = new File(fileName);
		
		System.out.print(fl.getAbsolutePath());
		
		this.location = new Location();
		this.isPeek = false;
		
		 try {
			this.reader = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	public char getChar()
	{
		char ch;
		
		if (isPeek)
		{
			ch = peekChar;
			isPeek = false;
		}
		else
		{
			ch = readChar();
		}
		
		if (isNewLineChar(ch))
		{
			location.newLine();
			
			// treat a \r\n sequence as a single \n
			if((ch == '\r') && (peekChar() == '\n'))
			{
				forwardPeek();
				ch = '\n';
			}
		}
		else
		{
			location.next();	
		}
				
		return ch;		
	}
	
	public char peekChar()
	{
		if (isPeek)
		{
			return peekChar;
		}	
		else
		{
			isPeek = true;
			peekChar = readChar();
			return peekChar;
		}
	}
	
	public void forwardPeek()
	{
		isPeek = false;
	}


	private char readChar() {
		char ch;
		try {
			ch = (char) reader.read();
		} catch (IOException e) {
			e.printStackTrace();			
			return (char) -1;
		}
		return ch;
	}
	
	
	private boolean isNewLineChar(char ch)
	{
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
}
