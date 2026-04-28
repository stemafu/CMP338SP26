
public class BinarySearchTree 
<E extends KeyedElementInterface<K>, K extends Comparable<? super K>>

implements BinarySearchTreeInterface<E, K>


{
	/*
	 * A BST is a rooted tree. There is some node that is always dedicated
	 * to be the root of the tree. When the tree is empty the root is 
	 * null.
	 */
	private TreeNode<E, K> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public BinarySearchTree(TreeNode<E, K> root) {
		this.root = root;
	}

	@Override
	public TreeNode<E, K> getRoot() {
		
		return this.root;
	}

	@Override
	public void setRoot(TreeNode<E, K> root) {
		this.root = root;
		
	}

	@Override
	public boolean isEmpty() {
		/*if(this.root == null)
			return true;
		else 
			return false;*/
		return (this.root == null);
	}

	@Override
	public void makeEmpty() {
		this.root = null;
		
	}

	@Override
	public BinarySearchTreeInterface<E, K> copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E find(K key) {
		
		/*
		 * The search in a BST always starts from the 
		 * root.
		 */
		TreeNode<E, K> currentNode = this.root;
		
		while(currentNode != null) {
			
			K currentNodeKey = currentNode.getElement().getKey();
			
			if(currentNodeKey.compareTo(key) == 0) {
				return currentNode.getElement();
			}else if(key.compareTo(currentNodeKey) < 0) {
				currentNode = currentNode.getLeftChild();
			}else {
				currentNode = currentNode.getRightChild();
			}
			
			
		}
		
		
		return null;
	}

	@Override
	public void insert(E element) {
		
		
		// We will need to create a node for the given element.
		TreeNode<E, K> node = new TreeNode<E, K>(element);
		// Each element has a key in it
		
		if(this.isEmpty()) {
			this.root = node;
		}else {
			/* If the tree is not empty, we have to search for the 
			 * location where we have to insert the node. The search
			 * starts from root. Once we find the location, then 
			 * we insert the element there.
			 */
			
			TreeNode<E, K> currentNode = this.root;
			K key = element.getKey();
			
			while(currentNode != null) {
				
				K currentNodeKey = currentNode.getElement().getKey();
				/*
				 * We want to use the key that is at the current node
				 * to compare it against the key of the element that
				 * want to insert into the tree
				 */
				
				
				if (key.compareTo(currentNodeKey) < 0) {
					/*
					 * Then this means we want to insert the value on
					 * the left
					 */
					
					if(currentNode.getLeftChild() == null) {
						// this means we have found where to insert on the left
						currentNode.setLeftChild(node);
						return;
					}else {
						currentNode = currentNode.getLeftChild();
						
					}
				}else if (key.compareTo(currentNodeKey) > 0) {
					
					/*
					 * This means search for the location where 
					 * to insert the element on the fight subtree.
					 */
					if(currentNode.getRightChild() == null) {
						// We have found where to insert
						currentNode.setRightChild(node);
						return;
					}else {
						currentNode = currentNode.getRightChild();
					}
				
				}else {
					break;
				}
				
			}
			
		}
		
	}

	@Override
	public void delete(K key) throws TreeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBalanced() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void balance() {
		// TODO Auto-generated method stub
		
	}	
}
