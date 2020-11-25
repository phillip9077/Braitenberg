package src;

public class GameObject {
	public Point pos;
	String image;
	Vector dir;


	public GameObject(String s) {
		this.pos = new Point(0, 0);
		image = s;
		dir = new Vector(pos.x , pos.y);
	}	

	public GameObject(float x, float y, String s, float deg){
		this.pos = new Point(x, y);
		image = s;	
		dir = new Vector(deg);
	}

	public void draw() {
		StdDraw.picture(pos.x, pos.y, image, dir.deg * (180/Math.PI));
	}

	public void update() {}

	public void update(Sun other) {}
	
	public void update(GameObject other) {}
	
	public void resetPos() {
		if(pos.x > 110){
			pos.x = -10;
		}
		if(pos.x < -10){
			pos.x = 110;
		}
		if(pos.y > 110){
			pos.y = -10;
		}
		if(pos.y < -10){
			pos.y = 110;
		}
	}

}
