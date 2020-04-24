package sut.properties;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import sut.TST;

public class TSTGenerator extends Generator<TST<Integer>>{

	private int MIN_NODES = 0;
	private int MAX_NODES = 200;
	
	protected TSTGenerator(Class<TST<Integer>> type) {
		super(type);
	}

	@Override
	public TST<Integer> generate(SourceOfRandomness random, GenerationStatus status) {
		
		return null;
	}

}
