package sut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LPOStructuralLogicalCoverage {
	/*
	 * p1: c1, where c1: query == null
	 * p2: c2, where c2: query.length() == 0
	 * p3: c3 && c4, where c3: x != null; c4: i < query.length()
	 * p4: c5, where c5: c < x.c
	 * p5: c6, where c6: c > x.c
	 * p6: c7, where c7: x.val != null
	 * ==================================================
	 * p1 r(p1) = true
	 * p2 r(p2) = r(p1) && !p1 = true && query != null
	 * p3 r(p3) = r(p2) && !p2 = true && query != null && query.length != 0
	 * p4 r(p4) = r(p3) && p3 = true && query != null && query.length != 0 && x != null && i < query.length()
	 * p5 r(p5) = r(p4) && !p4 = true && query != null && query.length != 0 && x != null && i < query.length() && c >= x.c
	 * p6 r(p6) = r(p5) && !p5 = true && query != null && query.length != 0 && x != null && i < query.length() && c <= x.c
	 */
	
	TST<Integer> tst;
	
	@BeforeEach
	public void initializeObject() {
		tst = new TST<>();
	}
	
	/**
	 * Reach & cover: p1,c1
	 */
	@Test
	public void slTest1 () {
		String query = null;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.longestPrefixOf(query);
		});
	}
	
	/**
	 * Reach & cover: !p1,!c1,p2,c2
	 */
	@Test
	public void slTest2 () {
		String query = "";
		assertEquals(null,tst.longestPrefixOf(query));
	}
	
	/**
	 * Reach & cover: !p1,!c1,!p2,!c2,p3,c3,c4,!c3,p4,c5
	 */
	@Test
	public void slTest3 () {
		String query = "a";
		String key = "c";
		Integer val = 1;
		tst.put(key, val);
		assertEquals("",tst.longestPrefixOf(query));
	}
	
	/**
	 * Reach & cover: !p1,!c1,!p2,!c2,p3,c3,c4,!c3,!p4,!c5,p5,c6
	 */
	@Test
	public void slTest4 () {
		String query = "d";
		String key = "c";
		Integer val = 1;
		tst.put(key, val);
		assertEquals("",tst.longestPrefixOf(query));
	}
	
	/**
	 * Reach & cover: !p1,!c1,!p2,!c2,p3,c3,c4,!c3,!p4,!c5,!p5,!c6,!p6,!c7
	 */
	@Test
	public void slTest5 () {
		String query = "c";
		String key1 = "c";
		Integer val = null;
		tst.put(key1, val);
		assertEquals("",tst.longestPrefixOf(query));
	}
	
	/**
	 * Reach & cover: !p1,!c1,!p2,!c2,p3,c3,c4,!c3,!p4,!c5,!p5,!c6,p6,c7
	 */
	@Test
	public void slTest6 () {
		String query = "c";
		String key1 = "c";
		Integer val = 1;
		tst.put(key1, val);
		assertEquals("c",tst.longestPrefixOf(query));
	}
	
	/**
	 * Reach & cover: !p1,!c1,!p2,!c2,p3,c3,c4,!p3,!c4,!c3,!p4,!c5,!p5,!c6,!p6,!c7
	 * Teste espcifico para fazer cover a !c4
	 */
	@Test
	public void slTest7 () {
		String query = "c";
		String key1 = "c";
		String key2 = "ca";
		Integer val = null;
		tst.put(key1, val);
		tst.put(key2, val);
		assertEquals("",tst.longestPrefixOf(query));
	}
}
