package tests;


import models.UnreliableStack;
import models.design.project.QueueShareStack;

import org.junit.Before;

import abstracts.UnboundedStorageSpecification;


/**
 * This class is an extension of {@link JUnit_UnboundedStorageSpecification} </br>
 * Make test cases to check the behaviors of {@link QueueShareStack} built by 2 {@link UnreliableStack} </br> 
 * and one of two is shared with the other queue </br>
 * 
 * @author btdiem
 *
 */
public class JUnit_QueueShareStack_UnreliableStack extends JUnit_UnboundedStorageSpecification {

	
	@Override
	@Before
	public void setUp() throws Exception{

		UnboundedStorageSpecification<Integer> stackShare = new UnreliableStack<Integer>(pushErrorProb, popErrorProb, headErrorProb);
		storage = new QueueShareStack<Integer>(stackShare, pushErrorProb, popErrorProb, headErrorProb); 

	}


}
