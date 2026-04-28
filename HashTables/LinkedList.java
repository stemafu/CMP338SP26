import java.util.Iterator;

public class LinkedList <T> implements ListInterface<T> {


	private int numElements = 0;

	private Node<T> head;
	private Node<T> tail;


	public LinkedList() {
		this.numElements = 0;
		this.head = null;
		this.tail = null;
	}

	public Iterator<T> iterator() {
		
		return null;
	}
	
	
	
	@Override
	public boolean isEmpty() {
		//return (this.head == null && this.tail == null);
		return (this.numElements == 0);
	}

	@Override
	public int size() {

		return this.numElements;
	}

	@Override
	public void add(T element) {

		if(element == null) {
			throw new NullPointerException("Element cannot be null");
		}

		Node<T> node = new Node<T>(element);

		if(this.isEmpty()) {
			head = node;
			tail = node;
			this.numElements++;
		}else {
			
			this.tail.setNext(node);
			node.setPrevious(tail);
			this.tail = node; 
			this.numElements++;
		}



	}

	@Override
	public void add(T element, int index) throws ArrayIndexOutOfBoundsException {
		
		if(index < 0 || index > this.numElements) {
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
		
		
		if ((this.isEmpty() && index == 0) || (index == numElements) ){
			/*
			 * This adds to the empty list or add at the tail of the
			 * list.
			 */
			this.add(element);
		}else if( !this.isEmpty() && index == 0) {
			// Adding a new head
			Node<T> node = new Node<T>(element);
			
			node.setNext(head);
			this.head.setPrevious(node);
			this.head = node;
			this.numElements++;
		}else {
			// Adding an element that is not a head and tail
			
			int i = 0;
			Node<T> currentNode = this.head;
			
			while (i < index) {
				currentNode = currentNode.getNext();
				i++;
			}
			Node<T> node = new Node<T>(element);
			Node<T> previousNode = currentNode.getPrevious();
			
			previousNode.setNext(node);
			node.setPrevious(previousNode);
			
			node.setNext(currentNode);
			currentNode.setPrevious(node);
			this.numElements++;
		}

	}

	@Override
	public void addSorted(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public T get(int index) throws ArrayIndexOutOfBoundsException {


		if(index < 0 || index >= this.numElements) {
			throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
		}


		if(index == 0) {
			return this.head.getData();
		}else if (index == (this.numElements - 1)){
			return this.tail.getData();
		}else {
			int i = 0;
			Node<T> currentNode = this.head;

			while(i < index) {
				currentNode = currentNode.getNext();
				i++;
			}

			return currentNode.getData();
		}
	}

	@Override
	public T remove(int index) throws ArrayIndexOutOfBoundsException {
		if(index < 0 || index >= this.numElements) {
			throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
		}
		
		T removedElement = null;
		
		if(this.numElements == 1 && index == 0) {
			/* This means there is only one item in the linkedlist
			 * and this is at index 0.
			 */
			removedElement = this.head.getData();
			this.removeAll();
			return removedElement;
		}else if (index == 0) {
			removedElement = this.head.getData();
			Node<T> removedNode = this.head;
			
			this.head = this.head.getNext();
			this.head.setPrevious(null);
			removedNode.setNext(null);
			this.numElements--;
			return removedElement;
		}else if (index == this.numElements - 1) {
			
			removedElement = this.tail.getData();
			
			Node<T> removedNode = this.tail;
			
			this.tail = this.tail.getPrevious();
			this.tail.setNext(null);
			removedNode.setPrevious(null);
			
			this.numElements--;
			return removedElement;
		}else {
			int i = 0;
			Node<T> currentNode = this.head;
			
			while(i < index) {
				currentNode = currentNode.getNext();
				i++;
			}
			
			removedElement = currentNode.getData();
			Node<T> newNextAfterRemoval = currentNode.getNext();
			Node<T> newPreviousAfterRemoval = currentNode.getPrevious();
			
			newPreviousAfterRemoval.setNext(newNextAfterRemoval);
			newNextAfterRemoval.setPrevious(newPreviousAfterRemoval);
			
			currentNode.setNext(null);
			currentNode.setPrevious(null);
			
			this.numElements--;
			
			return removedElement;
			
		}
		
	}

	@Override
	public void removeAll() {

		this.numElements = 0;
		this.head = null;
		this.tail = null;

	}

	@Override
	public T replace(T element, int index) throws ArrayIndexOutOfBoundsException {

		if(index < 0 || index >= this.numElements) {
			throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
		}

		T replacedElement = null;
		
		if(index == 0) {
			replacedElement = this.head.getData();
			this.head.setData(element);
		}else if (index == (this.numElements - 1)){
			replacedElement = this.tail.getData();
			this.tail.setData(element);	
		}else {
			int i = 0;
			Node<T> currentNode = this.head;

			while(i < index) {
				currentNode = currentNode.getNext();
				i++;
			}

			replacedElement = currentNode.getData();
			currentNode.setData(element);

			
		}




		return replacedElement;
	}

}
