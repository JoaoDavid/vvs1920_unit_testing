package sut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("All Uses Coverage Test")
public class AllUsesCoverage {	

	TST<Integer> tst;

	@BeforeEach
	public void initializeObject() {
		tst = new TST<>();
	}

	@Test
	public void t1() {
		assertThrows(IllegalArgumentException.class, () -> {
			tst.longestPrefixOf(null);
		});		
	}

	@Test
	public void t2() {
		assertNull(tst.longestPrefixOf(""));
	}
	
	@Test
	public void t3() {
		assertEquals("", tst.longestPrefixOf("query"));
	}
	
	@Test
	public void t4() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("a"));
	}
	
	@Test
	public void t5() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("t"));
	}
		
	@Test
	public void t6() {
		tst.put("sea", 1);
		tst.put("s", 2);
		tst.put("e", 3);
		tst.put("a", 4);
		assertEquals("sea", tst.longestPrefixOf("sea"));
	}
	
	@Test
	public void t7() {
		tst.put("sea", 1);
		tst.put("t", 2);
		tst.put("a", 4);
		assertEquals("", tst.longestPrefixOf("set"));
	}
	
	@Test
	public void t8() {
		tst.put("sea", 1);
		tst.put("ball", 2);
		tst.put("c", 3);
		assertEquals("c", tst.longestPrefixOf("c"));
	}
	
	@Test
	public void t9() {
		tst.put("sea", 1);
		tst.put("cat", 2);
		tst.put("b", 3);
		assertEquals("b", tst.longestPrefixOf("b"));
	}
	
	@Test
	public void t10() {
		tst.put("sea", 1);
		tst.put("up", 2);
		tst.put("w", 3);
		assertEquals("w", tst.longestPrefixOf("w"));
	}
	
	@Test
	public void t11() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("sd"));
	}
	
	@Test
	public void t12() {
		tst.put("sea", 1);
		assertEquals("", tst.longestPrefixOf("su"));
	}
	
	@Test
	public void t13() {
		tst.put("sea", 1);
		tst.put("w", 2);
		assertEquals("", tst.longestPrefixOf("t"));
	}

}
