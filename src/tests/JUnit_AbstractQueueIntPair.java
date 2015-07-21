package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import models.Pairs;
import abstracts.AbstractQueueIntPair;
import abstracts.UnboundedStorageSpecification;

/**
 * Make test cases to check the behaviors of {@link AbstractQueueIntPair}
 * 
 * @author btdiem
 *
 */
public abstract class JUnit_AbstractQueueIntPair {

	int pushErrorProb = 2;
	int popErrorProb = 3;
	int headErrorProb = 4;

	UnboundedStorageSpecification <Pairs<Integer>> queue;
	@Before
	public abstract void setUp() throws Exception;

	@After
	public void tearDown() throws Exception {
		
		queue = null;
	}
	/**
	 * Test the returning value of {@link AbstractQueueIntPair#is_empty()} </br>
	 */
	@Test 
	public void test_is_empty(){
		Assert.assertTrue(queue.is_empty());
		queue.push(new Pairs<Integer>(1, 2));
		Assert.assertFalse(queue.is_empty());
	}
	/**
	 * Test the returning value of {@link AbstractQueueIntPair#get_size()} </br>
	 */
	@Test 
	public void test_get_size(){
		queue.push(new Pairs<Integer>(1, 2));
		queue.push(new Pairs<Integer>(3, 4));
		queue.push(new Pairs<Integer>(5, 6));
		Assert.assertEquals(3, queue.get_size());
	}
		
	/**
	 * Test an {@link IllegalStateException} is thrown by calling {@link AbstractQueueIntPair#head()} </br>
	 */
	@Test (expected = IllegalStateException.class)
	public void test_headKO(){
		Assert.assertTrue(queue.is_empty());
		queue.head();
	}
	/**
	 * Test an {@link IllegalStateException} is thrown by calling {@link AbstractQueueIntPair#pop()} </br>
	 */
	@Test (expected = IllegalStateException.class)
	public void test_popKO(){
		Assert.assertTrue(queue.is_empty());
		queue.pop();
	}
	/**
	 * Test the returned value of {@link AbstractQueueIntPair#head()} </br>
	 */
	@Test
	public void test_head(){
		
		Assert.assertTrue(queue.is_empty());
		Pairs<Integer> pairs1 = new Pairs<Integer>(1, 2);
		Pairs<Integer> pairs2 = new Pairs<Integer>(3, 4);
		Pairs<Integer> pairs3 = new Pairs<Integer>(5, 6);
		
		queue.push(pairs1);
		queue.push(pairs2);
		queue.push(pairs3);
		assertEquals(pairs1, queue.head());
		queue.pop();
		queue.pop();
		assertEquals(pairs3, queue.head());
	}
	
	/**
	 * Test the returned value of {@link AbstractQueueIntPair#pop()} </br>
	 */
	@Test
	public void test_pop(){
		Assert.assertTrue(queue.is_empty());
		
		Pairs<Integer> pairs1 = new Pairs<Integer>(1, 2);
		Pairs<Integer> pairs2 = new Pairs<Integer>(3, 4);
		Pairs<Integer> pairs3 = new Pairs<Integer>(5, 6);

		queue.push(pairs1);
		queue.push(pairs2);
		queue.push(pairs3);
		queue.pop();
		assertEquals(pairs2, queue.head());
		Assert.assertTrue(!queue.is_empty());
		queue.pop();
		assertEquals(pairs3, queue.head());
		Assert.assertTrue(!queue.is_empty());
		queue.pop();
		Assert.assertTrue(queue.is_empty());
	}
	/**
	 * Test the returned value of {@link AbstractQueueIntPair#push(Pairs)} </br>
	 */
	@Test
	public void test_push(){
		Assert.assertTrue(queue.is_empty());
		
		Pairs<Integer> pairs1 = new Pairs<Integer>(1, 2);
		Pairs<Integer> pairs2 = new Pairs<Integer>(3, 4);
		Pairs<Integer> pairs3 = new Pairs<Integer>(5, 6);

		queue.push(pairs1);
		assertEquals(pairs1, queue.head());
		Assert.assertTrue(!queue.is_empty());
		queue.push(pairs2);
		assertEquals(pairs1, queue.head());
		Assert.assertTrue(!queue.is_empty());
		queue.push(pairs3);
		assertEquals(pairs1, queue.head());
		Assert.assertTrue(!queue.is_empty());
	}
	
	/** 
	 * Make a million calls to each of the bounded queue methods and check that
	 * the delay is no bigger than a second
	 */
	@Test
	public void test_performance1(){
		
		long time1;
		long time2;
		time1 = System.currentTimeMillis();
		
		for (int i=0; i<1000000; i++){
			queue.push(new Pairs<Integer>(1,1));
		 	queue.head();
			queue.is_empty();
			queue.get_size();
			queue.pop();
		}
		
		time2 = System.currentTimeMillis();
		System.out.println("delay time of performance case 1: " + (time2-time1));
		Assert.assertTrue(time2-time1<1500);
	
	}
	/**
	 * Push 1000000 elements once and then call head() and pop() until queue is empty </br>
	 * Check that the delay is no bigger than a second
	 */
	@Test
	public void test_performance2(){
		
		long time1;
		long time2;
		time1 = System.currentTimeMillis();
		
		for (int i=0; i<1000000; i++){
			queue.push(new Pairs<Integer>(i,i));
		}
		while(!queue.is_empty()){
			queue.head();
			queue.pop();
		}
		time2 = System.currentTimeMillis();
		System.out.println("delay time of performance case 2: " + (time2-time1));
		Assert.assertTrue(time2-time1<2000);
	
	}
	
	/**
	 * Push() and head() 1000000 elements into queue respectively</br>
	 * Then call pop() this queue until it is empty
	 * Check that the delay is no bigger than a second
	 * 
	 */
	@Test
	public void test_performance3(){
		
		long time1;
		long time2;
		time1 = System.currentTimeMillis();
		
		for (int i=0; i<1000000; i++){
			queue.push(new Pairs<Integer>(1,1));
			queue.head();
		}
		while(!queue.is_empty()){
			queue.pop();
		}
		time2 = System.currentTimeMillis();
		System.out.println("delay time of performance case 3: " + (time2-time1));
		Assert.assertTrue(time2-time1<1500);
	
	}
	
	/**
	 * push() and head() , pop(), is_empty() and get_size()  1000000 elements are called randomly </br>
	 * Check that the delay is no bigger than 300 milliseconds </br>
	 * 
	 */
	@Test
	public void test_performance4(){
		
		long time1;
		long time2;
		time1 = System.currentTimeMillis();
		int rnd = 0;
		for (int i=0; i<1000000; i++){
			rnd = ThreadLocalRandom.current().nextInt(5);
			switch(rnd){
				case 0:
					queue.push(new Pairs<Integer>(1,1));
					break;
				case 1:
					if (!queue.is_empty()) queue.head();
					else queue.push(new Pairs<Integer>(1,1));
					break;
				case 2:
					if (!queue.is_empty()) queue.pop();
					else queue.push(new Pairs<Integer>(1,1));
					break;
				case 3:
					queue.is_empty();
					break;
				case 4:
					queue.get_size();
					break;
				default:
					queue.push(new Pairs<Integer>(1,1));
			}//switch-case
				
		}//for
		time2 = System.currentTimeMillis();
		System.out.println("delay time of performance case 4: " + (time2-time1));
		Assert.assertTrue(time2-time1<300);
	
	}
	


}
