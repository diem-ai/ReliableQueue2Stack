/**
 * 
 */
package tests;

import models.UnreliableStack;
import models.design.propose.Queue2Stack;

import org.junit.Before;

import abstracts.UnboundedStorageSpecification;

/**
 * This class is an extension of {@link JUnit_UnboundedStorageSpecification} </br>
 * Make test cases to check the behaviors of {@link Queue2Stack} built by 2 {@link UnreliableStack} </br>
 * 
 * @author btdiem
 *
 */
public class JUnit_Queue2Stack_UnreliableStack extends JUnit_UnboundedStorageSpecification{

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		
		UnboundedStorageSpecification<Integer> stackIn = new UnreliableStack<Integer>(pushErrorProb, popErrorProb, headErrorProb);
		UnreliableStack<Integer> stackOut = new UnreliableStack<Integer>(pushErrorProb, popErrorProb, headErrorProb);
		
		storage = new Queue2Stack<Integer>(stackIn, stackOut);
	}


}
