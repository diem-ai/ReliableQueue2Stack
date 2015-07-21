/**
 * 
 */
package models;

import java.util.Random;

import models.design.project.QueueShareStackIntPair;

import abstracts.HasInvariant;
import abstracts.UnboundedStorageSpecification;

/**
 * This class implements a simulation to calculate the reliable probability of {@link QueueShareStackIntPair}
 * by calling push(), pop() and head() randomly </br>
 * 
 * 
 * @author btdiem
 *
 */
public class QueueIntPairSimulation implements HasInvariant{

	public static int LOW_BOUND_REPEATED_TIME = 100000;
	public static int HIGH_BOUND_REPEATED_TIME = 1000000;
	Random random = new Random();
	
	private UnboundedStorageSpecification<Pairs<Integer>> queue;
	
	public QueueIntPairSimulation(){};
	
	public QueueIntPairSimulation(UnboundedStorageSpecification<Pairs<Integer>> queue){
		this.queue = queue;
	}
	
	public UnboundedStorageSpecification<Pairs<Integer>> getQueue(){
		return this.queue;
	}
	
	public void setQueue(UnboundedStorageSpecification<Pairs<Integer>> queue){
		this.queue = queue;
	}
	/**
	 * This method will calculate the faulty probability of pop(), push() and head() in each stack of each queue
	 * of QueueIntPair by randomizing the choice to call push(), pop() or head() </br>
	 */
	public void randomAllMethodValidation(){
		
		int n = getRandomRepeatedTimes();
		long start = System.currentTimeMillis();
		int randomMethodChoice = 0;
		
		for (int i=0; i<n; i++){
			randomMethodChoice = random.nextInt(3);
			switch(randomMethodChoice){
				case 0:
					try{
						queue.push(new Pairs<Integer>(1,1));
					}catch(IllegalStateException e){}
					break;
				case 1:
					try{
						queue.pop();
					}catch(IllegalStateException e){}
					break;
				case 2:
					try{
						queue.head();
					}catch(IllegalStateException e){}
					break;
				default:
					System.out.println("default");
			}//switch-case
				
		}//fo
		
		System.out.println("Finish to execute " + n + " testing time in " + getExecutionTime(start) + " miliseconds");
		
	}
	/**
	 * 
	 * @return a integer number having the value between LOW_BOUND_REPEATED_TIME and HIGH_BOUND_REPEATED_TIME </br> 
	 */
	public int getRandomRepeatedTimes(){
		return random.nextInt(HIGH_BOUND_REPEATED_TIME - LOW_BOUND_REPEATED_TIME) + LOW_BOUND_REPEATED_TIME;
	}
	/**
	 * 
	 * @param start staring time of a simulation case </br>
	 * @return a long value that finishing a simulation case </br>
	 */
	public long getExecutionTime(long start){
		return System.currentTimeMillis() - start;
	}
	/**
	 * This method will calculate the faulty probability of pop(), push() and head() in each stack of each queue
	 * of QueueIntPair by randomizing the choice to call pop() or head() after calling push()</br>
	 * 
	 */
	public void randomPopAndHeadValidation(){
		
		int n = getRandomRepeatedTimes();
		long start = System.currentTimeMillis();
		for (int i=0; i<n; i++){
			try{
				queue.push(new Pairs<Integer>(1,1));
			}catch(Exception e){}
			
		}//for
		//random choice of pop() and head()
		int randomChoice = 0;
		for (int i=0; i<n && !queue.is_empty(); i++){
			randomChoice = random.nextInt(2);
			switch(randomChoice){
			case 0:
				try{
					queue.head();
				}catch(Exception e){}
				break;
			case 1:
				try{
					queue.pop();
				}catch(Exception e){}
				break;
			
			}//switch
		}//while
		System.out.println("Finish to execute " + n + " testing time in " + getExecutionTime(start) + " miliseconds");
	}
	
	/**
	 * This method will calculate the faulty probability of pop(), push() and head() in each stack of each queue </br>
	 * of QueueIntPair by randomizing the choice to call push() or head() then calling pop()</br>
	 */
	public void randomPushAndHeadValidation(){
		
		int n = getRandomRepeatedTimes();
		long start = System.currentTimeMillis();
		
		int randomChoice = 0;
		for (int i=0; i<n ; i++){
			randomChoice = random.nextInt(2);
			switch(randomChoice){
			case 0:
				try{
					queue.push(new Pairs<Integer>(1,1));
				}catch(Exception e){}
				break;
			case 1:
				try{
					queue.head();
				}catch(Exception e){}
				break;
			}//switch
		}//while
		for (int i=0; i<n ; i++){
			try{
				queue.pop();
			}catch(Exception e){}
		}
		System.out.println("Finish to execute " + n + " testing time in " + getExecutionTime(start) + " miliseconds");
	}

	/**
	 * The invariant constraint here is that the tested queue should be initialized before executing test </br>
	 */
	@Override
	public boolean invariant() {
		return queue!=null;
	}
}
