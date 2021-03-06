package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		int a = Integer.parseInt(JOptionPane.showInputDialog("How many robots do you want?"));
		String c = JOptionPane.showInputDialog("What color do you want? (GREEN, BLUE, RED)");
		int s = Integer.parseInt(JOptionPane.showInputDialog("How many sides do you want?"));
		int angle = 180-((s-2)*180/s);
		for(int i = 0; i < a; i++) {
			int copy = i;
			new Thread(()->{
			Robot r = new Robot("mini");
			r.penDown();
			switch(c) {
			case "GREEN":
				r.setPenColor(Color.GREEN);
				break;
			case "BLUE":
				r.setPenColor(Color.BLUE);
				break;
			case "RED":
				r.setPenColor(Color.RED);
				break;
			}
			r.setSpeed(100);
			r.setX(1000/a*(copy));
			r.setY(500);
			for(int j = 0; j < s; j++) {
				r.move(20);
				r.turn(angle);
			}
			r.hide();
			}).start();;
		}
		}
}
