
public class Node <E>{
	private Node<E> previous;
	private E data;
	private Node<E> next;
	
	public Node(E data) {
		this.data = data;
		this.previous = null;
		this.next = null;
	}
	
	
	public void setData(E data) {
		this.data = data;
	}
	
	public E getData() {
		return this.data;
	}
	
	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}
	
	public Node<E> getPrevious(){
		return this.previous;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public Node<E> getNext(){
		return this.next;
	}
	

}
