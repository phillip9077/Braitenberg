package src;

public class Sensor extends GameObject {
	
	Vector offset;
	
	public Sensor(String s, float deg) {
		super(0, 0, s, deg);
		offset = new Vector (deg);
	}
	
	public Sensor(float carX, float carY, float offX, float offY, String s, float deg) {
		super(carX + offX, carY + offY, s, deg);
		offset = new Vector (offX, offY);
		offset.rotateVec(deg);
		this.pos.x = carX + this.offset.x;
		this.pos.y = carY - this.offset.y;
	}
	
	/*
	 * add the magnitude of the offset vector 
	 * to the vehicle's position, and then rotate it
	 */
	@Override
	public void update(GameObject other) {
		this.pos.x = other.pos.x + this.offset.x;
		this.pos.y = other.pos.y + this.offset.y;
	}
	
	public void draw() {
		StdDraw.picture(this.pos.x, this.pos.y, image, 0);
	}
	
	public float getDist(Sun other) {
		return (float) (Math.sqrt(Math.pow(this.pos.x - other.pos.x, 2) + Math.pow(this.pos.y - other.pos.y, 2)));
	}
	
	public float getIntensity1(Point other1) {
		float intensity = (float) (1/(Math.pow(this.pos.getDist(other1),2)));
		return intensity; 
	}
	
	public float getIntensity2(Point other2) {
		float intensity = (float) (0.001* (Math.pow(this.pos.getDist(other2),2)));
		return intensity;
	}
	
}
