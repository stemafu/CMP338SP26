
public class Node <I extends Comparable<? super I>> {
	private I data;
	private  Node<I> next;
	
	public Node(I data) {
		this.data = data;
		this.next = null;
	}

	public I getData() {
		return data;
	}

	public void setData(I data) {
		this.data = data;
	}

	public Node<I> getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	

}
