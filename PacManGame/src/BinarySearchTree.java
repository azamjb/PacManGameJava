
public class BinarySearchTree implements BinarySearchTreeADT {
	
	
	BNode r;
	
	// Initializing required variables
	
	
	public BinarySearchTree() {
		
		r = new BNode();
	}
	// Constructor, creating a tree whose root is a leaf node ^

	
	
	private BNode find(BNode r, Location key) {
		
		if (r.isLeaf()) { // if r is a leaf...
			
			return r; // return r
		}
		
		else { // otherwise...
			
			if (r.getData().getLocus().compareTo(key) == 0) { // if the keys are equal...
				return r; // return data from r
			}
			
			else if (r.getData().getLocus().compareTo(key) == 1) { // otherwise if r.key is greater than given key...
				
				return find(r.leftChild(),key); // make recursive call with left child
			}
			
			else {
				return find(r.rightChild(),key); // make recursive call with right child
			}
		}	
	}
	// Private helper method, identical to get(r,key) method, but returns entire BNode instead of just Pel ^



	public Pel get(BNode r, Location key) {
		
		if (r.isLeaf()) { // if r is a leaf...
			
			return r.getData(); // return data from r
		}
		
		else { // otherwise...
			
			if (r.getData().getLocus().compareTo(key) == 0) { // if the keys are equal...
				
				return r.getData(); // return data from r
			}
			
			else if (r.getData().getLocus().compareTo(key) == 1) { // otherwise if r.key is greater than given key...
				
				return get(r.leftChild(),key); // make recursive call with left child
			}
			
			else {
				return get(r.rightChild(),key); // make recursive call with right child
			}
		}
		
	}
	// Return Pel object stored in given key, if key is stored in tree ^
	
	
	
	public void put(BNode r, Pel newData) throws DuplicatedKeyException {
		
		BNode p;
		
		p = find(r,newData.getLocus());
		
		if (!p.isLeaf()) { // if p is internal...
			
			throw new DuplicatedKeyException("A node already stores the same key");
		}
		else { // otherwise...
			
			p.setContent(newData); // store the Pel in node p
			
			BNode q = new BNode();
			BNode s = new BNode();
			
			p.setLeftChild(q); 
			p.setRightChild(s); 
			q.setParent(p);
			s.setParent(p);
			// create left and right child nodes for p ^
		}
		
	}
	// Inserts newData in the tree if no data item with the same key is already there ^
	
	
	
	public void remove(BNode r, Location key) throws InexistentKeyException {
		
		BNode p;
		BNode c; // represents c'
		BNode w; // represents p'
		BNode s = null;
		
		// Variables that will be used in algorithm ^
		
		p = find(r,key); // find the selected node
		
		if (p.isLeaf() || p == null || r == null) { 
			
			throw new InexistentKeyException("Inexistent key");
		}
		
		if (p.leftChild().getData() == null && p.rightChild().getData() == null) { // node has no children
			
			p.setContent(null);
			p.setLeftChild(null);
			p.setRightChild(null);
		}
		// In case where node has no children, simply remove p 
		
		
		else if ((p.leftChild().isLeaf() && !p.rightChild().isLeaf()) || (!p.leftChild().isLeaf() && p.rightChild().isLeaf())) { // node has one child
			
			if (p.leftChild().isLeaf()) { 
				
				c = p.rightChild();
				w = p.parent();
				
				if (w.leftChild() == p) {
					w.setLeftChild(c);
				}
				else
					if (w.rightChild() == p) {
					w.setRightChild(c);
				}
				
			}
			else if (p.rightChild().isLeaf()) { 
				
				c = p.leftChild();
				w = p.parent();
				
				if (w.leftChild() == p) {
					w.setLeftChild(c);
					c.setParent(w);
				}
				else
					if (w.rightChild() == p) {
					w.setRightChild(c);
					c.setParent(w);
				}
				
			}
			
		}
		// In case where node has one child, connect parent of removed node directly to child of removed node 
		
		
		else if (!p.rightChild().isLeaf() && !p.leftChild().isLeaf()) { // node has two children
			
			try {
				
				s = findSmallest(p.rightChild());
				
				
			} catch (EmptyTreeException e) {
				e.printStackTrace();
			}
			
			p.setContent(s.getData());
			remove(s,s.getData().getLocus());
			
		}
	}
	// Removes the data item with the given key, if the key is stored in the tree ^
	
	
	
	public Pel successor(BNode r, Location key) {
		
		
		BNode p;
		
		if (r.isLeaf()) { // if r is a leaf...
			
			return null; // return null
		}
		
		else { // otherwise...
			
			p = find(r,key);
		}
		
		if (!p.isLeaf() && !p.rightChild().isLeaf()) { // if p is internal and p's right child is internal...
			
			try {
				return smallest(p.rightChild());
				
			} catch (EmptyTreeException e) {}
			
		}
		else { // if p and p's right child are not internal....
			
			p = p.parent();
			
			while ((p != null) && (p.getData().getLocus().compareTo(key) == -1)) { // while p isn't null and p's key < given key...
				
				p = p.parent();
			}
			if (p == null) { // if p is null...
				
				return null; // return null
			}
			else { // otherwise
				
				return p.getData();
			}
		}
		
		return null;
		
	}
	// Returns the Pel object with the smallest key larger than the given one ^
	
	
	
	public Pel predecessor(BNode r, Location key) {
		
		BNode p;
		
		if (r.isLeaf()) { // if r is a leaf...
			
			return null; // return null
		}
		
		else { // otherwise...
			
			p = find(r,key);
		}
		
		if (!p.isLeaf() && !p.leftChild().isLeaf()) { // if p is internal and p's right child is internal...
			
			try {
				return smallest(p.leftChild());
				
			} catch (EmptyTreeException e) {}
			
		}
		else { // if p and p's right child are not internal....
			
			p = p.parent();
			
			while ((p != null) && (p.getData().getLocus().compareTo(key) == 1)) { // while p isn't null and p's key < given key...
				
				p = p.parent();
			}
			if (p == null) { // if p is null...
				
				return null; // return null
			}
			else { // otherwise
				
				return p.getData();
			}
		}
		
		return null;
	}
	// Returns the Pel object with the largest key smaller than the given one ^
	
	
	
	public Pel smallest(BNode r) throws EmptyTreeException {
		
		BNode p;
				
		if (r.isLeaf()) {
			
			throw new EmptyTreeException("tree has no data");
		}
		else {
			p = r;
			
			while (!p.isLeaf()) { // while p is not a leaf...
				
				p = p.leftChild(); 
			}
			return p.parent().getData();
			
		}
	}
	// Returns the Pel object in the tree with the smallest key ^
	
	private BNode findSmallest(BNode r) throws EmptyTreeException {
		
		BNode p;
				
		if (r.isLeaf()) {
			
			throw new EmptyTreeException("tree has no data");
		}
		else {
			p = r;
			
			while (!p.isLeaf()) { // while p is not a leaf...
				
				p = p.leftChild(); 
			}
			return p.parent();
			
		}
	}
	// Private helper method, identical to "smallest" but returns entire node isntead of Pel
	
	
	
	public Pel largest(BNode r) throws EmptyTreeException {
		
		BNode p;
		if (r.isLeaf()) {
			
			throw new EmptyTreeException("tree has no data");
		}
		else {
			p = r;
			
			while (!p.isLeaf()) { // while p is not a leaf...
				
				p = p.rightChild();
			}
			return p.parent().getData();
			
		}
		
	}
	// : Returns the Pel object in the tree with the largest key ^
	
	
	
	public BNode getRoot() {
		
		return r;
	}
	// Return the root of the tree ^
	
	
	
	
}
