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
	
	/*[1,3,5,6,8,10,6,8,10,6,7]*/
	@Test
	public void lpoPrimePathCoverage4() {
		String query = "a";
		Integer val = 0;
		tst.put("c", val);
		tst.put("b", val);
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,11,6,8,9,11,6,7]*/
	@Test
	public void lpoPrimePathCoverage5() {
		String query = "e";
		Integer val = 0;
		tst.put("c", val);
		tst.put("d", val);
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,11,6,8,10,6,7]*/
	@Test
	public void lpoPrimePathCoverage6() {
		String query = "c";
		Integer val = 0;
		tst.put("b", val); //c > b
		tst.put("d", val); //c < d
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,10,6,8,9,11,6,7]*/
	@Test
	public void lpoPrimePathCoverage7() {
		String query = "c";
		Integer val = 0;
		tst.put("d", val); //c < d
		tst.put("b", val); //c > b
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,11,6,8,9,12,14,6,7]*/
	@Test
	public void lpoPrimePathCoverage8() {
		String query = "c";
		Integer val = null;
		tst.put("b", val); //c < b
		tst.put("c", val); //c == c
		tst.longestPrefixOf(query);
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,12,14,6,8,9,12,14,6,7]*/
	@Test
	public void lpoPrimePathCoverage9() {
		String query = "ca";
		Integer val = null;
		tst.put("c", val); //c == c
		tst.put("ca", val); //a == a
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,12,14,6,8,9,11,6,7]*/
	@Test
	public void lpoPrimePathCoverage10() {
		String query = "cb";
		Integer val = null;
		tst.put("c", val); //c == c
		tst.put("ca", val); //b > a
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,10,6,8,9,12,14,6,7]*/
	@Test
	public void lpoPrimePathCoverage11() {
		String query = "c";
		Integer val = null;
		tst.put("d", val); //c < d
		tst.put("c", val); //c == d
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,12,14,6,8,10,6,7]*/
	@Test
	public void lpoPrimePathCoverage12() {
		String query = "ca";
		Integer val = null;
		tst.put("c", val); //c == c
		tst.put("cb", val); //a < b
		assertEquals("", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,11,6,8,9,12,13,14,6,7]*/
	@Test
	public void lpoPrimePathCoverage13() {
		String query = "c";
		Integer val = 1;
		tst.put("b", val); //c > b
		tst.put("c", val); //c == c
		assertEquals("c", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,12,13,14,6,8,9,12,14,6,7]*/
	@Test
	public void lpoPrimePathCoverage14() {
		String query = "ca";
		Integer val1 = 1; //pass through 13
		Integer val2 = null; //skip 13
		tst.put("c", val1); //c == c
		//if no value is pressent, ignores
		tst.put("ca", val2); //a == a
		assertEquals("c", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,12,14,6,8,9,12,13,14,6,7]*/
	@Test
	public void lpoPrimePathCoverage15() {
		String query = "ca";
		Integer val1 = null; //skip 13
		Integer val2 = 1; //pass through 13
		tst.put("c", val1); //c == c
		tst.put("ca", val2); //a == a
		assertEquals("ca", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,12,13,14,6,8,9,12,13,14,6,7]*/
	@Test
	public void lpoPrimePathCoverage16() {
		String query = "ca";
		Integer val1 = 1; //pass through 13
		tst.put("c", val1); //c == c
		tst.put("ca", val1); //a == a
		assertEquals("ca", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,12,13,14,6,8,9,11,6,7]*/
	@Test
	public void lpoPrimePathCoverage17() {
		String query = "cb";
		Integer val1 = 1; //pass through 13
		tst.put("c", val1); //c == c
		tst.put("ca", val1); //b > a
		assertEquals("c", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,10,6,8,9,12,13,14,6,7]*/
	@Test
	public void lpoPrimePathCoverage18() {
		String query = "c";
		Integer val1 = 1; //pass through 13
		tst.put("d", val1); //c < d
		tst.put("c", val1); //c == c
		assertEquals("c", tst.longestPrefixOf(query));
	}
	
	/*[1,3,5,6,8,9,12,13,14,6,8,10,6,7]*/
	@Test
	public void lpoPrimePathCoverage19() {
		String query = "ca";
		Integer val1 = 1; //pass through 13
		tst.put("c", val1); //c == c
		tst.put("cb", val1); //a < b
		assertEquals("c", tst.longestPrefixOf(query));
	}
}
