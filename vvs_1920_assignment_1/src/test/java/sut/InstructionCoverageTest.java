package sut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * The test methods within this class focus on the Instruction Coverage of all the TST's public methods
 * 
 * By running this class as Coverage, and then expanding the TST class in the Coverage tab,
 * we can conclude that all public methods have 100% coverage and 0 missed instructions
 * 
 * Instruction Covered by each test methods is represented in a table in the report document
 * 
 */
@DisplayName("Instruction Coverage Test")
public class InstructionCoverageTest {

	TST<Integer> tst;

	@Before
	public void initializeObject() {
		tst = new TST<>();
	}

	@Test
	public void sizeZeroTest() {
		assertEquals(0, tst.size());
	}

	@Test
	public void containsNullKey() {
		String key = null;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.contains(key);
		});
	}

	@Test
	public void containsNonNullKey() {
		String key = "someKey";
		assertFalse(tst.contains(key));
	}

	@Test
	public void getNullKey() {
		String key = null;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.get(key);
		});
	}

	@Test
	public void getEmptyStringKey() {
		String key = "";
		assertThrows(IllegalArgumentException.class, () -> {
			tst.get(key);
		});
	}

	@Test
	public void getNonExistentKey() {
		String key = "someKey";
		assertNull(tst.get(key));
	}

	@Test
	public void getExistentKey() {
		String key = "key";
		Integer value = 1;
		tst.put(key, value);
		assertEquals(value, tst.get(key));
	}

	@Test
	public void putNullKey() {
		String key = null;
		Integer value = 1;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.put(key,value);
		});
	}

	@Test
	public void putValidNewKey() {
		String key = "someKey";
		Integer value = 1;
		int size = tst.size();
		tst.put(key,value);
		assertEquals(size+1, tst.size());
	}

	@Test
	public void longestPrefixOfNull() {
		String query = null;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.longestPrefixOf(query);
		});
	}

	@Test
	public void longestPrefixOfEmptyString() {
		String query = "";
		assertNull(tst.longestPrefixOf(query));
	}

	@Test
	public void longestPrefixOfAllInstructions() {
		/* Query "c"
		 * 						"d",1
		 * 					/	  |	    \
		 * 				"b",2	
		 * 			/	 |	  \
		 * 		              "c",3	   

		 * */
		String query = "c";
		tst.put("d", 1);
		tst.put("b", 2);
		tst.put("c", 3);
		assertEquals(query, tst.longestPrefixOf(query));
	}

	@Test
	public void keysTest() {
		assertFalse(tst.keys().iterator().hasNext());
	}

	@Test
	public void keysWithPrefixNull() {
		String prefix = null;
		assertThrows(IllegalArgumentException.class, () -> {
			tst.keysWithPrefix(prefix);
		});
	}

	@Test
	public void keysWithPrefixNonExistentPrefix() {
		String prefix = "somePrefix";
		assertFalse(tst.keysWithPrefix(prefix).iterator().hasNext());
	}

	@Test
	public void keysWithPrefixExistentPrefix() {
		String keyPrefix = "c";
		tst.put(keyPrefix, 1);
		int count = 0;
		Iterator<String> it = tst.keysWithPrefix(keyPrefix).iterator();
		while(it.hasNext()) {
			count++;
			it.next();
		}
		assertEquals(1,count);
	}

	@Test
	public void keysThatMatchTest() {
		String pattern = "pattern";
		assertFalse(tst.keysThatMatch(pattern).iterator().hasNext());
	}
}
