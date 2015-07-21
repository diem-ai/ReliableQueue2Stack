/**
 * 
 */
package models;

/**
 * This class is a data structure of pair object </br>
 * 
 * @author btdiem
 *
 */
public class Pairs<T> {
	
	private T first;
	private T second;
	
	public Pairs (T first, T second){
		this.first = first;
		this.second = second;
	}
	
	public Pairs(){}
	/**
	 * 
	 * @return value of second element of pair</br>
	 */
	public T getSecond() {
		return second;
	}
	/**
	 * 
	 * @param second value is set for the second element of pair</br>
	 */
	public void setSecond(T second) {
		this.second = second;
	}
	/**
	 * 
	 * @return the value of first element </br>
	 */
	public T getFirst() {
		return first;
	}
	/**
	 * 
	 * @param first value is set for the first element of pair</br>
	 */
	public void setFirst(T first) {
		this.first = first;
	}
	@Override
	public String toString() {
		return "<" + first + "," + second + ">";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Pairs<T> other = (Pairs<T>) obj;
		if (first == null) {
			if (other.first != null) return false;
			
		} 
		if (second == null){
			if (other.getSecond() != null) return false;
		}
		return (first.equals(other.getFirst()) && second.equals(other.getSecond()));
		
	}
	
	

}
