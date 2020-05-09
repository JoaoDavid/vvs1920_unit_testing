package sut.properties;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import sut.TST;

/**
 * @author João David n49448, Ye Yang n49521
 * 
 * TST Generator
 * Number of elements inside the structure may vary between MINPUTS and MAXPUTS
 * 
 */
public class TSTGenerator extends Generator<TST<Integer>>{
	
	private static final int MINPUTS = 0;
	private static final int MAXPUTS = 1000;
	
	public TSTGenerator(Class<TST<Integer>> type) {
		super(type);
	}

	@Override
	public TST<Integer> generate(SourceOfRandomness random, GenerationStatus status) {
		MyStringGenerator myStrGen = new MyStringGenerator();
		int numPuts = random.nextInt(MINPUTS,MAXPUTS);
		TST<Integer> tst = new TST<>();
		for(int i = 0; i < numPuts; i++) {
			Integer val = random.nextInt(5000);
			String key = myStrGen.generate(random, status);
			tst.put(key, val);
		}
		return tst;
	}	
	
}
