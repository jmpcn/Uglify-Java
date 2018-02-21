package cn.daetech.uglify;


public class Scanner {
	
	private Source source;
	
		
	/**
	 * @param source
	 */
	public Scanner(Source source) {
		super();
		this.source = source;
	}



	private void skipWhiteSpace()
	{		
        while (ScannerHelp.isWhiteSpace(source.getPeekChar()))
        		source.getNextChar();		
	}
	
	
	private void startToken(Token token)
	{
		token.setStartLocation(source.getLine(), source.getColumn());
		token.setPosition(source.getPosition());
		
	}
	
	private void readString(Token token) {
		
		String value = "";
		char start = source.getNextChar();	
		
        for (;;) {
        	
        	char ch = source.getNextChar();	
        	
        	if (ch == start)
        	{
        		break;
        	}
        	
        	value = value + ch;       	
        }
        
        token.setTokenType(TokenType.STRING);
        token.setValue(value);
		token.setEndLocation(source.getLine(), source.getColumn());
	}



	public Token nextToken()
	{
		Token token = new Token(TokenType.EOF);
		skipWhiteSpace();
		
		startToken(token);
		
		char ch = source.getPeekChar();
		
		if (ch == -1)
		{
			return token;
		}
		
		if (ScannerHelp.isStringPrefix(ch))
		{
			
			readString(token);
			return token;
		}
		
		
		return token;
		
	}





}
