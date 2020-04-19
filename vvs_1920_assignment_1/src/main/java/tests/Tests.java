package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sut.TST;

@DisplayName("<= Test set for TST data structure=>")
public class Tests {
	
	TST<String> tstStruct;
	
	@BeforeEach
	public void setUp() {
		tstStruct = new TST<>();
	}
	
	
	@Test
	public void containsException() {
		String key = null;
	     assertThrows(IllegalArgumentException.class, () -> {
	        tstStruct.contains(key);
	    });
	}
	
	@Test
	public void containsReturn() {
		String key = "someKey";
		//struct starts as empty
		assertEquals(tstStruct.contains(key), false);
	}
	
	@Test
	public void sizeTest() {
		assertEquals(tstStruct.size(),0);
	}
	
	@Test
	public void getNull() {
		String key = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	    	tstStruct.get(key);
		});
	}
	
	@Test
	public void getEmptyString() {
		String key = "";
	    assertThrows(IllegalArgumentException.class, () -> {
	    	tstStruct.get(key);
		});
	}
	
	@Test
	public void getNonExistentValue() {
		String key = "someKey";
		//struct starts as empty
	    assertEquals(tstStruct.get(key), null);
	}
	
	@Test
	public void getExistentValue() {
		String key = "key";
		String value = "value";
		tstStruct.put(key, value	);
		//struct starts as empty
	    assertEquals(tstStruct.get(key), value);
	}
	
	@Test
	public void putNull() {
		String key = null;
		String value = "val";
	    assertThrows(IllegalArgumentException.class, () -> {
	    	tstStruct.put(key,value);
		});
	}
	
	@Test
	public void putNewValue() {
		String key = "someKey";
		String value = "val";
		int size = tstStruct.size();
		try {
	    	tstStruct.put(key,value);
	    	assertEquals(tstStruct.size(), size+1);
		} catch (IllegalArgumentException e) {
			fail("Unexpected exception.");
		}
	}
	
	@Test
	public void longestPrefixOfNull() {
		String query = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	    	tstStruct.longestPrefixOf(query);
		});
	}
	
	@Test
	public void longestPrefixOfEmpty() {
		String query = "";
		assertEquals(tstStruct.longestPrefixOf(query),null);
	}
	
	@Test
	public void longestPrefixOfAllInstructions() {
		/* Query "c"
		 * 						"d","val"
		 * 					/		|		\
		 * 				"b","val"	null	null
		 * 			/		|		\
		 * 		null	  null	    "c","val
		 * 						  /		  |		  \
		 * 					  null	    null	   null
		 * */
		String query = "c";
		String value = "val";
		tstStruct.put("d", value);
		tstStruct.put("b", value);
		tstStruct.put("c", value);
		assertEquals(tstStruct.longestPrefixOf(query), query);
	}
	
	@Test
	public void keysTest() {
		assertFalse(tstStruct.keys().iterator().hasNext());
	}
	
	@Test
	public void keysWithPrefixNull() {
		String prefix = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	    	tstStruct.keysWithPrefix(prefix);
		});
	}
	
	@Test
	public void keysWithPrefixEmpty() {
		String prefix = "somePrefix";
	    assertFalse(tstStruct.keysWithPrefix(prefix).iterator().hasNext());
	}
	
	@Test
	public void keysWithPrefixContains() {
		String keyPrefix = "c";
		tstStruct.put(keyPrefix, "val");
		int count = 0;
		Iterator<String> it = tstStruct.keysWithPrefix(keyPrefix).iterator();
		while(it.hasNext()) {
			count++;
			it.next();
		}
	    assertEquals(count,1);
	}
	
	@Test
	public void keysThatMatchTest() {
		String pattern = "pattern";
		assertFalse(tstStruct.keysThatMatch(pattern).iterator().hasNext());
	}
}
