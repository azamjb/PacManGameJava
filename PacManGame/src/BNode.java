
public class BNode {
	
	private Pel pelval;
	private BNode lnode;
	private BNode rnode;
	private BNode pnode;
	
	// Initializing required variables ^
	
	
	public BNode(Pel value, BNode left, BNode right, BNode parent) {
		
		pelval = value;
		lnode = left;
		rnode = right;
		pnode = parent;
	}
	// Constructor, assigning left, right, and parent node, as well as pel value ^
	
	
	
	public BNode() {
		
		pelval = null;
		lnode = null;
		rnode = null;
		pnode = null;
	}
	// Constructor, creating a leaf node, setting data, children, and parent attributes to null ^
	
	
	
	public BNode parent() {
		
		return pnode;
	}
	// Return parent of this node ^
	
	
	
	public void setParent(BNode newParent) {
		
		pnode = newParent;
	}
	// Set parent of this node to specified value ^
	
	
	
	public void setLeftChild(BNode p) {
		
		lnode = p;
	}
	// Set left child of this node to specified value ^
	
	
	
	public void setRightChild(BNode p) {
		
		rnode = p;
	}
	// Set right child of this node to specified value ^
	
	
	
	public void setContent(Pel value) {
		
		pelval = value;
	}
	// Stores given Pel object in this node ^
	
	
	
	public Boolean isLeaf() {
		
		return ( (lnode == null) && (rnode == null) );
	}
	// Return true if this node is a leaf, false otherwise ^
	
	
	
	public Pel getData() {
		
		return pelval;
	}
	// Return Pel object stored in this node ^  
	
	
	
	public BNode leftChild() {
		
		return lnode;
	}
	// Return left child of this node ^
	
	
	
	public BNode rightChild() {
		
		return rnode;
	}
	// Return right child of this node ^
	
}
