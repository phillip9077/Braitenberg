package src;

public class Point
{
	float x = 0;
	float y = 0;
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getDist(Point other) {
		return (float) Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}

	/*
	 * This makes the car move
	 * Vector + another vector will add distance
	 * thus making the car "move" forward
	 */
	public void addVec(Vector other) {
		this.x += other.x;
		this.y += other.y;
	}
	
	public void updateComponents(float x, float y) {
		this.x = x;
		this.y = y;
	}
}