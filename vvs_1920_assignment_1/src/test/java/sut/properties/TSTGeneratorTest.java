package sut.properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import sut.TST;

@RunWith(JUnitQuickcheck.class)
public class TSTGeneratorTest {	

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
		assertTrue(tst.equals(newTST));
	}

	@Property
	public void removeAll(@From(TSTGenerator.class) TST<Integer> tst) {
		Iterator<String> it = tst.keys().iterator();
		while(it.hasNext()) {
			String key = it.next();
			tst.delete(key);
		}
		TST<Integer> emptyTST = new TST<>();
		assertEquals(0,tst.size());
		assertTrue(tst.equals(emptyTST));
	}

	@Property
	public void insertRemove(@From(TSTGenerator.class) TST<Integer> tst, @From(MyStringGenerator.class) String key, int val) {
		if(!tst.contains(key)) {
			TST<Integer> other = new TST<Integer>();
			Iterable<String> tstIte = tst.keys();
			for (String currStr : tstIte) {
				other.put(currStr, tst.get(currStr));
			}
			tst.put(key, val);
			tst.delete(key);
			assertTrue(tst.equals(other));			
		}
	}

	@Property
	public void strictPrefixTest(@From(TSTGenerator.class) TST<Integer> tst,@InRange(min = "0")  int index, @From(MyStringGenerator.class) String prefix) {
		Iterable<String> setLargerPrefix = tst.keysWithPrefix(prefix);
		List<String> listLargerPrexix = new LinkedList<>();
		setLargerPrefix.forEach(listLargerPrexix::add);
		if(prefix.length() > 2) {
			String currStricterPrefix = prefix;
			for(int i = prefix.length(); i > 2; i--) {
				System.out.println(currStricterPrefix);
				currStricterPrefix = currStricterPrefix.substring(0, i);
				Iterable<String> setCurrPrefix = tst.keysWithPrefix(currStricterPrefix);
				for (String curr : setCurrPrefix) {
					assertTrue(listLargerPrexix.contains(curr));
				}
			}
		}
	}

}
