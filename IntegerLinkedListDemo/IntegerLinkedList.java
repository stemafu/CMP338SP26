
public class IntegerLinkedList implements ListInterface {

	/*
	 * In a linkedlist, we always need to have an address that
	 * always point to the first node in the linkedlist. This
	 * address will be null if the linkedlist list is empty.
	 * 
	 * This address is called the head. The head is an 
	 * entry point of a linkedlist.
	 * 
	 * This is called the head node
	 */
	Node head;
	
	/*
	 * The tail always points to the last node in the linked list.
	 * 
	 */
	Node tail;
	
	
	private int numElements;
	
	public IntegerLinkedList(){
		this.head = null;
		this.tail = null;
		this.numElements = 0;
	}
	
	@Override
	public boolean isEmpty() {
		
		//return (this.head == null);
		return (this.numElements == 0);
	}

	@Override
	public int size() {
		
		return this.numElements;
	}

	@Override
	public void add(int num) {
		/*
		 * this method is used to add the specified number
		 * to the end of the list. The end of the list 
		 * is indicated by tail.
		 */
		
		// First we create a node for the specified number.
		Node node = new Node(num);
		
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
	public void add(int num, int index) throws ArrayIndexOutOfBoundsException {
		
		if(index < 0 || index > this.numElements) {
			throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
		}
		
		if((index == 0 && this.isEmpty()) || index == this.numElements) {
			this.add(num);
			// tail index
		}else {
			Node node = new Node(num);
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
				Node currentNode = this.head;
				Node previousNode = null;
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
	public void addSorted(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get(int index) throws ArrayIndexOutOfBoundsException {
	
		
		if(index < 0 || index >= this.numElements) {
			throw new ArrayIndexOutOfBoundsException("invalid index " + index);
		}
		
		Node currentNode = this.head;
		int currentNodeIndex = 0;
		
		while(currentNodeIndex < index) {
			currentNode = currentNode.getNext();
			currentNodeIndex++;
		}
		return currentNode.getData();
	}

	@Override
	public int remove(int index) throws ArrayIndexOutOfBoundsException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeAll() {
		this.head = null;
		this.tail = null;
		this.numElements = 0;
		
	}

	@Override
	public int replace(int num, int index) throws ArrayIndexOutOfBoundsException{
		if(index < 0 || index >= this.numElements) {
			throw new ArrayIndexOutOfBoundsException("invalid index " + index);
		}
		
		Node currentNode = this.head;
		int currentNodeIndex = 0;
		
		while(currentNodeIndex < index) {
			currentNode = currentNode.getNext();
			currentNodeIndex++;
		}
		
		int replacedElement = currentNode.getData();
		
		currentNode.setData(num);
		return replacedElement;
	}

}
