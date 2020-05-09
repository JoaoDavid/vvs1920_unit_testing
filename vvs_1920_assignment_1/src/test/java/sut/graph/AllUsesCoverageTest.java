package sut.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * @author João David n49448, Ye Yang n49521
 * 
 * The test methods within this class focus on the All Uses Coverage of the TST's longestPrefixOf method graph
 * 
 * Each test method has it's test path commented
 * The detailed documentation regarding AUC is in the report (section All Uses Coverage)
 * 
 */
@DisplayName("All Uses Coverage Test")
public class AllUsesCoverageTest {	

	TST<Integer> tst;

	@Before
	public void initializeObject() {
		tst = new TST<>();
	}

	/**
	 * Test path: [1,2]
	 */
	@Test
	public void allUsesCoverageTest1() {
		assertThrows(IllegalArgumentException.class, () -> {
			tst.longestPrefixOf(null);
		});		
	}

	/**
	 * Test path: [1,3,4]
	 */
	@Test
	public void allUsesCoverageTest2() {
		assertNull(tst.longestPrefixOf(""));
	}
	
	/**
	 * Test path: [1,3,5,6,7]
	 */
	@Test
	public void allUsesCoverageTest3() {
		assertEquals("", tst.longestPrefixOf("query"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,10,6,7]
	 */
	@Test
	public void allUsesCoverageTest4() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("a"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,11,6,7]
	 */
	@Test
	public void allUsesCoverageTest5() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("t"));
	}
		
	/**
	 * Test path: [1,3,5,6,8,9,12,13,14,6,8,9,12,14,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void allUsesCoverageTest6() {
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
	public void allUsesCoverageTest7() {
		tst.put("sea", 1);
		tst.put("t", 2);
		tst.put("a", 4);
		assertEquals("", tst.longestPrefixOf("set"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,10,6,8,9,11,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void allUsesCoverageTest8() {
		tst.put("sea", 1);
		tst.put("ball", 2);
		tst.put("c", 3);
		assertEquals("c", tst.longestPrefixOf("c"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,10,6,8,10,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void allUsesCoverageTest9() {
		tst.put("sea", 1);
		tst.put("cat", 2);
		tst.put("b", 3);
		assertEquals("b", tst.longestPrefixOf("b"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,11,6,8,9,11,6,8,9,12,13,14,6,7]
	 */
	@Test
	public void allUsesCoverageTest10() {
		tst.put("sea", 1);
		tst.put("up", 2);
		tst.put("w", 3);
		assertEquals("w", tst.longestPrefixOf("w"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,12,14,6,8,10,6,7]
	 */
	@Test
	public void allUsesCoverageTest11() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("sd"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,12,14,6,8,9,11,6,7]
	 */
	@Test
	public void allUsesCoverageTest12() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("su"));
	}
	
	/**
	 * Test path: [1,3,5,6,8,9,11,6,8,10,6,7]
	 */
	@Test
	public void allUsesCoverageTest13() {
		tst.put("sea", 1);
		tst.put("w", 2);
		assertEquals("", tst.longestPrefixOf("t"));
	}
	
	/*@Test
	public void allUsesCoverageTest14() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("se"));
	}*/

}
