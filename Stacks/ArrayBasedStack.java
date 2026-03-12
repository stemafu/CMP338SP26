import java.util.Iterator;
/*
 * A Stack is a data structures that follows the Last In First Out Principle.
 * This means the last item to be added to the stack is the first
 * item to be removed. 
 * 
 * The method push(item) adds to the top of the stack and the
 * pop() removes and returns the item from the top of the stack.
 * 
 * If the stack is empty, pop() returns a null.
 */
public class ArrayBasedStack <E> implements StackInterface<E>{
	private final int CAPACITY = 10;
	private Object [] elements;
	private int top;
	private int numElements;
	
	public ArrayBasedStack() {
		elements = new Object[CAPACITY];
		top = -1;
		
		/*
		 * Based on the suggestion from the class contributions,we are starting
		 * the stack’s top at index 0. Notice that we are using 
		 * numElements at top.  
		 * 
		 * Most implementations start with top = -1 because it makes empty-stack detection easier.
		 * 
		 * Please see the ArrayBasedStackV2 class for the implementation where
		 * top starts at -1.
		 */
		
		this.numElements = 0;
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		return (this.numElements == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.numElements;
	}

	@Override
	public StackInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		
		if(e == null) {
			throw new NullPointerException("The parameter is null. It should not be null");
		}
		
		if(this.numElements == this.elements.length) {
			throw new IllegalStateException("The stack is full");
		}
		
		this.elements[this.numElements] = e;
		this.numElements++;
		
		
	}

	@Override
	public E peek() {
		
		if(this.numElements == 0) {
			return null;
		}else {
			return (E)this.elements[this.numElements - 1];
		}
	}

	@Override
	public E pop() {
		
		if(this.numElements == 0) {
			return null;
		}else {
			E removedElement = (E)this.elements[this.numElements - 1];
			this.numElements--;
			return removedElement;
		}
		
		
		
	}

	@Override
	public void clear() {
		this.numElements = 0;
		this.elements = new Object[CAPACITY];
		
	}
	
	public static void main(String [] args) {
		ArrayBasedStack<Integer> stack = new ArrayBasedStack<Integer>();
		
		for(int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println(stack.pop());
		}
	}

}
