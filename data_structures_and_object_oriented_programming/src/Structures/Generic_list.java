package Structures;

/* This is an abstract class that defines the methods that all classes that want to represent a collection by extending this class should implement. */

public abstract class Generic_list<T> {

	/* Allows you to position yourself at the top of the list */
	
	public abstract void begin();

	/* Move to the next list item */
	
	public abstract T next();

	/* returns true if we are at the last element of the list, false otherwise */
	
	public abstract boolean end();

	/** returns the element found at position pos. Must remember that the list starts at position 0. 
	* @param pos
	* 		position of where should be added the element
	*/
	
	public abstract T Element(int pos);

	/**
	 * Adds an element at the indicated pos position. If there is an element in
	 * said position, it will be relocated after the element that
	 * we will add. If it was able to remove it it returns true, false in case
	 * contrary.
	 * @param elem
	 *            element to add
	 * @param pos
	 *            position of where should be added the element
	 */
	
	public abstract boolean AddIn(T elem, int pos);

	/**
	 * Adds an element to the beginning of the list. If it was able to add it, it returns
	 * true, false otherwise.
	 * 
	 * @param elem
	 *            element to add
	 * */
	
	public abstract boolean AddToTheBeginning(T elem);

	/**
	 * Adds an element to the end of the list. If it was able to add it, it returns true,
	 * false otherwise.
	 * 
	 * @param elem
	 *            element to add
	 * */
	
	public abstract boolean AddToTheEnd(T elem);

	/**
	 * Removes the first occurrence of the indicated elem element. if he could
	 * remove it returns true, false otherwise.
	 * 
	 * @param elem
	 *            element to remove
	 * */
	
	public abstract boolean Remove(T elem);

	/**
	 * Removes the element located at position pos. if you can remove it
	 * returns true, false otherwise.
	 * 
	 * @param pos
	 *            position of the element to remove
	 * */
	
	public abstract boolean DeleteIn(int pos);

	/**
	 * Returns true if the list contains the element elem, false otherwise
	 * contrary
	 * 
	 * @param elem
	 *            element to search from the list
	 * */
	
	public abstract boolean Includes(T elem);

	/**
	 * Returns true is the list is empty, otherwise returns false.
	 * */
	
	public abstract boolean IsEmpty();

	/**
	 * Returns the amount of elements inside the list
	 * */
	
	public abstract int size();

	/**
	 * Replaces the element at position pos with the parameter elem. Bring back
	 * true if it was able to perform the replacement, false otherwise.
	 * **/
	
	public abstract boolean ReplaceAt(T elem, int pos);

	/**
	 * Returns a list with a copy of the elements of the generic list receiving the message.
	 * **/
	
	public abstract Generic_list<T> Clone();



}
