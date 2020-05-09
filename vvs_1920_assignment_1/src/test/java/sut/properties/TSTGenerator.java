package sut.properties;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import sut.TST;

/**
 * @author João David n49448, Ye Yang n49521
 * 
 * TST Generator
 * Number of elements inside the structure may vary between minPuts and maxPuts
 * 
 */
public class TSTGenerator extends Generator<TST<Integer>>{
	
	public static final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static int min = 1;
	private static int max = 20;
	private int minPuts = 0;
	private int maxPuts = 1000;
	
	public TSTGenerator(Class<TST<Integer>> type) {
		super(type);
	}

	@Override
	public TST<Integer> generate(SourceOfRandomness random, GenerationStatus status) {
		int numPuts = random.nextInt(minPuts,maxPuts);
		TST<Integer> tst = new TST<>();
		for(int i = 0; i < numPuts; i++) {
			Integer val = random.nextInt(5000);
			String key = generateString(random);
			tst.put(key, val);
		}
		return tst;
	}
	
	private String generateString(SourceOfRandomness random) {
		int length = random.nextInt(min,max);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int j = random.nextInt(chars.length());
			sb.append(chars.charAt(j));
		}
		return sb.toString();
	}
}
