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

/**
 * @author João David n49448, Ye Yang n49521
 * 
 * Property testing class
 * 
 */
@RunWith(JUnitQuickcheck.class)
public class TSTGeneratorTest {	

	/*
	 * Property: The order of insertion of dierent keys does not change the nal tree value
	 */
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

	/*
	 * Property: If you remove all keys from a tree, the tree must be empty
	 */
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

	/*
	 * Property: Given a tree, inserting and then removing the same key value will not change its initial value
	 */
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

	/*
	 * Property: Selecting a stricter prefix keysWithPrefix returns a strict subset result.
	 */
	@Property
	public void strictPrefixTest(@From(TSTGenerator.class) TST<Integer> tst,@InRange(min = "0")  int index, @From(MyStringGenerator.class) String key) {
		if(key.length() >= 2 ) { //testing only longer keys
			//Adding several substrings from a certain "key" string, 
			//e.g. key=potato, will result in inserting: potato, potat, pota, pot, po, p
			for(int i = key.length(); i > 1; i--) {
				tst.put(key.substring(0,i), index);
			}
			//For instance, the loop verifies that all keys with prefix <x> has all keys with prefix <y>
			//  <x>              <y>
			// potat            potato
			// pota             potat
			// pot              pota
			// po               pot
			// p                po
			// Therefore we can conclude that keys with prefix p contains all keys with prefix potato
			Iterable<String> setLongerPrefix = tst.keysWithPrefix(key);
			List<String> listLongerPrefix = new LinkedList<>();
			setLongerPrefix.forEach(listLongerPrefix::add);
			for(int i = key.length()-1; i > 2; i--) {
				String currStricterPrefix = key.substring(0, i);
				Iterable<String> setCurrrPrefix = tst.keysWithPrefix(currStricterPrefix);
				List<String> listCurrPrefix = new LinkedList<>();
				setCurrrPrefix.forEach(listCurrPrefix::add);
				assertTrue(listLongerPrefix.size() <= listCurrPrefix.size());
				for (String curr : listLongerPrefix) {
					assertTrue(listCurrPrefix.contains(curr));
				}
				listLongerPrefix = listCurrPrefix;
			}
		}
	}

}
