/**
 * 
 */
package models.design.project;

import models.ReliableStack;
import models.UnreliableStack;
import abstracts.AbstractQueue;
import abstracts.UnboundedStorageSpecification;


/**
 * 
 * This class is an extension of {@link AbstractQueue} and an implementation of {@link UnboundedStorageSpecification} </br>
 * In this design, stackIn  is a composition meanwhile stackOut(temporary) is aggregation </br>
 * This implementation follows the requirement: the stackOut is shared among two queues and play a role as temporary stack</br>
 * 
 * The tested instances of shared stack may be {@link UnreliableStack} or {@link ReliableStack} </br> 
 * 
 * @author btdiem </br>
 *
 */
public class QueueShareStack<T> extends AbstractQueue<T> implements
		UnboundedStorageSpecification<T> {

	
	public QueueShareStack(UnboundedStorageSpecification<T> stack, int pushErrorProb, int popErrorProb, int headErrorProb){
		this.stackOut = stack;
		this.stackIn = new UnreliableStack<T>(pushErrorProb, popErrorProb, headErrorProb, "STACK_IN");
	}
		
	public void setSharedStack(UnboundedStorageSpecification<T> stack){
		this.stackOut = stack;
	}
	
	public UnboundedStorageSpecification<T> getSharedStack(){
		return stackOut;
	}
	
	/**
	 * Move all elements from stackIn to stackOut </br>
	 * return the item least recently added to the queue </br>
	 * Then, move back all elements from stackOut to stackIn </br> 
	 */
	@Override
	public T head() throws IllegalStateException {
		if (is_empty())
			throw new IllegalStateException("Queue underflow");
		moveStack2Stack(stackIn, stackOut);
		T firstElement = stackOut.head();
		moveStack2Stack(stackOut, stackIn);
		return firstElement;
	}

	/**
	 * Move all elements from stackIn to stackOut </br>
	 * Remove and return the item least recently added to the queue </br>
	 * Then, move back all elements from stackOut to stackIn </br> 
	 */
	@Override
	public void pop() throws IllegalStateException {
		if (is_empty())
			throw new IllegalStateException("Queue underflow");
		moveStack2Stack(stackIn, stackOut);
		stackOut.pop();
		moveStack2Stack(stackOut, stackIn);
		
	}


}
