
public class LinkedList <I extends Comparable<? super I>> implements
ListInterface <I>{
	
	private Node<I> head;
	private Node<I> tail;
	private int numElements;
	
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.numElements = 0;
	}
	

	@Override
	public ListInterface<I> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.numElements;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.numElements == 0);
	}

	@Override
	public void add(I element) {
		// First we create a node for the specified number.
		Node<I> node = new Node<I>(element);

		/* if our list is empty, then the fist element to be 
		 * added will be the part of the head.
		 */
		if(this.isEmpty()) {
			this.head = node;
			//this.tail = node;
			//this.numElements++;
		}else {
			/*if the list is not empty, then the new node 
			that has just been created will be appended
			to the tail of the list.
			 */
			this.tail.setNext(node);
			//this.tail = node;
			//this.numElements++;
		}
		this.tail = node;
		this.numElements++;
		
	}

	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > this.numElements) {
			throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
		}

		if((index == 0 && this.isEmpty()) || index == this.numElements) {
			this.add(element);
			// tail index
		}else {
			Node<I> node = new Node<I>(element);
			if (index == 0 && !this.isEmpty()) {
				/*
				 * This is used to insert at the head when the 
				 * linkedlist is not empty
				 * head index
				 */
				node.setNext(this.head);
				this.head = node;
				this.numElements++;
			}else {
				/*
				 * This is used to insert in the linked list 
				 * at middle(any non-head or non-tail index)
				 */
				Node<I> currentNode = this.head;
				Node<I> previousNode = null;
				int currentNodeIndex = 0;

				while(currentNodeIndex < index) {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
					currentNodeIndex++;
				}

				previousNode.setNext(node);
				node.setNext(currentNode);
				this.numElements++;
			}

		}
	}

	@Override
	public void addSorted(I element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public I get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= this.numElements) {
			throw new ArrayIndexOutOfBoundsException("invalid index " + index);
		}

		Node<I> currentNode = this.head;
		int currentNodeIndex = 0;

		while(currentNodeIndex < index) {
			currentNode = currentNode.getNext();
			currentNodeIndex++;
		}
		
		return currentNode.getData();
	}

	@Override
	public I replace(I element, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public I remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= this.numElements) {
			throw new ArrayIndexOutOfBoundsException("invalid index " + index);
		}

		I removedElement;
		if(this.numElements == 1 && index == 0) {
			removedElement = this.head.getData();
			this.removeAll();
			return removedElement;
		}else if(index == 0) {
			// removing at the head and updating the head
			removedElement = this.head.getData(); // *
			Node<I> currentNode = head;
			this.head = this.head.getNext(); // *
			currentNode.setNext(null);
			this.numElements--; // **
			return removedElement ;
		}
		else {

			int currentNodeIndex = 0;
			Node<I> currentNode = head;
			Node<I> previousNode = null;

			while(currentNodeIndex < index) {
				previousNode = currentNode;
				currentNode = currentNode.getNext();
				currentNodeIndex++;
			}


			
			if (index == (this.numElements - 1)) {
				// removing at the tail
				this.tail = previousNode;
				this.tail.setNext(null);
				//this.numElements--;
				
			}else {
				previousNode.setNext(currentNode.getNext());
				currentNode.setNext(null);
			}
			
			numElements--;
			return currentNode.getData();
		}
	}

	@Override
	public void removeAll() {
		this.head = null;
		this.tail = null;
		this.numElements = 0;
		
	}

}
