package models;
import java.util.LinkedList;

import abstracts.UnboundedStorageSpecification;

/**
 * This class is an implementation of {@link UnboundedStorageSpecification} </br>
 * It implements a stack without making an exception condition </br>
 * 
 * @author btdiem </br>
 *
 */
public class ReliableStack<T>  implements UnboundedStorageSpecification<T>{

	LinkedList<T> stack = null;
	

	public ReliableStack(){
		stack = new LinkedList<T>();
	}

	/*
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#is_empty()
	 */
	@Override
	public boolean is_empty() {
		
		return stack.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#get_size()
	 */
	@Override
	public int get_size() {
		return stack.size();
	}

	/*
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#push(java.lang.Object)
	 */
	@Override
	public void push(T x) {
		stack.addLast(x);
		
	}

	/*
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#head()
	 */
	@Override
	public T head() throws IllegalStateException {
		if (is_empty()){
			throw new IllegalStateException("Stack is empty.");
		}
		return stack.peek();
	}

	/*
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#pop()
	 */
	@Override
	public void pop() throws IllegalStateException {
		if (is_empty()){
			throw new IllegalStateException("Stack is empty.");
		}
		stack.pop();
	}

	@Override
	public void displayFaultyResult() {
		//there is no faulty here
		
	}
	/*
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#invariant()
	 */
	@Override
	public boolean invariant() {
		// TODO Auto-generated method stub
		return stack!=null;
	}

	
}
