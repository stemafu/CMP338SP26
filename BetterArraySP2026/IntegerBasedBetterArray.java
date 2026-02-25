
public class IntegerBasedBetterArray implements ListInterface {
	private final int CAPACITY = 10;
	private int [] elements;
	private int numElements;
	
	public IntegerBasedBetterArray() {
		this.elements = new int[CAPACITY];
		this.numElements = 0;
	}
	
	
	@Override
	public boolean isEmpty() {
		/*if(this.numElements == 0) {
			return true;
		}
		else{
			return false;
		}*/
		            
		return (this.numElements == 0);
	}

	@Override
	public int size() {
		
		return this.numElements;
	}

	@Override
	public void add(int num) {
		
		
		/*
		 * When the base array where we are storing our values becomes 
		 * full, we need to increase the size of the array. 
		 * 
		 * To check to see if an array is full, we use the length of the array
		 * and compare against the numElements
		 */
		
		if(this.numElements == elements.length) {
			// The above boolean expression when true means the array is full.
			
			// When the array is full, we want to resize.
			this.resize();

		}
		
		
		
		/*
		 * The following line of code is used to store the provided (specified)
		 * value into our array elements.
		 */
		this.elements[this.numElements] = num;
		
		/*
		 * Once the value has been added to the array, we increase the count of the
		 * items in the array using the following line of code.
		 */
		this.numElements++;
	}

	
	private void resize() {
		// How do we resize an array?
		
		// Step 1: Create a new array that has a greater capacity that the original array
		int [] copyElements = new int[ (this.elements.length * 2) ];
		
		// Step 2: We copy values from the original array that is currently full to the bigger array
		for(int i = 0; i < this.numElements; i++) {
			copyElements[i] = elements[i];
		}
		
		
		// Step 3: Update the address of elements to point to the new bigger array.
		elements = copyElements;
	}
	
	
	
	
	
	@Override
	public void add(int num, int index) {
		
		if(index < 0 || index > this.numElements) {
			// index > this.numElements => We cannot have gaps in our array
			// index < 0 is just checking to ensure that the index is not negative
			// How are we going to address this? We will come back shortly.
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
		
		this.elements[index] = num;
		this.numElements++;
	}

	@Override
	public void addSorted(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get(int index) {
		
		
		if(index < 0 || index >= this.numElements) {
			// we will address the remaining part later. 
		}
		
		
	
		return this.elements[index];
	}

	// [3, 7, 15, 20, 20, 20, -, - , -]
	// reduce numElements
	// remove(1)
	@Override
	public int remove(int index) {
		if(index < 0 || index >= this.numElements) {
			// we will address the remaining part later. 
		}
		
		int removedElement = this.elements[index];
		
		for(int i = index; i < this.numElements -1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		this.numElements--;
		
		return removedElement;
	}

	@Override
	public void removeAll() {
		this.numElements = 0;
		this.elements = new int[CAPACITY];
	}

	@Override
	public int replace(int num, int index) {
		if(index < 0 || index >= this.numElements) {
			// we will address the remaining part later. 
		}
		
		// We are extracting the value that is to be replaced
		int removedElement = this.elements[index];
		
		// We are updating the index with the new value
		this.elements[index] = num;
		
		
		// we are returning the removed value.
		return removedElement;
	}

}
