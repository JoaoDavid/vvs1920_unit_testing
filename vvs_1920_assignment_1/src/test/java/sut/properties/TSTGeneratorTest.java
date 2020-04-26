package sut.properties;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import sut.TST;

@RunWith(JUnitQuickcheck.class)
public class TSTGeneratorTest {
	
	private static final int maxPrefixLength = 10;
	public static final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	@Before
	public void setUp() {
	}
	
	@Property
	public void testOrderInsertion(@From(TSTGenerator.class) TST<Integer> tst) {
		List<String> keys = new ArrayList<>();
		tst.keys().forEach(keys::add);
		Collections.shuffle(keys);
		
		TST<Integer> newTST = new TST<>();
		for (String key : keys) {
			Integer val = tst.get(key);
			newTST.put(key, val);
		}
		assertTrue(TSTGenerator.equals(tst, newTST));
	}
	
	@Property
	public void removeAll(@From(TSTGenerator.class) TST<Integer> tst) {
		Iterator<String> it = tst.keys().iterator();
		while(it.hasNext()) {
			String key = it.next();
			TSTGenerator.delete(key, tst);
		}
		assertFalse(tst.keys().iterator().hasNext());
	}
	
	@Property
	public void insertRemove(@From(TSTGenerator.class) TST<Integer> tst) {
		List<String> keys = new ArrayList<>();
		tst.keys().forEach(keys::add);
		
		String key = "someNewKey";
		Integer val = 1;
		tst.put(key, val);
		TSTGenerator.delete(key, tst);
		
		List<String> keys2 = new ArrayList<>();
		tst.keys().forEach(keys2::add);
		
		assertTrue(keys2.size() == keys.size());
		Collections.sort(keys);
		Collections.sort(keys2);
		assertTrue(keys.equals(keys2));
	}
	
	@Property
	public void strictPrefixTest(@From(TSTGenerator.class) TST<Integer> tst) {
		Random r = new Random();
		String prefix = generateString(r,maxPrefixLength);
		int smallPrefixLength = r.nextInt(prefix.length())+1;
		String smallerPrefix = prefix.substring(0, smallPrefixLength);
		int numPuts = r.nextInt(100)+1;
		for(int i = 0; i < numPuts; i++) {
			String newKey = prefix + generateString(r, 20);
			tst.put(newKey, i);
		}
		Iterator<String> it1 = tst.keysWithPrefix(prefix).iterator();
		Iterator<String> it2 = tst.keysWithPrefix(smallerPrefix).iterator();
		int count1 = 0;
		int count2 = 0;
		
		while(it1.hasNext()) {
			count1++;
			it1.next();
		}
		
		while(it2.hasNext()) {
			count2++;
			it2.next();
		}
		assertTrue(count1 <= count2);
	}

	/**
	 * Generates a string with a random size
	 * @param r - Source of random values
	 * @param limit - Limit of Strings size
	 * @return Returns the constructed string
	 */
	private String generateString(Random r, int limit) {
		int size = r.nextInt(limit)+1;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++) {
			int j = r.nextInt(chars.length());
			sb.append(chars.charAt(j));
		}
		return sb.toString();
	}
}
