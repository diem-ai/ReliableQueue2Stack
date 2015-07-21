/**
 * 
 */
package abstracts;

import models.Pairs;

/**
 * This is  an  implementation of {@link UnboundedStorageSpecification} </br>
 * This class implements the basic methods of a queue that has 2 queues and processes with {@link Pairs} elements</br>
 * 
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractQueueIntPair<T> implements UnboundedStorageSpecification<Pairs<T>>, HasInvariant {

	protected UnboundedStorageSpecification<T> queue1;
	protected UnboundedStorageSpecification<T> queue2;
	
	/*
	 * Return true if both of queues are empty </br>
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#is_empty()
	 */
	@Override
	public boolean is_empty() {
		return queue1.is_empty() && queue2.is_empty();
	}
	/*
	 * Return the number of elements of one of two queue </br>
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#get_size()
	 */
	@Override
	public int get_size() {
		return queue1.get_size();
	}
	/*
	 * Insert the first element of pairs of integer to queue1 </br>
	 * Insert the second element of pairs of integer to queue2 </br>
	 * @see Pairs#getFirst() </br>
	 * @see Pairs#getSecond() </br>
	 * 
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#push(java.lang.Object)
	 */
	@Override
	public void push(Pairs<T> x) {
		queue1.push(x.getFirst());
		queue2.push(x.getSecond());
	}

	/*
	 * Return the item least recently added to the queue1 </br>
	 * Return the item least recently added to the queue2 </br>
	 * 
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#head()
	 */
	@Override
	public Pairs<T> head() throws IllegalStateException {
		return new Pairs<T>(queue1.head(), queue2.head());
	}

	/*
	 * Return and remove the item least recently added to the queue1 </br>
	 * Return and remove the item least recently added to the queue2 </br>
	 * 
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#pop()
	 */
	@Override
	public void pop() throws IllegalStateException {
		queue1.pop();
		queue2.pop();
		
	}
	/*
	 * Return true if both of queues are not null </br>
	 * (non-Javadoc)
	 * @see abstracts.HasInvariant#invariant()
	 */
	@Override
	public boolean invariant() {
		return (queue1 != null && queue2 != null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see abstracts.UnboundedStorageSpecification#displayFaultyResult()
	 */
	@Override
	public void displayFaultyResult() {
		
		queue1.displayFaultyResult();
		queue2.displayFaultyResult();
	}
	
	
}
