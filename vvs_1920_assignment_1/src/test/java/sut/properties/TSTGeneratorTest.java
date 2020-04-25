package sut.properties;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import sut.TST;

@RunWith(JUnitQuickcheck.class)
public class TSTGeneratorTest {
	
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
}
