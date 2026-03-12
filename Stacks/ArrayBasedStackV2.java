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
public class ArrayBasedStackV2 <E> implements StackInterface<E>{
	private final int CAPACITY = 20;
	private Object [] elements;
	private int top;
	
	
	public ArrayBasedStackV2() {
		this.elements = new Object[CAPACITY];
		this.top = -1;
		
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
		
		
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		return (top == -1);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (top + 1);
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
		
		if(this.top == this.elements.length) {
			throw new IllegalStateException("The stack is full");
		}
		this.top++;
		this.elements[this.top] = e;
		
		
		
	}

	@Override
	public E peek() {
		
		if(this.isEmpty() ) {
			return null;
		}else {
			return (E)this.elements[this.top];
		}
	}

	@Override
	public E pop() {
		
		if(this.isEmpty() ) {
			return null;
		}else {
			E removedElement = (E)this.elements[this.top];
			this.top--;
			return removedElement;
		}
		
		
		
	}

	@Override
	public void clear() {
		this.top = -1;
		this.elements = new Object[CAPACITY];
		
	}
	
	public static void main(String [] args) {
		ArrayBasedStackV2<Integer> stack = new ArrayBasedStackV2<Integer>();
		
		for(int i = 0; i < 20; i++) {
			stack.push(i);
		}
		
		
		for(int i = 0; i < 20; i++) {
			System.out.println(stack.pop());
		}
	}

}
