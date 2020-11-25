package src;

public class Vector extends Point
{
	float deg = 0.0f;

	public Vector (float x, float y) {
		super(x, y);
		this.deg = (float) Math.atan(y/x);
	}

	public Vector (float dir){
		super((float)Math.cos(dir), (float)Math.sin(dir));
		this.deg = dir;
	}
	
	public Vector mult(float intensity) {
		return new Vector(this.x * intensity, this.y * intensity);
	}

	public void rotateVec(float theta) {
		float xx = this.x;
		float yy = this.y;
		this.x = (float) (xx*Math.cos(theta) - yy*Math.sin(theta));
		this.y = (float) (yy*Math.cos(theta) + xx*Math.sin(theta));
		deg += theta;
	}

}