package abstracts;

/**
 *
 * A FIFO bounded queue of integers with a maximum number of elements that must be at least 1.
 * 
 * @author J Paul Gibson
 * @version 1
 */
public interface UnboundedStorageSpecification<T> extends HasInvariant{

	public String PUSH_ERROR_MSG = "Push() got an exception";
	public String POP_ERROR_MSG = "Pop() got an exception";
	public String HEAD_ERROR_MSG = "Head() got an exception";
	public String QUEUE_EMPTY_ERROR_MSG = "Queue is empty";
	
	/**
	 * 
	 * @return if the queue is empty, i.e. the number of elements in the queue is equal to 0.
	 */
	public boolean is_empty();
	
	
	/**
	 * 
	 * @return the maximum number of elements that the queue can hold
	 */
	public int get_size();
	/**
	 * 
	 * @param x is the value being pushed onto queue, and which will become the
	 * element on the queue that has been there for the shortest time
	 */
	public void push (T x);
	
	
	/**
	 * 
	 * @return  head of queue,
	 * where the head is the element that has been in the queue for the longest time.<br>
	 * Does not change the state of the queue
	 * @throws IllegalStateException if we try to read the head of an empty queue
	 */
	public T head () throws IllegalStateException;
	
	/**
	 *  remove head of queue if it is not empty,
	 *  where the head is the element that has been in the queue for the longest time
	 *  @throws IllegalStateException if we try to pop from an empty queue
	 */
	public void pop () throws IllegalStateException;
	
	/**
	 * Display the result of faulty probability of push(), pop() and head() </br>
	 */
	public void displayFaultyResult();
	/**
	 * 
	 * @return if the queue is in a safe state and respects the specified requirements:
	 * <ul>
	 * <li> the number of elements in the queue is no bigger than the maximum specified </li>
	 * <li> the maximum bound is a positive integer </li>
	 * </ul>
	 */
	 public boolean invariant();

	
}
