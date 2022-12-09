
public class MyObject implements MyObjectADT {
	
	private int id;
	private int width;
	private int height;
	private String type;
	private Location pos;
	private BinarySearchTree r;
	
	// Initializing required variables ^
	
	
	
	public MyObject( int id, int width, int height, String type, Location pos ) {
		
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
		
		r = new BinarySearchTree();
	}
	// Constructor, assigning variables and creating empty binary search tree ^
	
	
	
	public void setType(String type) {
		
		this.type = type;
	}
	// Set type ^
	
	
	
	public int getWidth() {
		
		return width;
	}
	// Get width ^
	
	
	
	public int getHeight() {
		
		return height;
	}
	// Get height ^
	
	
	
	public String getType() {
		
		return type;
	}
	// Get type ^
	
	
	
	public int getId() {
		
		return id;
	}
	// Get height ^
	
	
	
	public Location getLocus() {
		
		return pos;
	}
	// Get Location ^
	
	
	
	public void setLocus(Location value) {
		
		pos = value;
	}
	// Set locus of MyObject to specified value ^
	
	
	
	public void addPel(Pel pix) throws DuplicatedKeyException {
		
	BNode x = r.getRoot();
	
	r.put(x, pix);
		
	}
	// Inserts pix into binary search tree associated with this MyObject ^
	
	
	
	public boolean intersects(MyObject otherObject) {
		
		int x; // represents x'
		int y; // represents y'
		
		Pel p = null;
		
		try {
			p = r.smallest(r.getRoot()); // get the smallest node in this tree
			
		} catch (EmptyTreeException e) {
			e.printStackTrace();
		}	
		
		while (p != null) { // Until we have gone through this entire tree...
			
			x = (p.getLocus().getx() + this.getLocus().getx() - otherObject.getLocus().getx());
			
			y = (p.getLocus().gety() + this.getLocus().gety() - otherObject.getLocus().gety());
			
			// Getting x and y coordinates from given algorithm ^
			
			
			Location w = new Location(x,y);  // creating dummy location to search for coordinates
			
			
			Pel other = otherObject.r.get(otherObject.r.getRoot(), w); // Search the other tree for a node with x & y coordinates
			
			
			if (other != null) { // if a Pel with same coordinates is found...
				
				return true; // there is an intersection
			}
			
			p = r.successor(r.getRoot(), p.getLocus()); // iterate to the next node in this tree
		}
		
		return false; // if no intersection is found after having gone through the entire tree, return false
		
	}
	// Returns true if this MyObject intersects the one specified in the parameter ^
	
	

}
