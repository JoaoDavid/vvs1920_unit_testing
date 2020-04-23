package sut.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sut.TST;

@DisplayName("All Uses Coverage Test")
public class AllUsesCoverage {	

	TST<Integer> tst;

	@BeforeEach
	public void initializeObject() {
		tst = new TST<>();
	}

	/**
	 * Test path: [1,2]
	 */
	@Test
	public void t1() {
		assertThrows(IllegalArgumentException.class, () -> {
			tst.longestPrefixOf(null);
		});		
	}

	/**
	 * Test path: [1,3,4]
	 */
	@Test
	public void t2() {
		assertNull(tst.longestPrefixOf(""));
	}
	
	/**
	 * Test path: [1,3,5,6,7]
	 */
	@Test
	public void t3() {
		assertEquals("", tst.longestPrefixOf("query"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,10,6,7]
	 */
	@Test
	public void t4() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("a"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,11,6,7]
	 */
	@Test
	public void t5() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("t"));
	}
		
	/**
	 * Test path: [1,3,5,6,8,9,12,13,14,6,8,9,12,14,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void t6() {
		tst.put("sea", 1);
		tst.put("s", 2);
		tst.put("e", 3);
		tst.put("a", 4);
		assertEquals("sea", tst.longestPrefixOf("sea"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,12,14,6,8,9,12,14,6,8,9,11,6,7]
	 */
	@Test
	public void t7() {
		tst.put("sea", 1);
		tst.put("t", 2);
		tst.put("a", 4);
		assertEquals("", tst.longestPrefixOf("set"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,10,6,8,9,11,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void t8() {
		tst.put("sea", 1);
		tst.put("ball", 2);
		tst.put("c", 3);
		assertEquals("c", tst.longestPrefixOf("c"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,10,6,8,10,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void t9() {
		tst.put("sea", 1);
		tst.put("cat", 2);
		tst.put("b", 3);
		assertEquals("b", tst.longestPrefixOf("b"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,11,6,8,9,11,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void t10() {
		tst.put("sea", 1);
		tst.put("up", 2);
		tst.put("w", 3);
		assertEquals("w", tst.longestPrefixOf("w"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,12,14,6,8,10,6,7]
	 */
	@Test
	public void t11() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("sd"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,12,14,6,8,9,11,6,7]
	 */
	@Test
	public void t12() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("su"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,11,6,8,10,6,7]
	 */
	@Test
	public void t13() {
		tst.put("sea", 1);
		tst.put("w", 2);
		assertEquals("", tst.longestPrefixOf("t"));
	}

}
