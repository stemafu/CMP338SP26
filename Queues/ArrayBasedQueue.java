import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayBasedQueue <E> implements QueueInterface<E>{
	private final int CAPACITY = 10;
	private Object [] elements;
	private int size;
	private int front;
	private int back;

	public ArrayBasedQueue(){
		elements = new Object[CAPACITY];
		size = 0;
		front = -1;
		back = -1;

	}


	@Override
	public Iterator<E> iterator() {

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
			throw new NullPointerException("Element cannot be null");
		}

		if(this.size == this.elements.length) {
			throw new IllegalStateException("The queue is full and cannot add a new element");
		}


		if(this.isEmpty()) {
			this.back = 0;
			this.front = 0;
			this.elements[this.back] = element;
			this.back++;
			this.size++;
		}else {
			this.elements[this.back] = element;
			this.back++;
			this.size++;
		}

	}

	@Override
	public E peek() {

		if(this.isEmpty()) {
			return null;
		}
		return (E)elements[front];
	}

	@Override
	public E dequeue() {

		if(this.isEmpty()) {
			return null;
		}

		E removedElement = this.peek();

		this.size--;
		this.front++;

		return removedElement;
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {

		if (index < 0 || index >= this.size) {
			throw new NoSuchElementException("Bad index");
		}



		if(this.size == 1 || index == this.size -1) {

			return this.dequeue();
		}
		else {
			E removedElement = null;

			removedElement = (E)this.elements[index];

			for(int i = index; i < this.size - 1; i++) {
				this.elements[i] = this.elements[i + 1];
			}

			this.size--;


			return removedElement;

		}
	}

	@Override
	public void removeAll() {

		elements = new Object[CAPACITY];
		size = 0;
		front = -1;
		back = -1;


	}

}
