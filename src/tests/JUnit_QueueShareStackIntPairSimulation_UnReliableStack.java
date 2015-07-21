package tests;

import models.Pairs;
import models.QueueIntPairSimulation;
import models.UnreliableStack;
import models.design.project.QueueShareStack;
import models.design.project.QueueShareStackIntPair;

import org.junit.Before;

import abstracts.UnboundedStorageSpecification;

/**
 * This class is an extension of {@link JUnit_AbstractQueueIntPairSimulation} </br>
 * Make test cases check behaviors of {@link QueueIntPairSimulation} </br>
 * 
 * Two queues in pairs are built by 3 {@link UnreliableStack}</br> 
 * 
 * @author btdiem
 *
 */
public class JUnit_QueueShareStackIntPairSimulation_UnReliableStack extends JUnit_AbstractQueueIntPairSimulation{

	@Override
	@Before
	public void setUp() throws Exception {
		
		//create queue1
		UnboundedStorageSpecification<Integer> stackShare = new UnreliableStack<Integer>(pushErrorProb, popErrorProb, headErrorProb);
		QueueShareStack<Integer> queue1 = new QueueShareStack<>
														(stackShare, pushErrorProb, popErrorProb, headErrorProb); 
		//create queue2 that shares the temporary stack with queue1
		QueueShareStack<Integer> queue2 = new QueueShareStack<Integer>
														(stackShare, pushErrorProb, popErrorProb, headErrorProb);
//		queue2.setSharedStack(stackShare);
		
		UnboundedStorageSpecification<Pairs<Integer>> queue = new QueueShareStackIntPair<Integer>(queue1, queue2);
		simulation = new QueueIntPairSimulation(queue);		
	}

	

}
