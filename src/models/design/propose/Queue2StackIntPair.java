/**
 * 
 */
package models.design.propose;

import models.Pairs;
import models.ReliableStack;
import models.UnreliableStack;
import abstracts.AbstractQueueIntPair;
import abstracts.UnboundedStorageSpecification;

/**
 * 
 * This class implements a queue that works with {@link Pairs} of Integer elements </br>
 * It is an extension of {@link AbstractQueueIntPair} and an implementation of {@link UnboundedStorageSpecification} </br>
 * This design implements a queue having 2 {@link Queue2Stack} queues  </br>
 * 
 * In this design, two queues are aggregations and they do not share their stacks with the other </br>
 * The tested instance of two queues may be built by 4 {@link UnreliableStack} or {@link ReliableStack} </br>
 * 
 * @author btdiem </br>
 *
 */
public class Queue2StackIntPair<T> extends AbstractQueueIntPair<T> implements UnboundedStorageSpecification<Pairs<T>> {

	
	public Queue2StackIntPair(UnboundedStorageSpecification<T> queue1, UnboundedStorageSpecification<T> queue2){
		this.queue1 = queue1;
		this.queue2 = queue2;
	}
//	public Queue2StackCompositionIntPairs(){
//		
//		queue1 = new Queue2StackComposition<T>();
//		queue2 = new Queue2StackComposition<T>();
//	}

	@Override
	public void displayFaultyResult() {

		queue1.displayFaultyResult();
		queue2.displayFaultyResult();
	}
	
}
