package sut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LPOPrimePathCoverage {
	TST<Integer> tst;
	
	@BeforeEach
	public void initializeObject() {
		tst = new TST<>();
	}
	
	/*[1,2]*/
	@Test
	public void lpoPrimePathCoverage1() {
		String query = null;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.longestPrefixOf(query);
		});
	}

	/*[1,3,4]*/
	@Test
	public void lpoPrimePathCoverage2() {
		String query = "";
		assertEquals(null, tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,7]*/
	@Test
	public void lpoPrimePathCoverage3() {
		String query = "query";
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*	[1,3,5,6,8,10], [6,8,10,6], [8,10,6,8], [8,10,6,7], [10,6,8,10]*/
	@Test
	public void lpoPrimePathCoverage4() {
		String query = "a";
		Integer val = 0;
		tst.put("c", val);
		tst.put("b", val);
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*	[1,3,5,6,8,9,11], [6,8,9,11,6], [8,9,11,6,7], [8,9,11,6,8], [9,11,6,8,9], [11,6,8,9,11]*/
	@Test
	public void lpoPrimePathCoverage5() {
		String query = "e";
		Integer val = 0;
		tst.put("c", val);
		tst.put("d", val);
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	@Test
	public void lpoPrimePathCoverage6() {
		String query = "e";
		Integer val = 0;
		tst.put("c", val);
		tst.put("d", val);
		assertEquals("", tst.longestPrefixOf(query));
	}
}
