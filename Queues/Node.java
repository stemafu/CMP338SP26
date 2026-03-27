
public class Node<E> {
	private Node<E> previous;
	private E data;
	private Node<E> next;
	
	public Node(E data) {
		this.data = data;
		this.previous = null;
		this.next = null;
	}

	public Node<E> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	
}
