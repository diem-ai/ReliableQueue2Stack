/**
 * 
 */
package tests;


import models.ReliableStack;

import org.junit.Before;

/**
 * This class is an extension of {@link JUnit_UnboundedStorageSpecification} </br>
 * Make test cases to check behaviors of {@link ReliableStack} </br>
 * 
 * @author btdiem
 *
 */
public class JUnit_ReliableStack extends JUnit_UnboundedStorageSpecification{

	@Override
	@Before
	public void setUp() throws Exception{
		storage = new ReliableStack<Integer>();
	}

		
//	@After
//	public void tearDown() throws Exception {
//		storage = null;
//	}
//	
//	@Test 
//	public void test_is_empty(){
//		Assert.assertTrue(storage.is_empty());
//		storage.push(1);
//		Assert.assertFalse(storage.is_empty());
//	}
//	
//	@Test 
//	public void test_get_size(){
//		storage.push(1);
//		storage.push(2);
//		storage.push(3);
//		Assert.assertEquals(3, storage.get_size());
//	}
//		
//	@Test (expected = IllegalStateException.class)
//	public void test_headKO(){
//		Assert.assertTrue(storage.is_empty());
//		storage.head();
//	}
//	
//	@Test (expected = IllegalStateException.class)
//	public void test_popKO(){
//		Assert.assertTrue(storage.is_empty());
//		storage.pop();
//	}
//		
//	@Test
//	public void test_head(){
//		Assert.assertTrue(storage.is_empty());
//		storage.push(1);
//		storage.push(2);
//		storage.push(3);
//		assertSame(3, storage.head());
//		storage.pop();
//		storage.pop();
//		assertSame(1, storage.head());
//	}
//	
//	
//	@Test
//	public void test_pop(){
//		Assert.assertTrue(storage.is_empty());
//		storage.push(1);
//		storage.push(2);
//		storage.push(3);
//		storage.pop();
//		assertSame(2, storage.head());
//		Assert.assertTrue(!storage.is_empty());
//		storage.pop();
//		assertSame(1, storage.head());
//		Assert.assertTrue(!storage.is_empty());
//		storage.pop();
//		Assert.assertTrue(storage.is_empty());
//	}
//	
//	@Test
//	public void test_push(){
//		Assert.assertTrue(storage.is_empty());
//		
//		storage.push(1);
//		assertSame(1, storage.head());
//		Assert.assertTrue(!storage.is_empty());
//		storage.push(2);
//		assertSame(2, storage.head());
//		Assert.assertTrue(!storage.is_empty());
//		storage.push(3);
//		assertSame(3, storage.head());
//		Assert.assertTrue(!storage.is_empty());
//	}
//	
//	/**
//	 * Make a million calls to each of the bounded stack methods and check that
//	 * the delay is no bigger than a second
//	 */
//	@Test
//	public void test_performance1(){
//		
//		long time1;
//		long time2;
//		time1 = System.currentTimeMillis();
//		
//		for (int i=0; i<1000000; i++){
//			storage.push(1);
//		 	storage.head();
//			storage.is_empty();
////			stack.is_full();
//			storage.get_size();
//			storage.pop();
//		}
//		
//		time2 = System.currentTimeMillis();
//		System.out.println("delay time of performance case 1: " + (time2-time1));
//		Assert.assertTrue(time2-time1<1000);
//	
//	}
//	/**
//	 * Push 1000000 elements once and then call head() and pop() until stack is empty </br>
//	 * Check that the delay is no bigger than a second
//	 * This test case is passed with {@link Optimiziedstack2Stacks} </br>
//	 * This case is some times passed or failed with {@link Traditionalstack2Stacks} </br>
//	 */
//	@Test
//	public void test_performance2(){
//		
//		long time1;
//		long time2;
//		time1 = System.currentTimeMillis();
//		
//		for (int i=0; i<1000000; i++){
//			storage.push(i);
//		}
//		while(!storage.is_empty()){
//			storage.head();
//			storage.pop();
//		}
//		time2 = System.currentTimeMillis();
//		System.out.println("delay time of performance case 2: " + (time2-time1));
//		Assert.assertTrue(time2-time1<1000);
//	
//	}
//	
//	/**
//	 * Push() and head() 1000000 elements into stack respectively</br>
//	 * Then call pop() this stack until it is empty
//	 * Check that the delay is no bigger than a second
//	 * This test case is passed with {@link Optimiziedstack2Stacks} </br>
//	 * This test case is failed with {@link Traditionalstack2Stacks} </br>
//	 * 
//	 */
//	@Test
//	public void test_performance3(){
//		
//		long time1;
//		long time2;
//		time1 = System.currentTimeMillis();
//		
//		for (int i=0; i<1000000; i++){
//			storage.push(1);
//			storage.head();
//		}
//		while(!storage.is_empty()){
//			storage.pop();
//		}
//		time2 = System.currentTimeMillis();
//		System.out.println("delay time of performance case 3: " + (time2-time1));
//		Assert.assertTrue(time2-time1<1000);
//	
//	}
//	
//	/**
//	 * push() and head() , pop(), is_empty() and get_size()  1000000 elements are called randomly </br>
//	 * Check that the delay is no bigger than 300 milliseconds </br>
//	 * This test case is passed with {@link Optimiziedstack2Stacks} </br>
//	 * This case is failed with {@link Traditionalstack2Stacks} </br>
//	 * 
//	 */
//	@Test
//	public void test_performance4(){
//		
//		long time1;
//		long time2;
//		time1 = System.currentTimeMillis();
//		int rnd = 0;
//		for (int i=0; i<1000000; i++){
//			rnd = ThreadLocalRandom.current().nextInt(5);
//			switch(rnd){
//				case 0:
//					storage.push(1);
//					break;
//				case 1:
//					if (!storage.is_empty()) storage.head();
//					else storage.push(1);
//					break;
//				case 2:
//					if (!storage.is_empty()) storage.pop();
//					else storage.push(1);
//					break;
//				case 3:
//					storage.is_empty();
//					break;
//				case 4:
//					storage.get_size();
//					break;
//				default:
//					storage.push(i);
//			}//switch-case
//				
//		}//for
//		time2 = System.currentTimeMillis();
//		System.out.println("delay time of performance case 4: " + (time2-time1));
//		Assert.assertTrue(time2-time1<300);
//	
//	}

}
