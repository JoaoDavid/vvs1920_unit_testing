package sut.properties;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

/**
 * @author João David n49448, Ye Yang n49521
 * 
 * String generator
 * length varying from 1 to MAX_LEN
 * chars ranging from code point MIN_CHAR_RANGE to MAX_CHAR_RANGE
 * 
 */
public class MyStringGenerator extends Generator<String>{
		
	private static final int MAX_LEN = 40;
	private static final int MIN_CHAR_RANGE = 48;
	private static final int MAX_CHAR_RANGE = 90;
	
	public MyStringGenerator() {
		super(String.class);
	}

	@Override
	public String generate(SourceOfRandomness random, GenerationStatus status) {
		int length = random.nextInt(MAX_LEN) + 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.appendCodePoint(random.nextInt(MIN_CHAR_RANGE,MAX_CHAR_RANGE));
		}
		return sb.toString();
	}
	
}
