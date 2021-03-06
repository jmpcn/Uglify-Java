package cn.daetech.uglify;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScannerTest {

	@Test
	public void testNextToken() {
		char[] buffer = "\"\\x2ause strict\";\r\nfunction sum(x, y){ return x + y }"
				.toCharArray();
		Source source = new Source("src\\test\\resources\\a.txt", buffer);

		Scanner scanner = new Scanner(source);

		Token token;
		while ((token = scanner.nextToken()).getTokenType() != -1) {

			System.out.println(token.toString());
		}

	}

}
