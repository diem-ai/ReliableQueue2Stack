/**
 * 
 */
package tests;

import java.util.Random;

import models.DateHeader;
import models.Pairs;
import models.QueueIntPairSimulation;
import models.ReliableStack;
import models.UnreliableStack;
import models.design.project.QueueShareStack;
import models.design.project.QueueShareStackIntPair;
import abstracts.UnboundedStorageSpecification;

/**
 * 
 * This class is used to simulate the behaviors of {@link QueueShareStackIntPair}
 * and calculate the faulty probability of each stack of each queue when two queues
 * are built by {@link UnreliableStack} and {@link ReliableStack}  </br>
 * 
 * @author btdiem </br>
 *
 */
public class Validation_Simulation4QueueShareStackIntPair {

	public static void main (String [] args){
		
		int lowBound = 1;
		int highBound = 100;
		Random random = new Random();
		//int rndRuntimes = 100000;
		int q = random .nextInt(highBound - lowBound) + lowBound;
		int p = random.nextInt(highBound - lowBound) + lowBound;
		int r = random.nextInt(highBound - lowBound) + lowBound;
		
		System.out.println(DateHeader.dateString());
		System.out.println("The probability of push() got an exception in [1-100]: " + (double)1/q*100 + "%");
		System.out.println("The probability of pop() got an exception in [1-100]: " + (double)1/p*100 + "%");
		System.out.println("The probability of head() got an exception in [1-100]: " + (double)1/r*100 + "%");
		System.out.println();
		
		System.out.println("***Testing QueueIntPair built by two queues that share an unreliable stack\n");
		//create queue1
		UnboundedStorageSpecification<Integer> stackShare_1 = new UnreliableStack<Integer>(q, p, r, "STACK_SHARE");
		QueueShareStack<Integer> queueShare_1 = new QueueShareStack<>(stackShare_1, q, p, r); 
		//create queue2 that shares the temporary stack with queue1
		QueueShareStack<Integer> queueShare_2 = new QueueShareStack<Integer>(stackShare_1, q, p, r);
		queueShare_2.setSharedStack(stackShare_1);
		//create a QueueIntPair
		UnboundedStorageSpecification<Pairs<Integer>> queueInPairs_1 = new QueueShareStackIntPair<>(queueShare_1, queueShare_2);
		QueueIntPairSimulation simulation_1 = new QueueIntPairSimulation(queueInPairs_1);

		System.out.println("***Run the simulation by randomly calling push(), pop() and head()");
		simulation_1.randomAllMethodValidation();
		queueInPairs_1.displayFaultyResult();
		
		System.out.println("***Run the simulation by calling push() first and randomly calling pop() and head()");
		simulation_1.randomPopAndHeadValidation();
		queueInPairs_1.displayFaultyResult();
		
		System.out.println("***Run the simulation by randomly calling push() and head() then calling pop()");
		simulation_1.randomPushAndHeadValidation();
		queueInPairs_1.displayFaultyResult();

		System.out.println("***************************************************************************");
		System.out.println("***Testing QueueIntPair built by two queues that share a reliable stack\n");
		//create queue1
		UnboundedStorageSpecification<Integer> stackShare_2 = new ReliableStack<Integer>();
		QueueShareStack<Integer> queueShare_3 = new QueueShareStack<>(stackShare_2, q, p, r); 
		//create queue2 that shares the temporary stack with queue1
		QueueShareStack<Integer> queueShare_4 = new QueueShareStack<Integer>(stackShare_2, q, p, r);
		//create a QueueIntPair
		UnboundedStorageSpecification<Pairs<Integer>> queueIntPairs_2 = new QueueShareStackIntPair<>(queueShare_3, queueShare_4);
		QueueIntPairSimulation simulation_2 = new QueueIntPairSimulation(queueIntPairs_2);
	
		System.out.println("***Run the simulation by randomly calling push(), pop() and head()");
		simulation_2.randomAllMethodValidation();
		queueIntPairs_2.displayFaultyResult();
		
		System.out.println("***Run the simulation by calling push() first and randomly calling pop() and head()");
		simulation_2.randomPopAndHeadValidation();
		queueIntPairs_2.displayFaultyResult();
		
		System.out.println("***Run the simulation by randomly calling push() and head() then calling pop()");
		simulation_2.randomPushAndHeadValidation();
		queueIntPairs_2.displayFaultyResult();

	}
}
