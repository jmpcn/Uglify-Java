package cn.daetech.uglify;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Reader {
	
	private int line;
	private int column;
	
	private InputStreamReader reader;

	public Reader(String fileName) {
		
		File fl = new File(fileName);
		
		System.out.print(fl.getAbsolutePath());
		
		this.line = 1;
		this.column = 0;
		
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
		try {
			ch = (char) reader.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			return (char) -1;
		}
		
		column++;
		
		if (ch == '\n')
		{
			line++;
			column = 0;
		}
		
		
		return ch;
		
	}
	
	

}
