package abstracts;
/**
 * 
 * Interface for classes that have invariant method implemented </br>
 * @author btdiem
 *
 */
public interface HasInvariant {

	/**
	 * 
	 * @return if the object is in a safe (meaningful) state
	 */
	public boolean invariant();
	
}
