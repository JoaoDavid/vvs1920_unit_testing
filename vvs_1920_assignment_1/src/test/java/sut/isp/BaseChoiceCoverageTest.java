package sut.isp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * The test methods within this class focus on the BaseChoiceCoverage
 * 
 * Criteria:
 * Trie already includes the new key
 *     Block: [true, false]
 *     
 * Trie already includes some new key prefix
 *     Block: [true, false]
 *     
 * Trie is empty
 * 	    Block: [true, false]
 * 
 * 
 * Base choice #1: (true, true, false)
 * 
 * Tests: (true, true, false)
 *        (false, true, false)
 *        (true, false, false)
 *        (true, true, true) -> unfeasible because we can't have an empty trie,
 *                              and at the same time have some key prefix and the key
 *                              included in the trie
 *                              empty trie implies no keys inserted
 * 
 * 
 */
public class BaseChoiceCoverageTest {

	TST<Integer> tst;

	@Before
	public void initializeObject() {
		tst = new TST<>();
	}


	/**
	 * Trie already includes the new key:         true
	 * Trie already includes some new key prefix: true
	 * Trie is empty:                             false
	 * 
	 * Test: (true,true,false)
	 */
	@Test
	public void bcc1() {
		// Prepare Trie
		String keyPrefix = "sh";
		String key = "shore";
		Integer val1 = 1;
		Integer val2 = 2;
		tst.put(keyPrefix, val1);
		tst.put(key, val2);
		// Verifying it's state before the put test
		assertEquals(val1, tst.get(keyPrefix));
		assertEquals(val2, tst.get(key));
		assertEquals(2, tst.size());
		assertTrue(tst.contains(key));
		assertTrue(tst.contains(keyPrefix));
		// Actual put test
		Integer newVal = 3;
		tst.put(key, newVal);
		assertEquals(val1, tst.get(keyPrefix));
		assertEquals(newVal, tst.get(key));
		assertEquals(2, tst.size());
		assertTrue(tst.contains(key));
		assertTrue(tst.contains(keyPrefix));
	}


	/**
	 * Trie already includes the new key:         false
	 * Trie already includes some new key prefix: true
	 * Trie is empty:                             false
	 * 
	 * Test: (false,true,false)
	 */
	@Test
	public void bcc2() {
		// Prepare Trie
		String keyPrefix = "sh";
		String key = "shore";
		Integer val1 = 1;
		tst.put(keyPrefix, val1);
		// Verifying it's state before the put test
		assertEquals(val1, tst.get(keyPrefix));
		assertNull(tst.get(key));
		assertEquals(1, tst.size());
		assertFalse(tst.contains(key));
		assertTrue(tst.contains(keyPrefix));
		// Actual put test
		Integer newVal = 3;
		tst.put(key, newVal);
		assertEquals(val1, tst.get(keyPrefix));
		assertEquals(newVal, tst.get(key));
		assertEquals(2, tst.size());
		assertTrue(tst.contains(key));
		assertTrue(tst.contains(keyPrefix));
	}


	/**
	 * Trie already includes the new key:         true
	 * Trie already includes some new key prefix: false
	 * Trie is empty:                             false
	 * 
	 * Test: (true,false,false)
	 */
	@Test
	public void bcc3() {
		// Prepare Trie
		String key = "shore";
		Integer val1 = 1;
		tst.put(key, val1);
		// Verifying it's state before the put test
		assertEquals(val1, tst.get(key));
		assertEquals(1, tst.size());
		assertTrue(tst.contains(key));
		// Actual put test
		Integer newVal = 3;
		tst.put(key, newVal);
		assertNotEquals(val1, tst.get(key));
		assertEquals(newVal, tst.get(key));
		assertEquals(1, tst.size());
		assertTrue(tst.contains(key));
	}
}
