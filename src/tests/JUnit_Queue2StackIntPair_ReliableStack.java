package tests;

import models.ReliableStack;
import models.design.propose.Queue2Stack;
import models.design.propose.Queue2StackIntPair;

import org.junit.Before;

import abstracts.UnboundedStorageSpecification;

/**
 * This class is an extension of {@link JUnit_AbstractQueueIntPair} </br>
 * Make test cases to check the behaviors of {@link Queue2StackIntPair} built by 4 {@link ReliableStack} </br>
 * 
 * @author btdiem
 *
 */
public class JUnit_Queue2StackIntPair_ReliableStack extends JUnit_AbstractQueueIntPair{

	@Override
	@Before
	public void setUp() throws Exception {
		
		//create queue1
		
		UnboundedStorageSpecification<Integer> stackIn1 = new ReliableStack<Integer>();
		UnboundedStorageSpecification<Integer> stackOut1 = new ReliableStack<Integer>();
		Queue2Stack<Integer> queue1 = new Queue2Stack<>(stackIn1, stackOut1); 

		//create queue2 
		UnboundedStorageSpecification<Integer> stackIn2 = new ReliableStack<Integer>();
		UnboundedStorageSpecification<Integer> stackOut2 = new ReliableStack<Integer>();
		Queue2Stack<Integer> queue2 = new Queue2Stack<>(stackIn2, stackOut2); 

		queue = new Queue2StackIntPair<Integer>(queue1, queue2);
		


		
		
	}


}
