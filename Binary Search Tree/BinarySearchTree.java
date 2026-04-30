
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
						node.setParent(currentNode);
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
						node.setParent(currentNode);
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

	
	public TreeNode<E, K> findNode(K key) {
		/*
		 * The search in a BST always starts from the 
		 * root.
		 */
		TreeNode<E, K> currentNode = this.root;
		
		while(currentNode != null) {
			
			K currentNodeKey = currentNode.getElement().getKey();
			
			if(currentNodeKey.compareTo(key) == 0) {
				return currentNode;
			}else if(key.compareTo(currentNodeKey) < 0) {
				currentNode = currentNode.getLeftChild();
			}else {
				currentNode = currentNode.getRightChild();
			}
		}
		
		return null;
	}	
	
	
	
	
	@Override
	public void delete(K key) throws TreeException {

		/*
		 * Deletion from a BST involves two steps:
		 * 
		 * Step 1: You search and find the node to be deleted.
		 *       We are going to create a helper method that we 
		 *       will use for finding the node to be deleted.
		 *   findNode(K key)
		 *   
		 * Step 2: Once we find the node, we delete it while preserving
		 * the BST properties.
		 * 
		 * When deleting from a BST, there are three cases that we
		 * have to consider.
		 * 
		 * 
		 * Case 1: Deleting a left node (Node without children);
		 * We go to the parent of the node to be deleted and set 
		 * the appropriate child to null.
		 */
		
		// Step 1
		TreeNode<E, K> nodeToBeDeleted = this.findNode(key);
		
		if(nodeToBeDeleted != null) {
			// Step 2
			this.deleteNode( nodeToBeDeleted);
		}
		
	}
	
	private void deleteNode(TreeNode<E, K> nodeToBeDeleted){
		/*
		 * Case is the node to be deleted a leaf node?
		 * 
		 * How would we know that the node to be deleted is a leaf node?
		 * If both left and right child are null.
		 */
		
		TreeNode<E, K> parentOfNodeToDeleted = nodeToBeDeleted.getParent();
		
		if(this.isLeafNode(nodeToBeDeleted)) {
			// Delete the leaf node
			
			if(parentOfNodeToDeleted == null) {
				/*
				 * The leaf node is the root and the only
				 * node in the tree.
				 */
				this.root = null;
			}else {
				
				/*
				 * If the node to be deleted is the left child
				 * of the parent, we will set the left child of the
				 * parent to null.
				 * 
				 * How would you know that a leaf node, which the node to be deleted,
				 * is the left child of the parent node?
				 * 
				 * 
				 */
				
				if(this.isNodeLeftChildOfParent(nodeToBeDeleted, parentOfNodeToDeleted)) {
					parentOfNodeToDeleted.setLeftChild(null);
					nodeToBeDeleted.setParent(null);
				}else {
	
					/* If the node to be deleted is the right child
					 * of the parent, then we will set the right child
					 * of the parent to null.
					 */
					parentOfNodeToDeleted.setRightChild(null);
					nodeToBeDeleted.setParent(null);
				}
				
				// end of leaf node deletion
				}
			}
		else if (this.nodeHasLeftChildOnly(nodeToBeDeleted)) {
			
			/*
			 * parent = nodeToBeDeleted.getParent()
			 */
			if (parentOfNodeToDeleted == null) {
				/*
				 * This means we are deleting the root of the tree.
				 * This requires to update the root of the tree
				 * to the left child.
				 * 
				 * Since the node to be deleted has the left child only
				 * then this left child becomes the root of the tree.
				 */
				
				this.root = parentOfNodeToDeleted.getLeftChild();
				this.root.setParent(null); // the root has not parent
			}else if(this.isNodeLeftChildOfParent(nodeToBeDeleted, parentOfNodeToDeleted)) {
				parentOfNodeToDeleted.setLeftChild(nodeToBeDeleted.getLeftChild());
				nodeToBeDeleted.getLeftChild().setParent(parentOfNodeToDeleted);
			}else {
				parentOfNodeToDeleted.setRightChild(nodeToBeDeleted.getLeftChild());
				nodeToBeDeleted.getLeftChild().setParent(parentOfNodeToDeleted);
			}

				
		
		}
	}
	
	
	/*public boolean isNodeLeftChildOfParentNode(TreeNode<E, K> node, TreeNode<E, K> parent ) {
		return 
	}*/
	
	
	
	
	public boolean nodeHasLeftChildOnly(TreeNode<E, K> node) {
		/*
		 * How would we know that a give node has a left child
		 * only. This means that is has no right child?
		 * If the right child is null and the left child is not null
		 */
		
		return node.getLeftChild() != null 
				&& node.getRightChild() == null;
		
	}
	
	
	
	/*
	 * This method returns true if node is the left child of parent.
	 */
	private boolean isNodeLeftChildOfParent(TreeNode<E, K> node, TreeNode<E, K> parent ) {
		return (parent.getLeftChild() == node);
	}
	
	private boolean isLeafNode(TreeNode<E, K> node) {
		return (node.getLeftChild() == null 
				&& node.getRightChild() == null);
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
