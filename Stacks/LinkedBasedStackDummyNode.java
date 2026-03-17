import java.util.Iterator;

public class LinkedBasedStackDummyNode<E> implements StackInterface<E>{
	
	private Node<E> top;
	private Node<E> bottom;
	private int numElements;
	
	public LinkedBasedStackDummyNode() {
		/*
		 * A dummy node. This just a node without any valid data
		 * 
		 */
		Node<E> dummyNode = new Node<E>(null);
		this.top = dummyNode;
		this.bottom = dummyNode;
		
		
		
	}
	
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StackInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		
		Node<E> node = new Node<E>(e);
		this.top.setNext(node);
		node.setPrevious(this.top);
		this.top = node;
		this.numElements++;
		
	}

	@Override
	public E peek() {
		
		return this.top.getData();
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Node<E> dummyNode = new Node<E>(null);
		this.top = dummyNode;
		this.bottom = dummyNode;
	}

}
