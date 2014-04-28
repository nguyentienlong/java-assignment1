package mary.assignment;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exercise14_27 {
		
	public static void main(String[] args) {
		// read the input file
		BufferedReader br = null;
		Graph g = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(
					new FileReader(
							"..\\Ass1\\src\\mary\\assignment\\input.txt"));

			g = new Graph();

			ArrayList<Point> listOfPoint = new ArrayList<Point>();
			ArrayList<Point> listOfPointWithConnectedVertexList = new ArrayList<Point>();

			// initial point with name, xAxis, yAxis
			while ((sCurrentLine = br.readLine()) != null) {
				// 0 50 45 1 3 4
				if (sCurrentLine.trim().length() > 1) {
					// convert str to an array
					String[] strArr = sCurrentLine.split(" ");
					String nameOfVertex = strArr[0];
					int xAxis = Integer.parseInt(strArr[1]);
					int yAxis = Integer.parseInt(strArr[2]);
					// create vertex 0 -> n-1
					Point p = new Point(xAxis, yAxis, nameOfVertex);
					listOfPoint.add(p); //each point: x, y, name
				}
			}
			
			// loop through the buffer again to add the connected vertex
			br = new BufferedReader(
					new FileReader(
							"E:\\Sandbox\\PHPDEV\\Ass1\\src\\mary\\assignment\\input.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				// 0 50 45 1 3 4
				if (sCurrentLine.trim().length() > 1) {
					//find the point object					
					String[] strArr = sCurrentLine.split(" ");
					Point p = Point.findPointByName(listOfPoint, strArr[0]);
							
					//find the connected vertex list
					ArrayList<Point> connectedVertexList = new ArrayList<Point>();
					for(int i=3;i<strArr.length;i++){ // length: 5, lastindex 4 <= (length -1) = 5
						Point connectedVertex = Point.findPointByName(listOfPoint, strArr[i]);
						connectedVertexList.add(connectedVertex);
					}
					
					p.setConnectedVertex(connectedVertexList);
					listOfPointWithConnectedVertexList.add(p);
				}
			}
			
			//add to graph
			g.setListofPoint(listOfPointWithConnectedVertexList); // buid the graph data
			
			//Visualize graph g
			SimpleFrame frame = new SimpleFrame(g);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}	
	
}


