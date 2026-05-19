
public class MaxHeap {
	
	private int heap[];
	private int size;
	private final int CAPACITY = 10;
	
	public MaxHeap() {
		this.size = 0;
		this.heap = new int[CAPACITY];
	}
	
	public MaxHeap(int capacity) {
		this.size = 0;
		this.heap = new int[capacity];
	}	

	
	public void insert(int num) {
		
		if(this.size == this.heap.length) {
			// This means the array is full.
			System.out.println("We cannot add a new value because the heap is full");
			return;
		}
		
		/*
		 * If the heap is not full, then we can insert
		 * at the last index.
		 */
		this.heap[this.size] = num;
		/*
		 * We heapify up to maintain the heap properties
		 */
		this.heapifyUp();
		
		this.size++;
	}
	
	public int remove() throws IndexOutOfBoundsException{
		
		if(this.size == 0) {
			throw new IndexOutOfBoundsException("The heap is empty()");
		}
		
		/*
		 * In heap, we always remove the value at the root
		 * In MaxHeap, this would be the biggest value in the heap.
		 * In a MinHeap, it would be the smallest.
		 */
		int removedNum = this.heap[0];
		
		
		if(this.size == 1) {
			this.size--;
			return removedNum;
		}else if (this.size == 2) {
			this.heap[0] = this.heap[this.size - 1];
			this.size--;
			return removedNum; 
		}else {
		
			this.heap[0] = this.heap[this.size - 1];
			
			this.size--;
			this.heapifyDown();
			
			return removedNum;
		}
	}
	
	private void heapifyDown() {
		
		int index = 0;
		
		while (true) {
			
			
			int leftChildIndex = (2 * index) + 1;
			int rightChildIndex = (2 * index) + 2;
			
			int largestIndex = index;
			
			if(leftChildIndex < this.size && this.heap[leftChildIndex] > this.heap[largestIndex]) {
				largestIndex = leftChildIndex;
			}
			
			if(rightChildIndex < this.size && this.heap[rightChildIndex] > this.heap[largestIndex]) {
				largestIndex = rightChildIndex;
			}
			
			if(largestIndex != index) {
				
				int temp = this.heap[index];
				this.heap[index] = this.heap[largestIndex];
				this.heap[largestIndex] = temp;
				
				index = largestIndex;
			}else {
				break;
			}
		}
		
		
	}
	
	
	private void heapifyUp() {
		
		int index = this.size;
		
		while(index > 0) {
			
			int parentIndex = (index - 1) / 2;
			if(this.heap[index] > this.heap[parentIndex]) {
				int temp = this.heap[index];
				this.heap[index] = this.heap[parentIndex];
				this.heap[parentIndex] = temp;
				
				index = parentIndex;
			}else {
				break;
			}
			
			
			
		}
		
	}
	
	public void display() {
		for(int i = 0; i < this.size; i++) {
			System.out.print(this.heap[i] + " ");
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public static void main(String [] args) {
		MaxHeap heap = new MaxHeap();
		
		heap.insert(30);
		heap.insert(40);
		heap.insert(80);
		heap.insert(89);
		heap.insert(100);
		heap.insert(10);
		
		
		int [] nums = new int [heap.size()];
		
		for(int i =  heap.size() - 1; i >= 0; i--) {
			nums[i] = heap.remove();
		}
		
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		
		heap.display();
	}
	
	
	
}
