/**
 * 
 */
package models;

import java.util.Random;

/**
 * This class is an extension of {@link ReliableStack} </br>
 * It overrides push(), pop() and head() and adds the exception condition to make Stack to be unreliable </br>
 * 
 * @author btdiem </br>
 *
 */
public class UnreliableStack<T> extends ReliableStack<T> {
	
	Random random = new Random();
	//the faulty probability of push()
	private int pushFaultProb;
	//The faulty probability of pop()
	private int popFaultProb;
	//The faulty probability of head()
	private int headFaultProb;
	//when receiving a randomly number, if it is 0, throw an exception for each method
	private int EXCEPTION_CONDITION = 0;
	
	//the number of exceptions found by calling of push()
	//the faulty probability of push(): 1/pushError
	private double pushError = 0;
	/**
	 * the number of calls of push()
	 */
	private double pushCall = 0;
	
	//The number of exceptions found by calling pop()
	//the faulty probability of pop(): 1/popError
	private double popError = 0;
	/**
	 * The number calls of pop
	 */
	private double popCall = 0;
	//The number of exceptions found by calling head()
	//the faulty probability of head(): 1/headError
	private double headError = 0;
	/**
	 * The number of calls of head()
	 */
	private double headCall = 0;
	//The name of stack
	private String name;
	
	
	public UnreliableStack(int pushFaultProb, int popFaultProb, int headFaultProb){
		super();
		this.pushFaultProb = pushFaultProb;
		this.popFaultProb = popFaultProb;
		this.headFaultProb = headFaultProb;
	}

	public UnreliableStack(int pushFaultProb, int popFaultProb, int headFaultProb, String name){
		this(pushFaultProb, popFaultProb, headFaultProb);
		this.name = name;
	}

	/**
	 * 
	 * @return true of random value is equal to EXCEPTION_CONDITION </br>
	 */
	public boolean canPushError(){
		int randomPush = random.nextInt(pushFaultProb);
		return randomPush == EXCEPTION_CONDITION;
	}
	public int getPushFaultProb() {
		return pushFaultProb;
	}

	public void setPushFaultProb(int pushFaultProb) {
		this.pushFaultProb = pushFaultProb;
	}

	public int getPopFaultProb() {
		return popFaultProb;
	}

	public void setPopFaultProb(int popFaultProb) {
		this.popFaultProb = popFaultProb;
	}

	public int getHeadFaultProb() {
		return headFaultProb;
	}

	public void setHeadFaultProb(int headFaultProb) {
		this.headFaultProb = headFaultProb;
	}

	/**
	 * 
	 * @return true of random value is equal to EXCEPTION_CONDITION </br>
	 */
	public boolean canPopError(){
		int randomPop = random.nextInt(popFaultProb);
		return randomPop == EXCEPTION_CONDITION;
	}
	/**
	 * 
	 * @return true of random value is equal to EXCEPTION_CONDITION </br>
	 */
	public boolean canHeadError(){
		int randomHead = random.nextInt(headFaultProb);
		return randomHead == EXCEPTION_CONDITION;
	}
	/*
	 * Record the number of calls of push() and the number of exception 
	 * is thrown when the exception condition is true </br>
	 * (non-Javadoc)
	 * @see models.ReliableStack#push(java.lang.Object)
	 */
	@Override
	public void push(T x) {
		
		addPushCall(1);
		if (canPushError()){
			addPushError(1);
			throw new IllegalStateException("Push() got an exception");
		}
		super.push(x);
	}
	/*
	 * Record the number of calls of head() and the number of exception 
	 * is thrown when the exception condition is true </br>
	 * 
	 * (non-Javadoc)
	 * @see models.ReliableStack#head()
	 */
	@Override
	public T head() throws IllegalStateException {
		
		addHeadCall(1);
		if (canHeadError()){
			addHeadError(1);
			throw new IllegalStateException("Head() got an exception");
		}
		return super.head();
	}
	/*
	 * Record the number of calls of pop() and the number of exception 
	 * is thrown when the exception condition is true </br>
	 * 
	 * (non-Javadoc)
	 * @see models.ReliableStack#pop()
	 */
	@Override
	public void pop() throws IllegalStateException {

		addPopCall(1);
		if (canPopError()){
			addPopError(1);
			throw new IllegalStateException("Pop() got an exception");
		}
		super.pop();
	}
	/**
	 * 
	 * @return the number of calls of push() </br>
	 */
	public double getPushCall() {
		return pushCall;
	}

	/**
	 * 
	 * @return the number of calls of pop() </br>
	 */
	public double getPopCall() {
		return popCall;
	}

	/**
	 * 
	 * @return the number of calls of head() </br>
	 */
	public double getHeadCall() {
		return headCall;
	}
	/**
	 * 
	 * @return Value of the reliable percentage of push() </br> 
	 */
	public double getReliabilityOfPush() {
		return (1 - pushError/pushCall)*100;
	}
	/**
	 * 
	 * @return Value of the reliable percentage of pop() </br>
	 */
	public double getReliabilityOfPop() {
		return (1- popError/popCall)*100;
	}
	/**
	 * 
	 * @return Value of the reliable percentage of head() </br>
	 */
	public double getReliabilityOfHead() {
		return (1- headError/headCall)*100;
	}

	 /** 
	 * @param countP the number of times of the exception thrown when push() is called </br>
	 */
	public void addPushError(int countP){
		this.pushError += countP;
	}
	/**
	 * 
	 * @param call the number of calls of push() </br>
	 */
	public void addPushCall(int call){
		this.pushCall +=  call;
	}
	/**
	 * 
	 * @param countQ the number of times of an exception thrown when pop() is called <br>
	 */
	public void addPopError(int countQ){
		this.popError += countQ;
	}
	/**
	 * 
	 * @param call the number of calls of pop()
	 */
	public void addPopCall(int call){
		this.popCall += call;
	}
	/**
	 * 
	 * @param countR the number of times of an exception thrown when head() is called </br>
	 */
	public void addHeadError(int countR){
		this.headError += countR;
	}
	/**
	 * 
	 * @param call the number of calls of head();
	 */
	public void addHeadCall(int call){
		this.headCall += call;
	}
	/**
	 * 
	 * @return the number of times when push() throws exception </br> 
	 */
	public double getPushError() {
		return pushError;
	}
	/**
	 * 
	 * @return the number of times when pop() throws an exception </br> 
	 */
	public double getPopError() {
		return popError;
	}
	/**
	 * 
	 * @return the number of times when head() throws an exception </br> 
	 */
	public double getHeadError() {
		return headError;
	}
	
	/*
	 * (non-Javadoc)
	 * @see models.ReliableStack#displayFaultyResult()
	 */
	@Override
	public void displayFaultyResult(){
		
		System.out.println(name + " has the reliable probability of push(): " + getReliabilityOfPush() + "%");
		System.out.println(name + " has the reliable probability of pop(): " + getReliabilityOfPop() + "%");
		System.out.println(name + " has the reliable probability of head(): " + getReliabilityOfHead() + "%");
		System.out.println();

	}
	

}
