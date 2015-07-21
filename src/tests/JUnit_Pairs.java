/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;
import models.Pairs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Make test cases for {@link Pairs} class </br>
 * @author btdiem
 *
 */
public class JUnit_Pairs {
	
	Pairs<Integer> pairs;
	
	@Before
	public void setUp(){
		pairs = new Pairs<>();
	}
	
	@After
	public void tearDown(){
		pairs = null;
	}
	@Test
	public void testConstructor(){
		Assert.assertNull(pairs.getFirst());
		Assert.assertNull(pairs.getSecond());
	}
	/**
	 * Test getter and setter of {@link Pairs} </br>
	 * @see Pairs#setFirst(Object) </br>
	 * @see Pairs#setSecond(Object) </br>
	 * @see Pairs#getFirst() </br>
	 * @see Pairs#getSecond() </br>
	 */
	@Test
	public void testGetSet(){
		
		pairs.setFirst(1);
		pairs.setSecond(2);
		junit.framework.Assert.assertSame(1, pairs.getFirst());
		junit.framework.Assert.assertSame(2, pairs.getSecond());
	}
	/**
	 * Test value of {@link Pairs#toString()} </br>
	 */
	@Test
	public void testToString(){
		
		pairs.setFirst(1);
		pairs.setSecond(2);
		assertEquals("<1,2>", pairs.toString());
	}
	/**
	 * Test {@link Pairs#equals(Object)} 
	 */
	@Test
	public void testEquals(){
		
		pairs.setFirst(1);
		pairs.setSecond(2);
		
		Pairs<Integer> int_other_1 = new Pairs<Integer>(1,2);
		Assert.assertTrue(pairs.equals(int_other_1));

		Pairs<Integer> int_other_2 = new Pairs<Integer>(1,3);
		Assert.assertFalse(pairs.equals(int_other_2));

		
		Pairs<String> string_other = new Pairs<String>("1", "2");
		Assert.assertFalse(pairs.equals(string_other));
	}
	
}
