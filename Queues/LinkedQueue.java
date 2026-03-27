import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements QueueInterface<E> {

	private Node<E> front;
	private Node<E> back;
	private int size;

	public LinkedQueue() {
		this.front = null;
		this.back = null;
		this.size = 0;
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {

		return (this.size == 0);
	}

	@Override
	public int size() {

		return this.size;
	}

	@Override
	public QueueInterface<E> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(E element) throws IllegalStateException, NullPointerException {

		if(element == null) {
			throw new NullPointerException("Element is null");
		}

		Node<E> node = new Node<E>(element);

		if(this.isEmpty()) {
			this.front = node;
			this.back = node;
			this.size++;
		}else {
			this.back.setNext(node);
			node.setPrevious(this.back);
			this.back = node;
			this.size++;
		}

	}

	@Override
	public E peek() {

		if(this.isEmpty()) {
			return null;
		}else {
			return front.getData();
		}


	}

	@Override
	public E dequeue() {
		if(this.isEmpty()) {
			return null;
		}else {		
			E removedElement = this.front.getData();

			if(this.size == 1) {
				removeAll();
			}else {


				Node<E> newFront = this.front.getNext();

				this.front = newFront;
				this.front.setPrevious(null);
				this.size--;
			}

			return removedElement;

		}
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		
		if(index < 0 || index >= this.size) {
			throw new NoSuchElementException("Invalid index");
		}
		
		
		
		if(index == 0) {
			return this.dequeue();
		}else if(index == size - 1) {
			E removedElement = this.back.getData();
			Node<E> previousNode = this.back.getPrevious();
			
			this.back = previousNode;
			this.back.setNext(null);
			this.size--;
			
			return removedElement;
		}else {
			
			int i = 0;
			Node<E> currentNode = this.front;
			
			while(i < index) {
				currentNode = currentNode.getNext();
				i++;
			}
			
			E removedElement = currentNode.getData();
			
			Node<E> previousNode = currentNode.getPrevious();
			Node<E> next = currentNode.getNext();
			previousNode.setNext(next);
			next.setPrevious(previousNode);
			this.size--;
			return removedElement;
			
		}
		
		
	
	}

	@Override
	public void removeAll() {
		this.front = null;
		this.back = null;
		this.size = 0;

	}

}
