package sut.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * @author João David n49448, Ye Yang n49521
 * 
 * The test methods within this class focus on the Prime Path Coverage of the TST's longestPrefixOf method graph
 * An image of the graph analyzed is appended to this eclipse project
 * 
 *           Prime Path                Covered By (primePathCoverageX) X=method number
       [1,3,5,6,8,9,12,13,14]                  14, 16, 17, 19
       [1,3,5,6,8,9,12,14]                     9, 10, 12, 15
       [6,8,9,12,13,14,6]                      13, 14, 15, 16, 17, 18, 19
       [8,9,12,13,14,6,7]                      13, 15, 16, 18
       [8,9,12,13,14,6,8]                      14, 16, 17, 19
       [1,3,5,6,8,9,11]                        5, 6, 8, 13
       [10,6,8,9,12,13,14]                     18
       [12,13,14,6,8,9,11]                     17
       [13,14,6,8,9,12,13]                     16
       [14,6,8,9,12,13,14]                     15,16
       [12,13,14,6,8,9,12]                     14, 16
       [9,12,13,14,6,8,9]                      14, 16, 17
       [9,12,13,14,6,8,10]                     19
       [11,6,8,9,12,13,14]                     13
       [8,9,12,14,6,7]                         8, 9, 11, 14
       [6,8,9,12,14,6]                         8, 9, 10, 11, 12, 14, 15
       [8,9,12,14,6,8]                         9, 10, 12, 15
       [10,6,8,9,12,14]                        11
       [1,3,5,6,8,10]                          4, 7, 11, 18
       [12,14,6,8,9,11]                        10
       [12,14,6,8,9,12]                        9, 15
       [14,6,8,9,12,14]                        9, 14
       [9,12,14,6,8,10]                        12
       [9,12,14,6,8,9]                         9, 10, 15
       [11,6,8,9,12,14]                        8
       [6,8,9,11,6]                            5, 6, 7, 8, 10, 13, 17
       [8,9,11,6,7]                            5, 7, 10, 17
       [10,6,8,9,11]                           7
       [8,9,11,6,8]                            5, 6, 8, 13
       [1,3,5,6,7]                             3
       [9,11,6,8,9]                            5, 8, 13
       [9,11,6,8,10]                           6
       [11,6,8,9,11]                           5
       [6,8,10,6]                              4, 6, 7, 11, 12, 18, 19
       [8,10,6,8]                              4, 7, 11, 18
       [8,10,6,7]                              4, 6, 12, 19
       [10,6,8,10]                             4
       [1,3,4]                                 2             
       [1,2]                                   1     
 * 
 */
public class PrimePathCoverageTest {
	TST<Integer> tst;
	
	@Before
	public void initializeObject() {
		tst = new TST<>();
	}
	

	/**
	 * Test path:     [1,2]
	 */
	@Test
	public void primePathCoverage1() {
		String query = null;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.longestPrefixOf(query);
		});
	}


	/**
	 * Test path:     [1,3,4]
	 */
	@Test
	public void primePathCoverage2() {
		String query = "";
		assertNull(tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,7]
	 */
	@Test
	public void primePathCoverage3() {
		String query = "query";
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,10,6,8,10,6,7]
	 */
	@Test
	public void primePathCoverage4() {
		String query = "a";
		Integer val = 0;
		tst.put("c", val);
		tst.put("b", val);
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,11,6,8,9,11,6,7]
	 */
	@Test
	public void primePathCoverage5() {
		String query = "e";
		Integer val = 0;
		tst.put("c", val);
		tst.put("d", val);
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,11,6,8,10,6,7]
	 */
	@Test
	public void primePathCoverage6() {
		String query = "c";
		Integer val = 0;
		tst.put("b", val); //c > b
		tst.put("d", val); //c < d
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,10,6,8,9,11,6,7]
	 */
	@Test
	public void primePathCoverage7() {
		String query = "c";
		Integer val = 0;
		tst.put("d", val); //c < d
		tst.put("b", val); //c > b
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,11,6,8,9,12,14,6,7]
	 */
	@Test
	public void primePathCoverage8() {
		String query = "c";
		Integer val = null;
		tst.put("b", val); //c < b
		tst.put("c", val); //c == c
		tst.longestPrefixOf(query);
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,12,14,6,8,9,12,14,6,7]
	 */
	@Test
	public void primePathCoverage9() {
		String query = "ca";
		Integer val = null;
		tst.put("c", val); //c == c
		tst.put("ca", val); //a == a
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,12,14,6,8,9,11,6,7]
	 */
	@Test
	public void primePathCoverage10() {
		String query = "cb";
		Integer val = null;
		tst.put("c", val); //c == c
		tst.put("ca", val); //b > a
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,10,6,8,9,12,14,6,7]
	 */
	@Test
	public void primePathCoverage11() {
		String query = "c";
		Integer val = null;
		tst.put("d", val); //c < d
		tst.put("c", val); //c == d
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,12,14,6,8,10,6,7]
	 */
	@Test
	public void primePathCoverage12() {
		String query = "ca";
		Integer val = null;
		tst.put("c", val); //c == c
		tst.put("cb", val); //a < b
		assertEquals("", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,11,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void primePathCoverage13() {
		String query = "c";
		Integer val = 1;
		tst.put("b", val); //c > b
		tst.put("c", val); //c == c
		assertEquals("c", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,12,13,14,6,8,9,12,14,6,7]
	 */
	@Test
	public void primePathCoverage14() {
		String query = "ca";
		Integer val1 = 1; //pass through 13
		Integer val2 = null; //skip 13
		tst.put("c", val1); //c == c
		//if no value is pressent, ignores
		tst.put("ca", val2); //a == a
		assertEquals("c", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,12,14,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void primePathCoverage15() {
		String query = "ca";
		Integer val1 = null; //skip 13
		Integer val2 = 1; //pass through 13
		tst.put("c", val1); //c == c
		tst.put("ca", val2); //a == a
		assertEquals("ca", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,12,13,14,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void primePathCoverage16() {
		String query = "ca";
		Integer val1 = 1; //pass through 13
		tst.put("c", val1); //c == c
		tst.put("ca", val1); //a == a
		assertEquals("ca", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,12,13,14,6,8,9,11,6,7]
	 */
	@Test
	public void primePathCoverage17() {
		String query = "cb";
		Integer val1 = 1; //pass through 13
		tst.put("c", val1); //c == c
		tst.put("ca", val1); //b > a
		assertEquals("c", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,10,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void primePathCoverage18() {
		String query = "c";
		Integer val1 = 1; //pass through 13
		tst.put("d", val1); //c < d
		tst.put("c", val1); //c == c
		assertEquals("c", tst.longestPrefixOf(query));
	}
	

	/**
	 * Test path:     [1,3,5,6,8,9,12,13,14,6,8,10,6,7]
	 */
	@Test
	public void primePathCoverage19() {
		String query = "ca";
		Integer val1 = 1; //pass through 13
		tst.put("c", val1); //c == c
		tst.put("cb", val1); //a < b
		assertEquals("c", tst.longestPrefixOf(query));
	}
}
