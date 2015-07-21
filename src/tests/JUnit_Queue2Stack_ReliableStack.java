/**
 * 
 */
package tests;

import models.ReliableStack;
import models.design.propose.Queue2Stack;

import org.junit.Before;

import abstracts.UnboundedStorageSpecification;

/**
 * 
 * This class is an extension of {@link JUnit_UnboundedStorageSpecification} </br>
 * Make test cases to check the behavior of {@link Queue2Stack} built by 2 {@link ReliableStack} </br>
 * 
 * @author btdiem
 *
 */
public class JUnit_Queue2Stack_ReliableStack extends JUnit_UnboundedStorageSpecification{

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		
		UnboundedStorageSpecification<Integer> stackIn = new ReliableStack<Integer>();
		UnboundedStorageSpecification<Integer> stackOut = new ReliableStack<Integer>();
		
		storage = new Queue2Stack<Integer>(stackIn, stackOut);
	}


}
