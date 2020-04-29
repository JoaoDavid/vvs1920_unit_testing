package sut.properties;

import java.util.Iterator;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import sut.TST;

@RunWith(JUnitQuickcheck.class)
public class TSTGeneratorMyTest {
	
	@Property(trials=1)
	public void testTSTShow(@From(TSTGenerator.class) TST<Integer> tst) {
		Iterator<String> it1 = tst.keys().iterator();
		
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
	}
	
	@Property(trials=15)
	public void testStringShow(@From(MyStringGenerator.class) String str) {
		System.out.println(str);
	}

}
