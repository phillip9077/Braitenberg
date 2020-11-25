package src;

public class Vehicle1 extends GameObject
{
	Sensor sensor = null;
	
	public Vehicle1(String s) {
		super(s);
		sensor = new Sensor(50, 50, 6, 0, "./Images/dot.png", 0);
	}
	
	public Vehicle1(float x, float y, String s, float deg){
		super(x,y,s,deg);
		sensor = new Sensor(x, y, 6, 0, "./Images/dot.png", deg);
	}
	
	@Override
	public void update(Sun other) {
		Vector lol = new Vector(this.dir.deg);
		Vector temp = lol.mult(10 * sensor.getIntensity1(other.pos));
		pos.addVec(this.dir); //base speed
		pos.addVec(temp); //moves the car
		//sensor.pos.updateComponents(this.pos.x, this.pos.y + 10);
		sensor.update(this);
		resetPos();
	}

	public void draw() {
		StdDraw.picture(pos.x, pos.y, image, dir.deg * (180/Math.PI)); //draws the car
		sensor.draw();
	}
}