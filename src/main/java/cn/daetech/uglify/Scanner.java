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
        	
        	if (ch == '\\')
        	{
        		ch = source.getPeekChar();
        		if (ch >= '0' && ch <= '7')	
        		{
        			ch = readOctalEscapeChar();
        		}
        		else
        		{
        			ch = readCharacterEscapeChar();
        		}
        				
        	}
        	
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

	private char readCharacterEscapeChar() {
		char ch = source.getNextChar();
		switch (ch) {
		case 'n':
			return '\n';
		case 'r':
			return '\r';
		case 't':
			return '\t';			
		case 'b':
			return '\b';
		case 'v':
			return '\u000b';
		case 'f':
			return '\f';
		case '0':
			return '\0';
		case 'x':
			return (char)readHexBytes(2);
		case 'u':
			return (char)readHexBytes(4);				
		default:
			return ch;
		}
	}

	private int readHexBytes(int i) {		
		String value ="";
        for (; i > 0; --i) {
        	value = value + source.getNextChar();
        }
        
        return Integer.valueOf(value, 16);		
	}



	private char readOctalEscapeChar() {
		char ch = source.getNextChar();
		
		
		return 0;
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
