package src;

public class Vehicle2b extends GameObject {
	
	Sensor sensor_left = null;
	Sensor sensor_right = null;
	
	public Vehicle2b(String s) {
		super(s);
		sensor_left = new Sensor(50, 50, 6, 2, "./Images/dot.png", 0);
		sensor_right = new Sensor(50, 50, 6, -2, "./Images/dot.png", 0);
	}
	
	public Vehicle2b(float x, float y, String s, float deg) {
		super(x,y,s,deg);
		sensor_left = new Sensor(x, y, 6, 2, "./Images/dot.png", deg);
		sensor_right = new Sensor(x, y, 6, -2, "./Images/dot.png", deg);
	}
	
	@Override
	public void update(Sun other) {
		float rotConstant = 15f;
		float velConstant = 10f;
		
		float rotIntensity = sensor_left.getIntensity1(other.pos) - sensor_right.getIntensity1(other.pos);
		float velIntensity = sensor_left.getIntensity1(other.pos) + sensor_right.getIntensity1(other.pos);
		
		if(rotIntensity > 60) {
			rotIntensity = 60;
		}
		if(velIntensity > 0.01f) {
			rotIntensity = 0;
		}
		
		float deltaTheta = (float) (5 * rotConstant * rotIntensity);
		this.dir.rotateVec(deltaTheta);
		sensor_left.offset.rotateVec(deltaTheta);
		sensor_right.offset.rotateVec(deltaTheta);
		
		Vector lol = new Vector(this.dir.deg);
		Vector temp = lol.mult(3 * velConstant * velIntensity);
		
		pos.addVec(this.dir); //base speed
		pos.addVec(temp); //accelerates the car
		
		sensor_left.update(this);
		sensor_right.update(this);
		resetPos();
	}
	
	public void draw() {
		StdDraw.picture(pos.x, pos.y, image, dir.deg * (180/Math.PI)); //draws the car
		sensor_left.draw();
		sensor_right.draw();
	}
	
	
}