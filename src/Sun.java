package src;

public class Sun extends GameObject
{

	
	public Sun(String s, float deg) {
		super(0, 0, s, deg);
	}	
	
	public Sun(float x, float y, String s, float deg) {
		super(x, y, s, deg);
	}
	
	public void draw() {
		StdDraw.picture(pos.x, pos.y, image, dir.deg * (180/Math.PI));
	}
}
