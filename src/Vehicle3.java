package src;


public class Vehicle3 extends src.GameObject {
	Sensor sensor_left = null;
	Sensor sensor_right = null;
	
	public Vehicle3(String s) {
		super(s);
		sensor_left = new Sensor(50, 50, 6, 2, "./Images/dot.png", 0);
		sensor_right = new Sensor(50, 50, 6, -2, "./Images/dot.png", 0);
	}
	
	public Vehicle3(float x, float y, String s, float deg) {
		super(x,y,s,deg);
		sensor_left = new Sensor(x, y, 6, 2, "./Images/dot.png", deg);
		sensor_right = new Sensor(x, y, 6, -2, "./Images/dot.png", deg);
	}
	
	@Override
	public void update(Sun other) {
		float rotConstant = 30f;
		float velConstant = 20f;
		
		float rotIntensity = sensor_left.getIntensity1(other.pos) - sensor_right.getIntensity1(other.pos);
		float velIntensity = sensor_left.getIntensity2(other.pos) + sensor_right.getIntensity2(other.pos);
		
		if(rotIntensity > 60) {
			rotIntensity = 60;
		}
		if(velIntensity < 0.5f) {
			rotIntensity = 0;
		}
		
		float deltaTheta = (float) (5 * rotConstant * rotIntensity);
		this.dir.rotateVec(deltaTheta);
		sensor_left.offset.rotateVec(deltaTheta);
		sensor_right.offset.rotateVec(deltaTheta);

		Vector lol = new Vector(this.dir.deg);
		Vector temp = lol.mult(0.01f * velConstant * velIntensity);
		
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
