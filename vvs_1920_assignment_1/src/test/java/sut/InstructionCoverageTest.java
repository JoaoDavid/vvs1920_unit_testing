package sut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PC
 *
 */
@DisplayName("Instruction Coverage Test")
public class InstructionCoverageTest {

	TST<Integer> tst;

	@BeforeEach
	public void initializeObject() {
		tst = new TST<>();
	}

	@Test
	public void sizeZeroTest() {
		assertEquals(0, tst.size());
	}

	@Test
	public void sizeNonZeroTest() {
		int numKeys = 7;
		putKeys(numKeys);
		assertEquals(numKeys, tst.size());
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
		tst.put(key, 1);
		assertTrue(tst.contains(key));
	}	
	
	/**
	 * Puts keys: key0, key1, key2 , ..., key(numKeys-1)
	 * 
	 * @param numKeys number of keys to be inserted in the data structure
	 */
	private void putKeys(int numKeys) {
		String keyPrefix = "key";
		for (int i = 0; i < numKeys; i++) {
			tst.put(keyPrefix + i, i);
		}
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
	public void putDuplicateKey() {
		int numKeys = 7;
		putKeys(numKeys);
		putKeys(numKeys);
		assertEquals(numKeys, tst.size());
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
		assertEquals(null, tst.longestPrefixOf(query));
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
