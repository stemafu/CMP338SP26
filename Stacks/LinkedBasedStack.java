import java.util.Iterator;

public class LinkedBasedStack <E> implements StackInterface<E>{

	private Node<E> bottom;
	private Node<E> top;
	private int numElements;
	
	
	public LinkedBasedStack() {
		bottom = null;
		top = null;
		numElements = 0;
	}
	
	
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
	
		return numElements == 0;
	}

	@Override
	public int size() {
		
		return numElements;
	}

	@Override
	public StackInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		
		if(e == null) {
			throw new NullPointerException("The parameter e cannot be null");
		}
		
		// Create a new node to hold the element
		
		Node<E> node = new Node<E>(e);
		
		if(this.isEmpty()) {
			bottom = node;
			top = node;
		}else {
			top.setNext(node);
			node.setPrevious(top);
			top = node;
		}
		this.numElements++;
		
	}

	@Override
	public E peek() {
		
		if(this.isEmpty()) {
			return null;
		}
		
		return this.top.getData();
	}

	@Override
	public E pop() {
		
		if(this.isEmpty()) {
			return null;
		}
		
	
		
		E removedElement = this.top.getData();
		
		if(this.numElements == 1) {
			this.clear();
			
		}else {
			this.top = this.top.getPrevious();
			this.top.setNext(null);
			this.numElements--;
			
		}
	
		
		return removedElement;
	}

	@Override
	public void clear() {
		this.top = null;
		this.bottom = null;
		this.numElements = 0;
	}

}
