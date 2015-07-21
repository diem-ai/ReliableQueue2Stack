/**
 * 
 */
package models.design.propose;

import models.ReliableStack;
import models.UnreliableStack;
import abstracts.AbstractQueue;
import abstracts.UnboundedStorageSpecification;

/**
 * 
 *This class is an extension of {@link AbstractQueue} and an implementation of {@link UnboundedStorageSpecification} </br>
 *In this design, stackIn and stackOut are two aggregations of this queue </br> 
 *One of two is not be shared comparing with the design 1 </br>
 * 
 * The tested instances of two stacks may be {@link UnreliableStack} or {@link ReliableStack} </br>
 * 
 * @author btdiem </br>
 *
 */
public class Queue2Stack<T> extends AbstractQueue<T> 
										implements UnboundedStorageSpecification<T>{

	
	
	public Queue2Stack(UnboundedStorageSpecification<T> stackIn, 
								UnboundedStorageSpecification<T> stackOut){
		this.stackIn = stackIn;
		this.stackOut = stackOut;
	}
	
	public void setStackIn(UnboundedStorageSpecification<T> stackIn){
		this.stackIn = stackIn;
	}
	
	public void setStackOut(UnboundedStorageSpecification<T> stackOut){
		this.stackOut = stackOut;
	}
	
	/**
	 * Only move elements from stackIn to stackOut if stackOut is empty </br>
	 * @throws IllegalStateException if both of stacks has no element </br>
	 * @return the item least recently added to the queue </br>
	 */
	@Override
	public T head() throws IllegalStateException {
		if (is_empty())
			throw new IllegalStateException("Queue underflow");
		if (stackOut.is_empty())
			moveStack2Stack(stackIn, stackOut);
		return stackOut.head();
	}
	/**
	 * Only move elements from stackIn to stackOut if stackOut is empty </br>
	 * @throws IllegalStateException if both of stacks has no element </br>
	 * @return and remove the item least recently added to the queue </br>
	 */
	@Override
	public void pop() throws IllegalStateException {
		if (is_empty())
			throw new IllegalStateException("Queue underflow");
		if (stackOut.is_empty())
			moveStack2Stack(stackIn, stackOut);
		stackOut.pop();
	}
	/*
	 * 
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#displayFaultyResult()
	 */
	@Override
	public void displayFaultyResult() {
		stackIn.displayFaultyResult();
		stackOut.displayFaultyResult();
	}
}
