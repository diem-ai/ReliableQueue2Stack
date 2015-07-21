package tests;

import models.ReliableStack;
import models.design.project.QueueShareStack;
import models.design.project.QueueShareStackIntPair;

import org.junit.Before;

import abstracts.UnboundedStorageSpecification;

/**
 * This class is an extension of {@link JUnit_UnboundedStorageSpecification} </br>
 * Make test cases to check the behaviors of {@link QueueShareStackIntPair} built by 2 {@link QueueShareStack} </br> 
 * and two queues share the same stack </br>
 * 
 * Two queues of {@link QueueShareStackIntPair} are built by 3 {@link ReliableStack} in this case </br> 
 * 
 * @author btdiem
 *
 */
public class JUnit_QueueShareStackIntPair_ReliableStack extends JUnit_AbstractQueueIntPair{

	@Override
	@Before
	public void setUp() throws Exception {
		
		//create queue1
		UnboundedStorageSpecification<Integer> stackShare = new ReliableStack<Integer>();
		QueueShareStack<Integer> queue1 = new QueueShareStack<>(stackShare, pushErrorProb, popErrorProb, headErrorProb); 

		//create queue2 that shares the temporary stack with queue1
		QueueShareStack<Integer> queue2 = new QueueShareStack<Integer>(stackShare,pushErrorProb, popErrorProb, headErrorProb);
		queue = new QueueShareStackIntPair<Integer>(queue1, queue2);
		
		
	}


}
