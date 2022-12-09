
public class Pel {
	
	
	private Location loc;
	private int color;
	
	// Initializing required variables ^
	
	public Pel(Location p, int color) {
		
		loc = p;
		this.color = color;
	}
	// Constructor, initializing Pel object with specified coordinates and color ^
	
	
	public Location getLocus() {
		
		return loc;
	}
	// Return Location of Pel object ^
	
	
	
	public int getColor() {
		
		return this.color;
	}
	// Return color of Pel object ^

}
