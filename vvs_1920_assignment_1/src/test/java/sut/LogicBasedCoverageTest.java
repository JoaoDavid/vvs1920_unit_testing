package sut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import sut.TST;

/**
 * @author João David n49448, Ye Yang n49521
 * 
 * The test methods within this class focus on the Logic Based Coverage of the TST's longestPrefixOf method graph
 * The criteria chosen was the Combinatorial Coverage (CoC) because it covers all possible combinations of clause's truth values within each predicate
 * therefore it subsumes RACC, CAACC, GACC, CC and PC
 * Since the method in study (longestPrefixOf) is highly complex, it's viable to opt for this criteria
 * 
 * Each test method has its reach and cover commented
 * 
 * p1: c1,       where c1: query == null
 * p2: c2,       where c2: query.length() == 0
 * p3: c3 && c4, where c3: x != null; c4: i < query.length()
 * p4: c5,       where c5: c < x.c
 * p5: c6,       where c6: c > x.c
 * p6: c7,       where c7: x.val != null
 * ==================================================
 * p1 r(p1) = true
 * p2 r(p2) = r(p1) && !p1
 * p3 r(p3) = r(p2) && !p2
 * p4 r(p4) = r(p3) &&  p3 
 * p5 r(p5) = r(p4) && !p4 
 * p6 r(p6) = r(p5) && !p5 
 * ==================================================
 * 
 * TR(CoC) =  {c1, ¬c1,
 *             c2, ¬c2, 
			   c3 && c4, ¬c3 && c4, c3 && ¬c4, ¬c3 && ¬c4,
			   c5, ¬c5, 
			   c6, ¬c6, 
			   c7, ¬c7}
 *
 */
public class LogicBasedCoverageTest {

	TST<Integer> tst;

	@Before
	public void initializeObject() {
		tst = new TST<>();
	}

	/**
	 * Reach & cover: p1,c1
	 */
	@Test
	public void cocTest1 () {
		String query = null;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.longestPrefixOf(query);
		});
	}

	/**
	 * Reach & cover: ¬p1,¬c1, p2,c2
	 */
	@Test
	public void cocTest2 () {
		String query = "";
		assertEquals(null,tst.longestPrefixOf(query));
	}

	/**
	 * Reach & cover: ¬p1,¬c1, ¬p2,¬c2, p3,c3,c4, p4,c5, ¬p3,¬c3,c4
	 */
	@Test
	public void cocTest3 () {
		String query = "a";
		String key = "c";
		Integer val = 1;
		tst.put(key, val);
		assertEquals("",tst.longestPrefixOf(query));
	}

	/**
	 * Reach & cover: ¬p1,¬c1, ¬p2,¬c2, p3,c3,c4, ¬p4,¬c5, p5,c6 ¬p3,¬c3,c4
	 */
	@Test
	public void cocTest4 () {
		String query = "d";
		String key = "c";
		Integer val = 1;
		tst.put(key, val);
		assertEquals("",tst.longestPrefixOf(query));
	}

	/**
	 * Reach & cover: ¬p1,¬c1, ¬p2,¬c2, p3,c3,c4, ¬p4,¬c5, ¬p5,¬c6, ¬p6,¬c7, ¬p3,¬c3,¬c4
	 */
	@Test
	public void cocTest5 () {
		String query = "c";
		String key1 = "c";
		Integer val = null;
		tst.put(key1, val);
		assertEquals("",tst.longestPrefixOf(query));
	}

	/**
	 * Reach & cover: ¬p1,¬c1, ¬p2,¬c2, p3,c3,c4, ¬p4,¬c5, ¬p5,¬c6, p6,c7, ¬p3,¬c3,¬c4
	 */
	@Test
	public void cocTest6 () {
		String query = "c";
		String key1 = "c";
		Integer val = 1;
		tst.put(key1, val);
		assertEquals("c",tst.longestPrefixOf(query));
	}

	/**
	 * Reach & cover: ¬p1,¬c1, ¬p2,¬c2, p3,c3,c4, ¬p4,¬c5, ¬p5,¬c6, ¬p6,¬c7, ¬p3,c3,¬c4
	 */
	@Test
	public void cocTest7 () {
		String query = "c";
		String key1 = "c";
		String key2 = "ca";
		Integer val = null;
		tst.put(key1, val);
		tst.put(key2, val);
		tst.longestPrefixOf(query);
		assertEquals("",tst.longestPrefixOf(query));
	}
}
