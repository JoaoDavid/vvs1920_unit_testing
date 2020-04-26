package sut.properties;

import java.util.HashMap;
import java.util.Iterator;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import sut.TST;

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
	
	/**
	 * Checks if two tries are equal in content
	 * @param tst1 - Trie to compare
	 * @param tst2 - Trie to compare to
	 * @return true if tries are equal, false otherwise
	 */
	public static boolean equals(TST<Integer> tst1, TST<Integer> tst2) {
		if(tst1.size() != tst2.size()) {
			return false;
		}
		
		HashMap<String, Integer> entries1 = new HashMap<>();
		
		Iterator<String> it1 = tst1.keys().iterator();
		Iterator<String> it2 = tst2.keys().iterator();
		
		while(it1.hasNext()) {
			String currKey = it1.next();
			Integer val = tst1.get(currKey);
			entries1.put(currKey,val);
		}
		
		while(it2.hasNext()) {
			String currKey = it2.next();
			Integer val = tst2.get(currKey);
			if(!entries1.containsKey(currKey) || !entries1.get(currKey).equals(val)) {
				return false;
			}
		}
		return true;	
	}
	
	/**
	 * Deletes a given key from a trie if it exists
	 * @param key - key to be deleted
	 * @param tst - trie containing the key
	 */
	public static void delete(String key, TST<Integer> tst) {
		if(!tst.contains(key)) {
			System.out.println("Key does not exist in trie");
			return;
		}
		tst.put(key, null);
	}
}
