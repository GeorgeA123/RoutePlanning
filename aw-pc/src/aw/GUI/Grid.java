package aw.GUI;

import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import aw.routePlanning.AStar;
import aw.test.Node;
import rp.robotics.mapping.GridMap;
import rp.robotics.mapping.MapUtils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;

public class Grid extends JPanel{
	private ArrayList<Line2D.Double> xLines;
	private ArrayList<Line2D.Double> yLines; 
	

	private int robotWidth = 30;
	private int robotHeight = 30;
	private int robot1CenterX = 50;
	private int robot1CenterY = 100;
	private int robot2CenterX = 600;
	private int robot2CenterY = 100;
	private int robot3CenterX = 50;
	private int robot3CenterY = 400;
	private int height,width, xSize, ySize, robot1X, robot1Y, robot2X, robot2Y, robot3X, robot3Y, xConvert, yConvert;
	private GridMap grid;
	
	private ArrayList<Node> route1;
	private ArrayList<Node> route2;
	private ArrayList<Node> route3;
	
	public Grid() {
		super();
		this.grid = MapUtils.createRealWarehouse(); 
		this.xSize = grid.getXSize();
		this.ySize = grid.getYSize();
		this.height = 800;
		this.width = 800;
		route1 = new ArrayList<Node>();
		route2 = new ArrayList<Node>();
		route3 = new ArrayList<Node>();
		
		
		//Square just goes around the perimeter of the grid for the moment
		//Just tester code for the moment.
		robot1X = robot1CenterX - (robotWidth /2);
		robot1Y = robot1CenterY - (robotHeight/2);
		ActionListener movingRec = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(recCenterY == 100 && recCenterX >= 50 && recCenterX < 50 * xSize) {
//					recCenterX++;
//					recX = recCenterX - (recWidth /2);
//					recY = recCenterY - (recHeight/2);
//					
//					repaint();
//				}
//				else if (recCenterX == 600 && recCenterY >= 100 && recCenterY < 450) {
//					recCenterY++;
//					recX = recCenterX - (recWidth /2);
//					recY = recCenterY - (recHeight/2);
//					repaint();
//				}
//				else if(recCenterY == 450 && recCenterX <= 600 && recCenterX > 50) {
//					recCenterX--;
//					recX = recCenterX - (recWidth /2);
//					recY = recCenterY - (recHeight/2);
//					repaint();
//				}
//				else if(recCenterX == 50 && recCenterY<= 450 && recCenterY > 100){
//					recCenterY--;
//					recX = recCenterX - (recWidth /2);
//					recY = recCenterY - (recHeight/2);
//					repaint();
//				}
				
				//Draws the location of the first robot along its given route
				if(!route1.isEmpty()){
					Node nextCoord = route1.get(0);
					if(robot1CenterX < nextCoord.x*50 + 50){
						robot1CenterX++;
						robot1X = robot1CenterX - (robotWidth /2);
						robot1Y = robot1CenterY - (robotHeight/2);
						
						repaint();
					}
					else if(robot1CenterX > nextCoord.x*50 + 50){
						robot1CenterX--;
						robot1X = robot1CenterX - (robotWidth /2);
						robot1Y = robot1CenterY - (robotHeight/2);
						
						repaint();
					}
					else if(robot1CenterY < nextCoord.y*50 + 100){
						robot1CenterY++;
						robot1X = robot1CenterX - (robotWidth /2);
						robot1Y = robot1CenterY - (robotHeight/2);
						
						repaint();
					}
					else if(robot1CenterY > nextCoord.y*50 + 100){
						robot1CenterY--;
						robot1X = robot1CenterX - (robotWidth /2);
						robot1Y = robot1CenterY - (robotHeight/2);
						
						repaint();
					}
					//Removes nodes of the route that the robot has passed
					if((int)route1.get(0).x*50 + 50 == robot1CenterX && (int)route1.get(0).y*50 + 100 == robot1CenterY){
						route1.remove(0);
					}
				}
				
				//Draws the location of the second robot along its given route
				if(!route2.isEmpty()){
					Node nextCoord = route2.get(0);
					if(robot2CenterX < nextCoord.x*50 + 50){
						robot2CenterX++;
						robot2X = robot2CenterX - (robotWidth /2);
						robot2Y = robot2CenterY - (robotHeight/2);
						
						repaint();
					}
					else if(robot2CenterX > nextCoord.x*50 + 50){
						robot2CenterX--;
						robot2X = robot2CenterX - (robotWidth /2);
						robot2Y = robot2CenterY - (robotHeight/2);
						
						repaint();
					}
					else if(robot2CenterY < nextCoord.y*50 + 100){
						robot2CenterY++;
						robot2X = robot2CenterX - (robotWidth /2);
						robot2Y = robot2CenterY - (robotHeight/2);
						
						repaint();
					}
					else if(robot2CenterY > nextCoord.y*50 + 100){
						robot2CenterY--;
						robot2X = robot2CenterX - (robotWidth /2);
						robot2Y = robot2CenterY - (robotHeight/2);
						
						repaint();
					}
					//Removes nodes of the route that the robot has passed
					if((int)route2.get(0).x*50 + 50 == robot2CenterX && (int)route2.get(0).y*50 + 100 == robot2CenterY){
						route2.remove(0);
					}
				}
				
				//Draws the location of the third robot along its given route
				if(!route3.isEmpty()){
					Node nextCoord = route3.get(0);
					if(robot3CenterX < nextCoord.x*50 + 50){
						robot3CenterX++;
						robot3X = robot3CenterX - (robotWidth /2);
						robot3Y = robot3CenterY - (robotHeight/2);
						
						repaint();
					}
					else if(robot3CenterX > nextCoord.x*50 + 50){
						robot3CenterX--;
						robot3X = robot3CenterX - (robotWidth /2);
						robot3Y = robot3CenterY - (robotHeight/2);
						
						repaint();
					}
					else if(robot3CenterY < nextCoord.y*50 + 100){
						robot3CenterY++;
						robot3X = robot3CenterX - (robotWidth /2);
						robot3Y = robot3CenterY - (robotHeight/2);
						
						repaint();
					}
					else if(robot3CenterY > nextCoord.y*50 + 100){
						robot3CenterY--;
						robot3X = robot3CenterX - (robotWidth /2);
						robot3Y = robot3CenterY - (robotHeight/2);
						
						repaint();
					}
					//Removes nodes of the route that the robot has passed
					if((int)route3.get(0).x*50 + 50 == robot3CenterX && (int)route3.get(0).y*50 + 100 == robot3CenterY){
						route3.remove(0);
					}
				}
			}
		};
		//Updates the position of the red square every 20 milliseconds.		
		Timer timer = new Timer(20, movingRec);
		
		timer.start();
	}
	
	private void drawRoute(ArrayList<Node> route, int robotCenterX, int robotCenterY, Graphics2D g2, Color color){
		g2.setStroke(new BasicStroke(8));
		g2.setColor(color);
		g2.drawLine(robotCenterX, robotCenterY, (int)(50 + route.get(0).x*50), (int)(100 + route.get(0).y*50));
		for(int i = 0; i < route.size() - 1; i++){
			g2.drawLine((int)(50 + route.get(i).x*50), (int)(100 + route.get(i).y*50), (int)(50 + route.get(i+1).x*50), (int)(100 + route.get(i+1).y*50));
		}
		g2.drawOval((int)(50 + route.get(route.size() - 1).x*50) - 5, (int)(95 + route.get(route.size() - 1).y*50), 10, 10);
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		for(int i = 0; i < ySize; i++) {
			g2.drawLine(50, (i *50) + 100,  50 * xSize, (i*50) + 100);
		}
		for(int i = 0; i < xSize; i++) {
			g2.drawLine(50 + (i*50), 100, 50 + (i*50), 50* ySize + 50);
		}
		
		for(int i = 0; i < xSize; i++){
			for(int j = 0; j < ySize; j++){
				if(grid.isObstructed(i, j)){
					g2.setColor(Color.BLACK);
					g2.fillRect(25 + i * 50, 125 + j * 50, 50, 50);
				}
			}
		}
		
		//Drawing route of the robot
		if(!route1.isEmpty()){
			drawRoute(route1, robot1CenterX, robot1CenterY, g2, Color.RED);
		}
		if(!route2.isEmpty()){
			drawRoute(route2, robot2CenterX, robot2CenterY, g2, Color.BLUE);
		}
		if(!route3.isEmpty()){
			drawRoute(route3, robot3CenterX, robot3CenterY, g2, Color.GREEN);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		//makes the square moving a lot smoother.
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		draw(g2);
		float thickness = 5;
		Stroke oldStroke = g2.getStroke();
		g2.setStroke(new BasicStroke(thickness));
		
		g2.setColor(Color.RED);
		g2.drawRect(robot1X, robot1Y, robotWidth, robotHeight);
		
		g2.setColor(Color.BLUE);
		g2.drawRect(robot2X, robot2Y, robotWidth, robotHeight);
		
		g2.setColor(Color.GREEN);
		g2.drawRect(robot3X, robot3Y, robotWidth, robotHeight);
	}
	
	//Sets the routes of the different robots to a locally stored variable
	public void setRoute(ArrayList<Node> route, String robot){
		if(robot.equals("Ricardo")){
			route1 = route;
			robot1CenterX = (int)route1.get(0).x*50 + 50;
			robot1CenterY = (int)route1.get(0).y*50 + 100;
			route1.remove(0);
			
		}
		else if(robot.equals("NXT")){
			route2 = route;
			robot2CenterX = (int)route2.get(0).x*50 + 50;
			robot2CenterY = (int)route2.get(0).y*50 + 100;
			route2.remove(0);
		}
		else if(robot.equals("TheOtherRobot")){
			route3 = route;
			robot3CenterX = (int)route3.get(0).x*50 + 50;
			robot3CenterY = (int)route3.get(0).y*50 + 100;
			route3.remove(0);
		}
	}
}
	
