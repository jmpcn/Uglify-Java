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
		char quote = source.getNextChar();	
		
        for (;;) {
        	
        	char ch = source.getNextChar();	
        	
        	if (ch == quote)
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
		
		if (ScannerHelp.isStringQuote(ch))
		{			
			readString(token);
			return token;
		}
		
		if (ScannerHelp.isDot(ch))
		{
			handleDot(token);
			return token;			
		}
		
		if (ScannerHelp.isSlash(ch))
		{
			handleSlash(token);
			return token;			
		}
		
		if (ScannerHelp.isDigital(ch))
		{
			readNum(token);
			return token;			
		}
		
		if (ScannerHelp.isPunc(ch))
		{
			handlePunc(token);
			return token;	
		}
		
		if (ScannerHelp.isOperator(ch))
		{
			readOperator(token);
			return token;
		}
		
		if (ScannerHelp.isIdentifierStart(ch)) {
			
			readWord(token);
			return token;
		}
	
		
		return token;
		
	}



	private void readWord(Token token) {
		// TODO Auto-generated method stub
		
	}



	private void readOperator(Token token) {
		// TODO Auto-generated method stub
		
	}



	private void handlePunc(Token token) {
		
		String value = "" + source.getNextChar();			
        token.setTokenType(TokenType.PUNC);
        token.setValue(value);
		token.setEndLocation(source.getLine(), source.getColumn());
		
	}



	private void readNum(Token token) {
		// TODO Auto-generated method stub
		
	}



	private void handleSlash(Token token) {
		
	}



	private void handleDot(Token token) {
		
	}





}
