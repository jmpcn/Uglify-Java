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
		String value ="";
		char ch = source.getNextChar();
		
		value = value + ch;
		
		if (ch <= '3')
		{
			ch = source.getPeekChar();
			if (ch >= '0' && ch <= '7')
			{
				ch = source.getNextChar();
				value = value + ch;
				
				ch = source.getPeekChar();
				if (ch >= '0' && ch <= '7')
				{
					ch = source.getNextChar();
					value = value + ch;
				}
			}			
		}
		else if (ch <= '7')
		{
			ch = source.getPeekChar();
			if (ch >= '0' && ch <= '7')
			{
				ch = source.getNextChar();
				value = value + ch;
			}			
		}
		
		int octalValue = Integer.valueOf(value, 8);
		return (char) octalValue;	
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
		
		if (ScannerHelp.isOperatorChar(ch))
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
		String word = read_name();
		
		int tokenType = ScannerHelp.getTokenType(word);
		
		token.setTokenType(tokenType);
		token.setValue(word);
		token.setEndLocation(source.getLine(), source.getColumn());				
	}



	private String read_name() {
		
		boolean backslash = false;
		boolean escaped = false;
		String name = "";
		char ch;
		
		while ((ch = source.getPeekChar()) != -1) {			
            if (!backslash) {
                if (ch == '\\') {
                	escaped = backslash = true;
                	ch = source.getNextChar();
                }
                else if (ScannerHelp.isIdentifierChar(ch)) {
                	ch = source.getNextChar();
                	name += ch;
                }
                else  {
                	break;
                }
            }
            else {
                if (ch != 'u') {
                	//parse_error("Expecting UnicodeEscapeSequence -- uXXXX");
                }
                
                ch = readCharacterEscapeChar();
                if (!ScannerHelp.isIdentifierChar(ch)) {
                	//parse_error("Unicode char: " + ch.charCodeAt(0) + " is not valid in identifier");
                }
                name += ch;
                backslash = false;
            }
            
		}
		return name;
	}



	private void readOperator(Token token) {
		
		String value = "" + source.getNextChar();
		
		for(;;)
		{
			value = value + source.getPeekChar();
			
			if (ScannerHelp.isOperators(value))
			{
				source.getNextChar();				
			}
			else
			{
				break;
			}			
		}
					
        token.setTokenType(TokenType.OPERATOR);
        token.setValue(value);
		token.setEndLocation(source.getLine(), source.getColumn());
		
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
		char ch = source.getNextChar();

		ch = source.getPeekChar();

		if (ch == '/') {
			Token commentTolen = new Token(TokenType.SINGLE_COMMENT);
			readLineComment(commentTolen);
		}

		if (ch == '*') {
			Token commentTolen = new Token(TokenType.MULTI_COMMENT);
			readMultiLineComment(commentTolen);
			
			
		}

	}



	private void readMultiLineComment(Token commentTolen) {
		// TODO Auto-generated method stub
		
	}



	private void readLineComment(Token commentTolen) {
		// TODO Auto-generated method stub
		
	}



	private void handleDot(Token token) {
		
	}





}
