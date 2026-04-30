
public class TreeNode 
<E extends KeyedElementInterface<K>, K extends Comparable<? super K>> {

	private E element;
	
	private TreeNode<E, K> leftChild;
	private TreeNode<E, K> rightChild;
	private TreeNode<E, K> parent;
	
	
	
	public TreeNode(E element) {
		this.element = element;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}

	
	public void setParent(TreeNode<E, K> parent) {
		this.parent = parent;
	}
	
	public TreeNode<E, K> getParent(){
		return this.parent;
	}


	public E getElement() {
		return element;
	}



	public void setElement(E element) {
		this.element = element;
	}



	public TreeNode<E, K> getLeftChild() {
		return leftChild;
	}



	public void setLeftChild(TreeNode<E, K> leftChild) {
		this.leftChild = leftChild;
	}



	public TreeNode<E, K> getRightChild() {
		return rightChild;
	}



	public void setRightChild(TreeNode<E, K> rightChild) {
		this.rightChild = rightChild;
	}
	
	
	
}
