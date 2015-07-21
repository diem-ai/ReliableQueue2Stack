/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import models.QueueIntPairSimulation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Make test cases to check behavior of {@link QueueIntPairSimulation} </br>
 * @author btdiem
 *
 */
public abstract class JUnit_AbstractQueueIntPairSimulation {

	QueueIntPairSimulation simulation;
	int pushErrorProb = 2;
	int popErrorProb = 3;
	int headErrorProb = 4;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public abstract void setUp() throws Exception ;
	
	/**
	 * Return true if the tested queue of simulation is initialized;
	 * @see QueueIntPairSimulation#invariant();
	 */
	@Test
	public void testConstructor(){
		assertTrue(simulation.invariant());
	}
	/**
	 * Return a long value between {@link QueueIntPairSimulation#LOW_BOUND_REPEATED_TIME} and {@link QueueIntPairSimulation#HIGH_BOUND_REPEATED_TIME} </br>
	 */
	@Test
	public void testGetRandomRepeatedTimes(){

		int randomValue = simulation.getRandomRepeatedTimes();
		assertTrue(randomValue > QueueIntPairSimulation.LOW_BOUND_REPEATED_TIME);
		assertTrue(randomValue < QueueIntPairSimulation.HIGH_BOUND_REPEATED_TIME);
		
	}
	/**
	 * Return a long value that is greater than input value </br>
	 * @see QueueIntPairSimulation#getExecutionTime(long) </br>
	 */
	public void testGetFinshExecutionTime(){
		long finishingTime = simulation.getExecutionTime(10000);
		assertTrue(finishingTime <= System.currentTimeMillis() - 10000);
	}
	/**
	 * Verify that invariant of {@link QueueIntPairSimulation} still returns true after calling
	 * {@link QueueIntPairSimulation#randomAllMethodValidation()} </br>
	 */
	@Test
	public void testRandomAllMethodValidation(){
		simulation.randomAllMethodValidation();
		assertTrue(simulation.invariant());
	}
	/**
	 * Verify that invariant of {@link QueueIntPairSimulation} still returns true after calling
	 * {@link QueueIntPairSimulation#randomPopAndHeadValidation()} </br>
	 */
	@Test
	public void testRandomPopAndHeadValidation(){
		simulation.randomPopAndHeadValidation();
		assertTrue(simulation.invariant());
	}
	/**
	 * Verify that invariant of {@link QueueIntPairSimulation} still returns true after calling
	 * {@link QueueIntPairSimulation#randomPushAndHeadValidation()} </br>
	 */
	@Test
	public void testRandomPushAndHeadValidation(){
		simulation.randomPushAndHeadValidation();
		assertTrue(simulation.invariant());
	}
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		simulation = null;
	}

}
