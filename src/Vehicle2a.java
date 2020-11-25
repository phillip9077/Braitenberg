package src;

public class Vehicle2a extends GameObject {

	Sensor sensor_left = null;
	Sensor sensor_right = null;
	
	public Vehicle2a(String s) {
		super(s);
		sensor_left = new Sensor(50, 50, 6, 2, "./Images/dot.png", 0);
		sensor_right = new Sensor(50, 50, 6, -2, "./Images/dot.png", 0);
	}
	
	public Vehicle2a(float x, float y, String s, float deg) {
		super(x,y,s,deg);
		sensor_left = new Sensor(x, y, 6, 2, "./Images/dot.png", deg);
		sensor_right = new Sensor(x, y, 6, -2, "./Images/dot.png", deg);
	}
	
	@Override
	public void update(Sun other) {
		float base = 5;
		float constant = 5f;
		float rotR = base + (constant * sensor_right.getIntensity1(other.pos)); 
		float rotL = -base	- (constant * sensor_left.getIntensity1(other.pos)); 
		float deltaTheta = rotR + rotL;
		this.dir.rotateVec(deltaTheta);
		pos.addVec(this.dir);
		
		/*float totalIntensity = sensor_left.getIntensity1(other.pos) + sensor_right.getIntensity1(other.pos);
		Vector lol = new Vector(this.dir.deg);
		Vector temp = lol.mult(1 * totalIntensity);
		pos.addVec(this.dir);
		pos.addVec(temp);*/
		
		sensor_left.update(this);
		sensor_left.offset.rotateVec(deltaTheta);		
		sensor_right.update(this);
		sensor_right.offset.rotateVec(deltaTheta);
		resetPos();
	}
	
	public void draw() {
		StdDraw.picture(pos.x, pos.y, image, dir.deg * (180/Math.PI)); //draws the car
		sensor_left.draw();
		sensor_right.draw();
	}
	
}
