package sut.isp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sut.TST;

public class BCCTest {
	/* Criteria:
	 * 		- "Trie already includes the new key"
	 * 			- Blocks: true, false
	 * 		- "Trie already includes some new key prefix"
	 * 			- Blocks: true, false
	 * 		- "Trie is empty"
	 * 			- Blocks: true, false
	 * 
	 * 		Base choice: (true, true, false)
	 */
	
	TST<Integer> tst;
	
	@BeforeEach
	public void initializeObject() {
		tst = new TST<>();
	}

	//(true,true,false)
	@Test
	public void t1() {
		String key1 = "key";
		String key2 = "keys";
		Integer val1 = 1;
		Integer val2 = 2;
		tst.put(key1, val1);
		tst.put(key2, val1);
		assertEquals(val1,tst.get(key2));
		tst.put(key2, val2);
		assertEquals(val2,tst.get(key2));
	}
	
	//(false,true,false)
	@Test
	public void t2() {
		String newKey = "keys";
		String newKeyPrefix = "key";
		Integer val = 1;
		tst.put(newKeyPrefix, val);
		assertFalse(tst.contains(newKey));
		assertTrue(tst.contains(newKeyPrefix));
		tst.put(newKey, val);
		assertTrue(tst.contains(newKey));
	}
	
	//(true,false,false)
	@Test
	public void t3() {
		String newKey = "keys";
		String newKeyPrefix = "key";
		Integer val = 1;
		tst.put(newKey, val);
		assertTrue(tst.contains(newKey));
		assertFalse(tst.contains(newKeyPrefix));
	}
	
	
	//(true,true,true)
	@Test
	public void t4() {
		assertEquals(0,tst.size());
		String key = "keys";
		String prefix = "key";
		Integer val1 = 1;
		tst.put(key, val1);
		tst.put(prefix, val1);

		String newKey = "keys";
		String newKeyPrefix = "key";
		Integer val2 = 2;
		assertTrue(tst.contains(key));
		assertTrue(tst.contains(prefix));
		tst.put(newKey, val2);
		tst.put(newKeyPrefix, val2);
		assertEquals(val2, tst.get(newKey));
		assertEquals(val2, tst.get(newKeyPrefix));
	}
}
