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
import models.design.propose.Queue2Stack;
import models.design.propose.Queue2StackIntPair;
import abstracts.UnboundedStorageSpecification;

/**
 * 
 * This class is used to simulate the behaviors of {@link Queue2StackIntPair}
 * and calculate the faulty probability of each stack of each queue when two queues
 * are built by {@link UnreliableStack} and {@link ReliableStack}  </br>
 * 
 * @author btdiem </br>
 *
 */
public class Validation_Simulation4Queue2StackIntPair {

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
		
		/**
		 * test with QueueIntPair : Two queues are aggregations and 2 stacks in each queues are composition either
		 */

		System.out.println("***Testing QueueIntPair built by two queues and each queue has 2 unreliable stacks");
		//create queue1
		UnboundedStorageSpecification<Integer> stackIn_1 = new UnreliableStack<Integer>(q, p, r, "QUEUE 1-STACK_IN");
		UnboundedStorageSpecification<Integer> stackOut_1 = new UnreliableStack<Integer>(q, p, r, "QUEUE 1-STACK_OUT");
		Queue2Stack<Integer> queue_1 = new Queue2Stack<>(stackIn_1, stackOut_1);
		//create queue2
		UnboundedStorageSpecification<Integer> stackIn_2 = new UnreliableStack<Integer>(q, p, r, "QUEUE 2-STACK_IN");
		UnboundedStorageSpecification<Integer> stackOut_2 = new UnreliableStack<Integer>(q, p, r, "QUEUE 2-STACK_OUT");
		Queue2Stack<Integer> queue_2 = new Queue2Stack<Integer>(stackIn_2, stackOut_2);
		//test with optimize pairs of queue
		UnboundedStorageSpecification<Pairs<Integer>> queueIntPair_1 = new Queue2StackIntPair<Integer>(queue_1, queue_2);
		QueueIntPairSimulation simulation_1 = new QueueIntPairSimulation(queueIntPair_1);

		System.out.println("***Run the simulation by randomly calling push(), pop() and head()");
		simulation_1.randomAllMethodValidation();
		queueIntPair_1.displayFaultyResult();
		
		System.out.println("***Run the simulation by calling push() first and randomly calling pop() and head()");
		simulation_1.randomPopAndHeadValidation();
		queueIntPair_1.displayFaultyResult();

		
		System.out.println("***Run the simulation by randomly calling push() and head() then calling pop()");
		simulation_1.randomPushAndHeadValidation();
		queueIntPair_1.displayFaultyResult();
		
		System.out.println("********************************************************************************");
		System.out.println("***Testing QueueIntPair built by two queues and each queue has 2 reliable stacks");
		
		UnboundedStorageSpecification<Integer> stackIn_3 = new ReliableStack<Integer>();
		UnboundedStorageSpecification<Integer> stackOut_3 = new ReliableStack<Integer>();
		Queue2Stack<Integer> queue_3 = new Queue2Stack<>(stackIn_3, stackOut_3);
		//create queue2
		UnboundedStorageSpecification<Integer> stackIn_4 = new ReliableStack<Integer>();
		UnboundedStorageSpecification<Integer> stackOut_4 = new ReliableStack<Integer>();
		Queue2Stack<Integer> queue_4 = new Queue2Stack<Integer>(stackIn_4, stackOut_4);
		//test with optimize pairs of queue
		UnboundedStorageSpecification<Pairs<Integer>> queueIntPair_2 = new Queue2StackIntPair<Integer>(queue_3, queue_4);
		QueueIntPairSimulation simulation_2 = new QueueIntPairSimulation(queueIntPair_2);

		System.out.println("***Run the simulation by randomly calling push(), pop() and head()");
		simulation_2.randomAllMethodValidation();
		queueIntPair_2.displayFaultyResult();
		
		System.out.println("***Run the simulation by calling push() first and randomly calling pop() and head()");
		simulation_2.randomPopAndHeadValidation();
		queueIntPair_2.displayFaultyResult();
		
		System.out.println("***Run the simulation by randomly calling push() and head() then calling pop()");
		simulation_2.randomPushAndHeadValidation();
		queueIntPair_2.displayFaultyResult();

	}
}
