package src;

public class BraitenbergApp {

	public static void main(String[] args) {
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0,100);
		StdDraw.setYscale(0, 100);
		StdDraw.enableDoubleBuffering();		
		
		Runner runner = new Runner();
		runner.run();
	}	
}