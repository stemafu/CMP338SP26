import java.util.Iterator;
import java.util.Vector;

public class CustomIterator<E> implements Iterator<E> {
	
	/*
	 * Iterator is used to iterate over a list of elements
	 */
	
	private Vector<E> vector;
	private int count;
	
	public CustomIterator(Vector<E> vector) {
		this.vector = vector;
		count = 0;
	}

	@Override
	public boolean hasNext() {
		
		return (count < this.vector.size());
	}

	@Override
	public E next() {
	
		E nextElement = vector.get(count);
		count++;
		return nextElement;
	}

}
