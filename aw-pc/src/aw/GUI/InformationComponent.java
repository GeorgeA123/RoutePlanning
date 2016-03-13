package aw.GUI;


import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import aw.test.Node;


public class InformationComponent extends JPanel{
	private Grid grid;
	private InformationView view;
	private InformationModel model;
	
	public InformationComponent(InformationModel model) {
		super();
		grid = new Grid();
		this.model = model;
		view = new InformationView(model);
		
		setLayout(new GridLayout(0, 2));
		model.addObserver(view);
		add(grid);
		add(view);
		
	}
	
	public void setRoute(ArrayList<Node> route, String name){
		grid.setRoute(route, name);
	}
}
