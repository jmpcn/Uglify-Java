package cn.daetech.uglify;

public class Uglify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParseOption option = new ParseOption();
		
		Parser parser = new Parser();
		
		parser.parse("src\\test\\resources\\a.txt", option);

	}

}
