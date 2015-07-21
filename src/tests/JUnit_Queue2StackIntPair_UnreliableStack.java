package tests;

import models.UnreliableStack;
import models.design.propose.Queue2Stack;
import models.design.propose.Queue2StackIntPair;

import org.junit.Before;

import abstracts.UnboundedStorageSpecification;
/**
 * This class is an extension of {@link JUnit_AbstractQueueIntPair} </br>
 * Make test cases to check the behaviors of {@link Queue2StackIntPair} built by 4 {@link UnreliableStack} </br>
 * 
 * @author btdiem
 *
 */
public class JUnit_Queue2StackIntPair_UnreliableStack extends JUnit_AbstractQueueIntPair{

	@Override
	@Before
	public void setUp() throws Exception {
		
		//create queue1
		
		UnboundedStorageSpecification<Integer> stackIn1 = new UnreliableStack<Integer>(pushErrorProb, popErrorProb, headErrorProb);
		UnboundedStorageSpecification<Integer> stackOut1 = new UnreliableStack<Integer>(pushErrorProb, popErrorProb, headErrorProb);
		Queue2Stack<Integer> queue1 = new Queue2Stack<>(stackIn1, stackOut1); 

		//create queue2 
		UnboundedStorageSpecification<Integer> stackIn2 = new UnreliableStack<Integer>(pushErrorProb, popErrorProb, headErrorProb);
		UnboundedStorageSpecification<Integer> stackOut2 = new UnreliableStack<Integer>(pushErrorProb, popErrorProb, headErrorProb);
		Queue2Stack<Integer> queue2 = new Queue2Stack<>(stackIn2, stackOut2); 

		queue = new Queue2StackIntPair<Integer>(queue1, queue2);		
	}


}
