package mary.assignment;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleFrame extends JFrame {
	//graph class from input file
	Graph graph;
	
	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public SimpleFrame(Graph graph) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		int screenWidth = d.width;
		int screenHeight = d.height;
		// set frame size
		this.setSize(screenWidth / 2, screenHeight / 2);
		// create panel
		GraphView p = new GraphView();
		p.setGraph(graph);
		// add panel
		this.add(p);
		this.setTitle("Exercise14_27");
	}
}

class GraphView extends JPanel {
	private Graph graph;
	
	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int varianceX=10;
		int varianceY=10;
		ArrayList<Point> listOfPointWithConnectedVertexList = this.graph.getListofPoint();
		for (Point point : listOfPointWithConnectedVertexList) {
			//1. draw oval, string 1
			//2. draw oval, string 2
			//3. draw line 1--> 2
			g.fillOval(point.getX(),point.getY(), varianceX, varianceY);
			g.drawString(point.getNameOfPoint(), point.getX()-varianceX, point.getY());
			ArrayList<Point> connectedVertex = point.getConnectedVertex();
			for(Point targerPoint: connectedVertex){
				g.fillOval(targerPoint.getX(), targerPoint.getY(), varianceX, varianceY);
				g.drawString(targerPoint.getNameOfPoint(), targerPoint.getX()-varianceX, targerPoint.getY());
				g.drawLine(point.getX()+varianceX/2, point.getY()+varianceX/2, targerPoint.getX()+varianceX/2, targerPoint.getY()+varianceY/2);
			}
		}
	}
}