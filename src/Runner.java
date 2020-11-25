package src;

import java.awt.Font;

public class Runner {
	
	public void run() {
		
		Gui gui = new Gui();
		Vehicle1 car1 = new Vehicle1(50, 50, "./Images/car1.png", (float)(90 * (Math.PI/180)));
		Vehicle2a car2a = new Vehicle2a(25, 25, "./Images/car2a.png", (float)(90 * (Math.PI/180)));
		Vehicle2b car2b = new Vehicle2b(75, 75, "./Images/car2b.png", (float)(90 * (Math.PI/180)));
		Vehicle3 car3 = new Vehicle3(30, 30, "./Images/car3.png", (float) (90 * (Math.PI/180)));
		src.Sun sun = new Sun("./Images/SUN.png", 0);

			while(gui.getS() == false) {
				System.out.println("running");
				if(gui.getS() == true) {
					Font font = new Font("San Serif", Font.BOLD, 110);
			        StdDraw.setFont(font);
					StdDraw.text(50, 50, "3");
					StdDraw.show(); StdDraw.pause(700); StdDraw.clear();
					StdDraw.text(50, 50, "2");
					StdDraw.show(); StdDraw.pause(700); StdDraw.clear();
					StdDraw.text(50, 50, "1");
					StdDraw.show(); StdDraw.pause(700); StdDraw.clear();
					StdDraw.text(50, 50, "GOOOO!");
					StdDraw.show(); StdDraw.pause(700);
				}
			}
			
		while (gui.getS() == true) {
			do{
			StdDraw.clear();
			float mouseX = (float)StdDraw.mouseX();
			float mouseY = (float)StdDraw.mouseY();
			if(gui.moveSun == true) {
				sun.pos.updateComponents(mouseX, mouseY);

			}
			car1.draw();
			car2a.draw();
			car2b.draw();
			car3.draw();
			sun.draw();
			car1.update(sun);
			car2a.update(sun);
			car2b.update(sun);
			car3.update(sun);
			StdDraw.show();
			StdDraw.pause(15);
			} while (gui.getP() == false);
			while(gui.getS() == false) {
				StdDraw.text(50, 50, "Paused");
				StdDraw.show();
				if(gui.getS() == true) {
					break;
				}
			}
		}
	}
}	