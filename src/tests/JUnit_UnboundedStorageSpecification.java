package tests;

import static org.junit.Assert.assertSame;

import java.util.concurrent.ThreadLocalRandom;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import abstracts.UnboundedStorageSpecification;

/**
 * Unit tests for checking bounded storage behaviour as 
 * specified by {@link UnboundedStorageSpecification}
 * @author J Paul Gibson </br>
 * 
 * updated by @author btdiem </br> 
 *   change test_is_empty() </br>
 *   remove test_is_full() </br>
 *   remove test_push_NOK() </br>
 *   remove test_toString() </br>
 *   rename test_performance() to test_performance1() </br>
 *   add test_performance2() </br>
 *   add test_performance3() </br>
 *   add test_performance4() </br>
 *
 */
public abstract class JUnit_UnboundedStorageSpecification {

	int pushErrorProb = 2;
	int popErrorProb = 3;
	int headErrorProb = 4;

	
	/**
	 * The bounded storage under test
	 */
	UnboundedStorageSpecification<Integer> storage;
	
	/**
	 * This method needs to construct a concrete instance of a bounded storage to be tested.
	 * This should be an empty storage with the maximum bound set to be 3.
	 * @throws Exception
	 */
	@Before
	public abstract void setUp() throws Exception;
		
	@After
	public void tearDown() throws Exception {
		storage = null;
	}
	
	@Test 
	public void test_is_empty(){
		Assert.assertTrue(storage.is_empty());
		storage.push(1);
		Assert.assertFalse(storage.is_empty());
	}
	
	@Test 
	public void test_get_size(){
		storage.push(1);
		storage.push(2);
		storage.push(3);
		Assert.assertEquals(3, storage.get_size());
	}
		
	
	@Test (expected = IllegalStateException.class)
	public void test_headKO(){
		Assert.assertTrue(storage.is_empty());
		storage.head();
	}
	
	@Test (expected = IllegalStateException.class)
	public void test_popKO(){
		Assert.assertTrue(storage.is_empty());
		storage.pop();
	}
		
	@Test
	public void test_head(){
		Assert.assertTrue(storage.is_empty());
		storage.push(1);
		storage.push(2);
		storage.push(3);
		assertSame(1, storage.head());
		storage.pop();
		storage.pop();
		assertSame(3, storage.head());
	}
	
	
	@Test
	public void test_pop(){
		Assert.assertTrue(storage.is_empty());
		storage.push(1);
		storage.push(2);
		storage.push(3);
		storage.pop();
		assertSame(2, storage.head());
		Assert.assertTrue(!storage.is_empty());
		storage.pop();
		assertSame(3, storage.head());
		Assert.assertTrue(!storage.is_empty());
		storage.pop();
		Assert.assertTrue(storage.is_empty());
	}
	
	@Test
	public void test_push(){
		Assert.assertTrue(storage.is_empty());
		
		storage.push(1);
		assertSame(1, storage.head());
		Assert.assertTrue(!storage.is_empty());
		storage.push(2);
		assertSame(1, storage.head());
		Assert.assertTrue(!storage.is_empty());
		storage.push(3);
		assertSame(1, storage.head());
		Assert.assertTrue(!storage.is_empty());
	}
	
	/**
	 * Make a million calls to each of the bounded storage methods and check that
	 * the delay is no bigger than a second
	 */
	@Test
	public void test_performance1(){
		
		long time1;
		long time2;
		time1 = System.currentTimeMillis();
		
		for (int i=0; i<1000000; i++){
			storage.push(1);
		 	storage.head();
			storage.is_empty();
//			storage.is_full();
			storage.get_size();
			storage.pop();
		}
		
		time2 = System.currentTimeMillis();
		System.out.println("delay time of performance case 1: " + (time2-time1));
		Assert.assertTrue(time2-time1<1000);
	
	}
	/**
	 * Push 1000000 elements once and then call head() and pop() until storage is empty </br>
	 * Check that the delay is no bigger than a second
	 */
	@Test
	public void test_performance2(){
		
		long time1;
		long time2;
		time1 = System.currentTimeMillis();
		
		for (int i=0; i<1000000; i++){
			storage.push(i);
		}
		while(!storage.is_empty()){
			storage.head();
			storage.pop();
		}
		time2 = System.currentTimeMillis();
		System.out.println("delay time of performance case 2: " + (time2-time1));
		Assert.assertTrue(time2-time1<1000);
	
	}
	
	/**
	 * Push() and head() 1000000 elements into storage respectively</br>
	 * Then call pop() this storage until it is empty
	 * Check that the delay is no bigger than a second
	 * 
	 */
	@Test
	public void test_performance3(){
		
		long time1;
		long time2;
		time1 = System.currentTimeMillis();
		
		for (int i=0; i<1000000; i++){
			storage.push(1);
			storage.head();
		}
		while(!storage.is_empty()){
			storage.pop();
		}
		time2 = System.currentTimeMillis();
		System.out.println("delay time of performance case 3: " + (time2-time1));
		Assert.assertTrue(time2-time1<1000);
	
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
					storage.push(1);
					break;
				case 1:
					if (!storage.is_empty()) storage.head();
					else storage.push(1);
					break;
				case 2:
					if (!storage.is_empty()) storage.pop();
					else storage.push(1);
					break;
				case 3:
					storage.is_empty();
					break;
				case 4:
					storage.get_size();
					break;
				default:
					storage.push(i);
			}//switch-case
				
		}//for
		time2 = System.currentTimeMillis();
		System.out.println("delay time of performance case 4: " + (time2-time1));
		Assert.assertTrue(time2-time1<300);
	
	}
	
}
