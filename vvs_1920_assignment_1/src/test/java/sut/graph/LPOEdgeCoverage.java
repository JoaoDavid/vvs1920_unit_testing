package sut.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sut.TST;

@DisplayName("Edge coverage test")
public class LPOEdgeCoverage {
	TST<Integer> tst;
	
	@BeforeEach
	public void initializeObject() {
		tst = new TST<>();
	}
	
	/*[1,2]*/
	@Test
	public void lpoEdgeCoverage1() {
		String query = null;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.longestPrefixOf(query);
		});
	}

	/*[1,3],[3,4]*/
	@Test
	public void lpoEdgeCoverage2() {
		String query = "";
		assertEquals(null, tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,10,6,7]*/
	@Test
	public void lpoEdgeCoverage3() {
		String key = "c";
		String query = "a";
		int value = 1;
		tst.put(key, value);
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,11,6,7]*/
	@Test
	public void lpoEdgeCoverage4() {
		String key = "c";
		String query = "d";
		int value = 1;
		tst.put(key, value);
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,12,14,6,7]*/
	@Test
	public void lpoEdgeCoverage5() {
		String key = "c";
		String query = "c";
		Integer value = null;
		tst.put(key, value);
		//key value pairs with null values don't get added
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,12,13,14,6,7]*/
	@Test
	public void lpoEdgeCoverage6() {
		String key = "c";
		String query = "c";
		Integer value = (Integer) 5;
		tst.put(key, value);
		assertEquals("c", tst.longestPrefixOf(query));
	}
}
