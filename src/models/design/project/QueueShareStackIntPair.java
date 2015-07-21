/**
 * 
 */
package models.design.project;

import models.Pairs;
import models.ReliableStack;
import models.UnreliableStack;
import abstracts.AbstractQueueIntPair;
import abstracts.UnboundedStorageSpecification;

/**
 * 
 * This class implements a queue that works with {@link Pairs} elements </br>
 * It is an extension of {@link AbstractQueueIntPair} and an implementation of {@link UnboundedStorageSpecification} </br>
 * 
 * As project's requirement, {@link QueueShareStackIntPair} has two {@link QueueShareStack}  queues </br>
 * Two these queues are aggregations of this class. There are getter and setter for 2 these queues </br>
 * 
 * The tested instances of both queue can be built by two queues of {@link UnreliableStack} or {@link ReliableStack} </br>
 * 
 * @author btdiem </br>
 *
 */
public class QueueShareStackIntPair<T> extends AbstractQueueIntPair<T> implements UnboundedStorageSpecification<Pairs<T>> {

	public QueueShareStackIntPair(UnboundedStorageSpecification<T> queue1,
									UnboundedStorageSpecification<T> queue2){
		this.queue1 = queue1;
		this.queue2 =  queue2;
	}
	
	public void setQueue1(UnboundedStorageSpecification<T> queue){
		this.queue1 = queue;
	}
	
	public void setQueue2(UnboundedStorageSpecification<T> queue){
		this.queue2 = queue;
	}
	
	public UnboundedStorageSpecification<T> getQueue1(){
		return queue1;
	}
	
	public UnboundedStorageSpecification<T> getQueue2(){
		return queue2;
	}

}
