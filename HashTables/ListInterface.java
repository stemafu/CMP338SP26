/**
 * This list interface is a list ADT 
 */
public interface ListInterface <T> {
	
	/**
	 * The method will return true if the list is empty.
	 * Otherwise it will return false.
	 * 
	 * Calling this method will determine whether the list is empty or not
	 * @return
	 */
	public boolean isEmpty();
	
	
	
	
	/**
	 * This will return the amount of the elements that are currently stored in the list.
	 * if the list is currently storing 5 values, the method returns 5.
	 * @return the number of elements in the list
	 */
	public int size();
	
	
	
	/**
	 * This method is called to add the specified element to the end of list.
	 * @param num this is the number to be added to the list
	 */
	public void add(T element);
	
	
	/**
	 * This method is called to add the specified element at the specified index in the list.
	 * What if the index is bad? What could be a bad index? A negative number is one
	 * example of a bad index. Java does not allow negative indexes.
	 * @param num this is the number to be added to the list
	 */
	public void add(T element, int index) throws ArrayIndexOutOfBoundsException;
	
	public void addSorted(int num);
	
	/**
	 * This method returns an element at the specified index.
	 * What if the specified index is bad? We answer that part later?
	 * @param index - the index where we want to get the value
	 * @return the element at the index
	 */
	public T get(int index) throws ArrayIndexOutOfBoundsException;
	
	/**
	 * The following method is used to remove the element at the specified index.
	 * This also returns the removed element.
	 * What if the specified index is bad? We will answer later.
	 * @param index
	 * @return
	 */
	public T remove(int index) throws ArrayIndexOutOfBoundsException;
	
	/**
	 * The following method removes everything from the list
	 */
	public void removeAll();
	
	/**
	 * The following method is used to replace an element in the list at the specified index with the
	 * given element
	 * The method returns the replacedElement.
	 * What if the index is bad? We will answer that later.
	 * @param num
	 * @param index
	 * @return
	 */
	public T replace(T element, int index) throws ArrayIndexOutOfBoundsException;

}
