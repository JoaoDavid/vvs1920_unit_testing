package sut.isp;

import org.junit.jupiter.api.Test;

public class EmptyTrieCriteria {
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
	 *	"Trie is empty" 
	 *
	 *	Base choice: (false,false,false,true)
	 */
	
	/* (false,false,false,true)
	 * (b2,b2,b2,b1)
	 */
	@Test
	public void t1() {
		
	}
	
	/* (false,false,false,false)
	 * (b2,b2,b2,b2)
	 */
	@Test
	public void t2() {
		
	}
	
	/* (false,false,true,true)
	 * (b2,b2,b1,b1)
	 */
	@Test
	public void t3() {
		
	}
	
	/* (false,true,false,true)
	 * (b2,b1,b2,b1)
	 */
	@Test
	public void t4() {
		
	}
	
	/* (true,false,false,true)
	 * (b1,b2,b2,b1)
	 */
	@Test
	public void t5() {
		
	}
}
