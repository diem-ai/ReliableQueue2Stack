/**
 * 
 */
package abstracts;

import models.ReliableStack;
import models.UnreliableStack;

/**
 * This class is an abstraction of {@link UnboundedStorageSpecification} </br>
 * It implements all basic methods of a queue </br>
 * As project's requirement, the queue is built by 2 stacks. </br>
 * The testing instance of both stacks may be {@link UnreliableStack} or {@link ReliableStack} </br>
 * 
 * 
 * @author btdiem
 *
 */
public abstract class AbstractQueue<T> implements HasInvariant, UnboundedStorageSpecification<T>{

	/**
	 * stackIn is used to insert new value
	 */
	protected UnboundedStorageSpecification<T> stackIn;
	/**
	 * StackOut is a temporary storage to receive all elements from StackIn when pop() or head() is called
	 */
	protected UnboundedStorageSpecification<T> stackOut;
	
	
	/*
	 * Return true of both of stacks are empty </br>
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStackSpecification#is_empty()
	 */
	@Override
	public boolean is_empty() {
		return stackIn.is_empty() && stackOut.is_empty();
	}

	/*
	 * Return the number of elements of two stacks </br>
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStackSpecification#get_size()
	 */
	@Override
	public int get_size() {
		return stackIn.get_size() + stackOut.get_size();
	}

	/*
	 * Insert a new element to StackIn </br>
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStackSpecification#push(java.lang.Object)
	 */
	@Override
	public void push(T x) {
		stackIn.push(x);
	}
	
	/*
	 * Return true if both of stacks are initialized </br>
	 * (non-Javadoc)
	 * @see abstracts.HasInvariant#invariant()
	 */
	@Override
	public boolean invariant() {
		return stackIn != null && stackOut != null;
	}
	
	/**
	 * Move all elements from stack1 to stack 2 </br>
	 * @param stack1 
	 * @param stack2
	 */
	public synchronized void moveStack2Stack(UnboundedStorageSpecification<T> stack1, UnboundedStorageSpecification<T> stack2){
		
        while (!stack1.is_empty()){
        	stack2.push(stack1.head());
        	stack1.pop();
        }
 	}
	
	/*
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#displayFaultyResult()
	 */
	@Override
	public void displayFaultyResult() {
		stackIn.displayFaultyResult();
		stackOut.displayFaultyResult();
	}

	
	
}
