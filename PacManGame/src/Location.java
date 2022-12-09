
public class Location {
	
	
	private int x;
	private int y;
	
	// Initializing required variables ^
	
	public Location(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	// Constructor, initializing Location object with specified coordinates ^
	
	
	
	public int getx() {
		
		return x;
	}
	// Return x coordinate ^
	
	
	
	public int gety() {
		
		return y;
	}
	// Return y coordinate ^
	
	
	
	public int compareTo(Location p) {
		
		if ( (this.gety() > p.gety()) || ((this.gety() == p.gety()) && (this.getx() > p.getx())) ) {
			
			return 1;
		}
		
		
		if  ( (this.gety() < p.gety()) || ((this.gety() == p.gety()) && (this.getx() < p.getx())) ) {
			
			return -1;
		}
		
		else if ((this.gety() == p.gety() && this.getx() == p.getx())){ // if both pairs of coordinates are equal...
			
			return 0;
		}
		
		else {
			return 5;
		}
		
	}
	// Return 1,0, or -1 depending on comparisons of coordinates ^

	
	
}
