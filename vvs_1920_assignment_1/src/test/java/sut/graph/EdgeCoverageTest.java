package sut.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * The test methods within this class focus on the Edge Coverage of the TST's longestPrefixOf method graph
 * An image of the graph analyzed is appended to this eclipse project
 * 
 * Graph Edges: [1 2], [1,3], [3,4], [3,5], [5,6], [6,7], [6,8], [8,9], [8,10], 
 *              [10,6], [9,12], [9,11], [11,6], [12,13], [12,14], [13,14], [14,6]
 */
public class EdgeCoverageTest {
	TST<Integer> tst;
	
	@Before
	public void initializeObject() {
		tst = new TST<>();
	}
	
	
	/**
	 * Test path:     [1,2]
	 * Edges Covered: [1,2]
	 */
	@Test
	public void edgeCoverage1() {
		String query = null;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.longestPrefixOf(query);
		});
	}


	/**
	 * Test path:     [1,3,4]
	 * Edges Covered: [1,3], [3,4]
	 */
	@Test
	public void edgeCoverage2() {
		String query = "";
		assertNull(tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,10,6,7]
	 * Edges Covered: [1,3], [3,5], [5,6], [6,8], [8,10], [10,6], [6,7]
	 */
	@Test
	public void edgeCoverage3() {
		String key = "c";
		String query = "a";
		int value = 1;
		tst.put(key, value);
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,11,6,7]
	 * Edges Covered: [1,3], [3,5], [5,6], [6,8], [8,9], [9,11], [11,6], [6,7]
	 */
	@Test
	public void edgeCoverage4() {
		String key = "c";
		String query = "d";
		int value = 1;
		tst.put(key, value);
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,12,14,6,7]
	 * Edges Covered: [1,3], [3,5], [5,6], [6,8], [8,9], [9,12], [12,14], [14,6], [6,7]
	 */
	@Test
	public void edgeCoverage5() {
		String key = "c";
		String query = "c";
		Integer value = null;
		tst.put(key, value);
		//key value pairs with null values don't get added
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,12,13,14,6,7]
	 * Edges Covered: [1,3], [3,5], [5,6], [6,8], [8,9], [9,12], [12,13], [13,14], [14,6], [6,7]
	 */
	@Test
	public void edgeCoverage6() {
		String key = "c";
		String query = "c";
		int value = 5;
		tst.put(key, value);
		assertEquals("c", tst.longestPrefixOf(query));
	}
}
