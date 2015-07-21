/**
 * 
 */
package tests;

import models.UnreliableStack;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is an extension of {@link JUnit_UnboundedStorageSpecification} </br>
 * Make test cases to check the behaviors of {@link UnreliableStack} </br>
 * @author btdiem </br>
 *
 */
public class JUnit_UnreliableStack extends JUnit_UnboundedStorageSpecification{

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		
		storage = new UnreliableStack<Integer>(2, 3, 4);
	}
	/**
	 * Test the value of parameter when {@link UnreliableStack} is initialized </br>
	 */
	@Test
	public void testConstructor(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;

		assertTrue(0 == stack.getPopError());
		assertTrue(0 == stack.getPushError());
		assertTrue(0 == stack.getPopCall());
		assertTrue(0 == stack.getPushCall());
		assertTrue(0 == stack.getHeadCall());
		assertEquals(2, stack.getPushFaultProb());
		assertEquals(3, stack.getPopFaultProb());
		assertEquals(4, stack.getHeadFaultProb());
		
	}
	/**
	 * Verify the value of faulty probability of push(), pop() and head() </br>
	 * @see UnreliableStack#getPushFaultProb() </br>
	 * @see UnreliableStack#getPopFaultProb() </br>
	 * @see UnreliableStack#getHeadFaultProb() </br>
	 * @see UnreliableStack#setPushFaultProb(int) </br>
	 * @see UnreliableStack#setPopFaultProb(int) </br>
	 * @see UnreliableStack#setHeadFaultProb(int) </br>
	 */
	@Test
	public void testFaultProbability(){
		
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		
		stack.setPushFaultProb(5);
		stack.setPopFaultProb(50);
		stack.setHeadFaultProb(100);
		
		assertEquals(5, stack.getPushFaultProb());
		assertEquals(50, stack.getPopFaultProb());
		assertEquals(100, stack.getHeadFaultProb());
	}
	/**
	 * Test {@link UnreliableStack#canPushError()} always return true if faulty probability of value is 1
	 * and always return false if faulty probability is 100</br>
	 * @see UnreliableStack#setPushFaultProb(int) </br>
	 */
	@Test
	public void testCanPushError(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		stack.setPushFaultProb(1);
		assertTrue(stack.canPushError());
		
		stack.setPushFaultProb(100);
		assertFalse(stack.canPushError());
	}
	/**
	 * Test {@link UnreliableStack#canPopError()} always return true if faulty probability of value is 1
	 * and always return false if faulty probability is 100</br>
	 * @see UnreliableStack#setPopFaultProb(int) </br>
	 */
	@Test
	public void testCanPopError(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		stack.setPopFaultProb(1);
		assertTrue(stack.canPopError());
		
		stack.setPopFaultProb(100);
		assertFalse(stack.canPopError());
	}
	/**
	 * Test {@link UnreliableStack#canHeadError()} always return true if faulty probability of value is 1
	 * and always return false if faulty probability is 100</br>
	 * @see UnreliableStack#setHeadFaultProb(int) </br>
	 */
	@Test
	public void testCanHeadError(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		stack.setHeadFaultProb(1);
		assertTrue(stack.canHeadError());
		
		stack.setHeadFaultProb(100);
		assertFalse(stack.canHeadError());
	}
	/**
	 * Test the number of calls of push() is increased after adding value </br>
	 * @see UnreliableStack#addPushCall(int) </br>
	 * @see UnreliableStack#getPushCall() </b>
	 */
	@Test
	public void testAddPushCall(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		assertTrue(stack.getPushCall()==0);
		stack.addPushCall(1);
		stack.addPushCall(1);
		assertTrue(stack.getPushCall()==2);
	}
	/**
	 * Test the number of calls of pop() are increased after adding value </br>
	 * @see UnreliableStack#addPopCall(int) </br>
	 * @see UnreliableStack#getPopCall() </br>
	 */
	@Test
	public void testAddPopCall(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		assertTrue(stack.getPopCall()==0);
		stack.addPopCall(1);
		stack.addPopCall(2);
		assertTrue(stack.getPopCall()==3);
	}
	/**
	 * Test the number of calls of head() are increased after adding value </br>
	 * @see UnreliableStack#addHeadCall(int) </br>
	 * @see UnreliableStack#getHeadCall() </br>
	 */
	@Test
	public void testAddHeadCall(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		assertTrue(stack.getHeadCall()==0);
		stack.addHeadCall(4);
		stack.addHeadCall(1);
		assertTrue(stack.getHeadCall()==5);
	}
	/**
	 * 
	 * Test  the number of exception thrown of push() are increased after adding value</br>
	 * @see UnreliableStack#addPushError(int) </br>
	 * @see UnreliableStack#getPushError() </br>
	 *  
	 */
	@Test
	public void testAddPushError(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		assertTrue(stack.getPushError() == 0);
		stack.addPushError(1);
		stack.addPushError(3);
		assertTrue(stack.getPushError() == 4);
	}
	/**
	 * 
	 * Test  the number of exception thrown of push() are increased after adding value</br>
	 * @see UnreliableStack#addPopError(int) </br>
	 * @see UnreliableStack#getPopError() </br>
	 *  
	 */
	@Test
	public void testAddPopError(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		assertTrue(stack.getPopError() == 0);
		stack.addPopError(1);
		stack.addPopError(3);
		assertTrue(stack.getPopError() == 4);
	}	
	/**
	 * 
	 * Test  the number of exception thrown of head() are increased after adding value</br>
	 * @see UnreliableStack#addHeadError(int) </br>
	 * @see UnreliableStack#getHeadError() </br>
	 *  
	 */
	@Test
	public void testAddHeadError(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		assertTrue(stack.getHeadError() == 0);
		stack.addHeadError(1);
		stack.addHeadError(3);
		assertTrue(stack.getHeadError() == 4);
	}
	/**
	 * Test the reliability of head() after adding a number of calls and errors </br>
	 * @see UnreliableStack#getHeadError() </br>
	 * @see UnreliableStack#getHeadCall() </br>
	 * @see UnreliableStack#addHeadCall(int) </br>
	 * @see UnreliableStack#addHeadError(int) </br>
	 * @see UnreliableStack#getReliabilityOfHead() </br>
	 */	
	@Test
	public void testGetReliabilityOfHead(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		assertTrue(stack.getHeadError() == 0);
		assertTrue(stack.getHeadCall() == 0);
		
		stack.addHeadCall(1);
		stack.addHeadCall(1);
		stack.addHeadError(1);
		
		assertTrue(stack.getReliabilityOfHead()==50);
		
	}
	/**
	 * Test the reliability of Push() after adding a number of calls and errors </br>
	 * @see UnreliableStack#getPushError() </br>
	 * @see UnreliableStack#getPushCall() </br>
	 * @see UnreliableStack#addPushCall(int) </br>
	 * @see UnreliableStack#addPushError(int) </br>
	 * @see UnreliableStack#getReliabilityOfPush() </br>
	 */	
	@Test
	public void testGetReliabilityOfPush(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		assertTrue(stack.getPushError() == 0);
		assertTrue(stack.getPushCall() == 0);
		
		stack.addPushCall(1);
		stack.addPushCall(1);
		stack.addPushCall(2);
		stack.addPushError(1);
		
		assertTrue(stack.getReliabilityOfPush()==75);
		
	}
	/**
	 * Test the reliability of pop() after adding a number of calls and errors </br>
	 * @see UnreliableStack#getPopError() </br>
	 * @see UnreliableStack#getPopCall() </br>
	 * @see UnreliableStack#addPopCall(int) </br>
	 * @see UnreliableStack#addPopError(int) </br>
	 * @see UnreliableStack#getReliabilityOfPop() </br>
	 */
	@Test
	public void testGetReliabilityOfPop(){
		UnreliableStack<Integer> stack = (UnreliableStack<Integer>)storage;
		assertTrue(stack.getPopError() == 0);
		assertTrue(stack.getPopCall() == 0);
		
		stack.addPopCall(1);
		stack.addPopCall(1);
		stack.addPopCall(2);
		stack.addPopError(1);
		
		assertTrue(stack.getReliabilityOfPop()==75);
		
	}
	
}
