
public class BetterArray <I extends Comparable<? super I>> implements
ListInterface <I>{
	private final int CAPACITY = 10;
	private Object [] elements;
	private int numElements;
	
	
	public BetterArray() {
		
		this.elements = new Object[CAPACITY];
		this.numElements = 0;
	}
	

	@Override
	public ListInterface<I> copy() {
		/* 
		 * Deep copy
		 * Requires you to create a new object
		 * and then copy one value at a time from the other (this)
		 * object
		 * 
		 * and return the object
		 */
		
		return null;
	}

	@Override
	public int size() {
		
		return this.numElements;
	}

	@Override
	public boolean isEmpty() {
		
		return (this.numElements == 0);
	}

	@Override
	public void add(I element) {
		
		
		if(this.numElements == elements.length) {
			// The above boolean expression when true means the array is full.
			
			// When the array is full, we want to resize.
			this.resize();

		}
		
		
		
		/*
		 * The following line of code is used to store the provided (specified)
		 * value into our array elements.
		 */
		this.elements[this.numElements] = element;
		
		/*
		 * Once the value has been added to the array, we increase the count of the
		 * items in the array using the following line of code.
		 */
		this.numElements++;
		
	}

	private void resize() {
		// How do we resize an array?
		
		// Step 1: Create a new array that has a greater capacity that the original array
		Object [] copyElements = new Object[ (this.elements.length * 2) ];
		
		// Step 2: We copy values from the original array that is currently full to the bigger array
		for(int i = 0; i < this.numElements; i++) {
			copyElements[i] = elements[i];
		}
		
		
		// Step 3: Update the address of elements to point to the new bigger array.
		elements = copyElements;
	}	
	
	
	
	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > this.numElements) {
			// index > this.numElements => We cannot have gaps in our array
			// index < 0 is just checking to ensure that the index is not negative
			// How are we going to address this? We will come back shortly.
		    throw new ArrayIndexOutOfBoundsException("Invalid index");
		
		}
		
		// Now the index is good. What do we do?
		if(this.numElements == elements.length) {
			// The above boolean expression when true means the array is full.
			
			// When the array is full, we want to resize.
			this.resize();

		}
		
		// [10, 80, 90, 45, 45, 67, 44,_,_,_,_]
		// add(33, 3)
		// numElements [6]
		
		// i = [3]
		
		for(int i = this.numElements; i > index; i-- ) {
			this.elements[i] = this.elements[i - 1];
		}
		
		this.elements[index] = element;
		this.numElements++;
		
	}

	@Override
	public void addSorted(I element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public I get(int index) throws IndexOutOfBoundsException {
		this.checkForIvalidIndex(index);
		
		
		return (I)this.elements[index];
	}

	@Override
	public I replace(I element, int index) throws IndexOutOfBoundsException {
		this.checkForIvalidIndex(index);
		
		// We are extracting the value that is to be replaced
		I removedElement = (I)this.elements[index];
		
		// We are updating the index with the new value
		this.elements[index] = element;
		
		
		// we are returning the removed value.
		return removedElement;
	}

	@Override
	public I remove(int index) throws IndexOutOfBoundsException {
		this.checkForIvalidIndex(index);
		
		I removedElement = (I)this.elements[index];
		
		for(int i = index; i < this.numElements -1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		this.numElements--;
		
		return removedElement;
	}

	@Override
	public void removeAll() {
		this.numElements = 0;
		this.elements = new Object[CAPACITY];
		
	}
	
	private void checkForIvalidIndex(int index) {
		if(index < 0 || index >= this.numElements) {
			// we will address the remaining part later. 
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
	}

}
