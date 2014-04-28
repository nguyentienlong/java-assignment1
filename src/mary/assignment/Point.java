package mary.assignment;

import java.util.ArrayList;

public class Point {
	//declare the attribute or properties
	private int x; 
	private int y;
	private String nameOfPoint;
	private ArrayList<Point> connectedVertex;
	
	public Point(int x, int y, String nameOfPoint){
		this.x = x;
		this.y = y;
		this.nameOfPoint = nameOfPoint;
	}
	
	public int getX(){
		return this.x;		
	}
	
	public void setX(int x){
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ArrayList<Point> getConnectedVertex() {
		return connectedVertex;
	}

	public void setConnectedVertex(ArrayList<Point> connectedVertex) {
		this.connectedVertex = connectedVertex;
	}

	public String getNameOfPoint() {
		return nameOfPoint;
	}

	public void setNameOfPoint(String nameOfPoint) {
		this.nameOfPoint = nameOfPoint;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", nameOfPoint=" + nameOfPoint
				+ ", connectedVertex=" + connectedVertex.size() + "]";
	}
	
	/*
	 * given a name of the point
	 *
	 * return point with x,y,name of the point, (even if we can return connected vertex)
	 */
	public static Point findPointByName(ArrayList<Point> collection, String name){
		for (Point point : collection) {
			if(point.getNameOfPoint().equalsIgnoreCase(name)){
				return point;
			}
		}
		return null;		
	}
	
}


