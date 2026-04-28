
public class Node<T> {
	private T data; // this keeps the data at this node
	private Node<T> next; // This stores the address of the next node
	private Node<T> previous; // stores address of the previous node

	
	public Node(T data){
		this.previous = null;
		this.data = data;
		this.next = null;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getNext(){
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getPrevious(){
		return this.previous;
	}
	
	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}
}
