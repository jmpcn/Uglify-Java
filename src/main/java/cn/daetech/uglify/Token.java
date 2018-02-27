package cn.daetech.uglify;

import java.util.ArrayList;
import java.util.List;

public class Token {
	
	private int tokenType;
	
	private String value;
	
	private Location startLocation;
	
	private int position;
	
	private Location endLocation;
	
	private List<Token> commentList;
	
	public Token(int tokenType) {
		this.tokenType = tokenType;
	}
	
	
	public void setStartLocation(int line, int column)
	{
		startLocation = new Location(line, column);
	}


	public void setPosition(int position) {
		this.position = position;
	}


	public int getTokenType() {
		return tokenType;
	}


	public void setTokenType(int tokenType) {
		this.tokenType = tokenType;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	public void addComment(Token token)
	{
		if (commentList == null)
		{
			commentList = new ArrayList<>();
			
		}
		
		commentList.add(token);
		
	}


	@Override
	public String toString() {
		return "Token [tokenType=" + tokenType + ", value=" + value
				+ ", startLocation=" + startLocation + ", position=" + position
				+ ", endLocation=" + endLocation + "]";
	}


	public void setEndLocation(int line, int column) {
		endLocation = new Location(line, column);
		
	}

	
	

	
	
	
	
	
	
	
	

}
