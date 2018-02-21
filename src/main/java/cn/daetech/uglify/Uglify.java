package cn.daetech.uglify;

public class Uglify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] buffer = "\"use strict\";\r\nfunction sum(x, y){ return x + y }".toCharArray();
		Source source = new Source("src\\test\\resources\\a.txt", buffer);
		
		ParseOption option = new ParseOption();
		
		Parser parser = new Parser();
		
		parser.parse(source, option);

	}

}
