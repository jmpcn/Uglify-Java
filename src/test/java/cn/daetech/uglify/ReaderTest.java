package cn.daetech.uglify;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReaderTest {

	@Test
	public void testGetChar() {

		
		Reader reader = new Reader("src\\test\\resources\\a.txt");
		
		char ch = reader.getChar();
		
		assertEquals(ch, 'a');
		
		
	}

}
