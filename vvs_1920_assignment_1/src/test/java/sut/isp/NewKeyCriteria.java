package sut.isp;

import org.junit.jupiter.api.Test;

public class NewKeyCriteria {
	/*	Characteristics:
	 * 		1. key is null
	 * 			Blocks:
	 * 				- b1 = true
	 * 				- b2 = false
	 *		
	 *		2. key is empty
	 *			Blocks:
	 *				- b1 = true
	 *				- b2 = false
	 *
	 *		3. value is null
	 *			Blocks:
	 *				- b1 = true
	 *				- b2 = false
	 *
	 *		4. root is null
	 *			Blocks:
	 *				- b1 = true
	 *				- b2 = false
	 *
	 *	"Trie already includes the new key" 
	 *
	 *	Base choice: (false,false,false,false)
	 */
	
	/* (false,false,false,false)
	 * (b2,b2,b2,b2)
	 */
	@Test
	public void t1() {
		
		
	}
	
	/* (true,false,false,false)
	 * (b1,b2,b2,b2)
	 */
	@Test
	public void t2() {
		
		
	}
	
	/* (false,true,false,false)
	 * (b2,b1,b2,b2)
	 */
	@Test
	public void t3() {
		
		
	}
	
	/* (false,false,true,false)
	 * (b2,b2,b1,b2)
	 */
	@Test
	public void t4() {
		
		
	}
	
	/* (false,false,false,true)
	 * (b2,b2,b2,b1)
	 */
	@Test
	public void t5() {
		
	}
}
