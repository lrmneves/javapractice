package datastructures;

import java.util.LinkedList;

public class GraphNode<T> {

	private LinkedList<GraphNode<T>> neighbours; 
	private T value;
	private boolean wasVisited;
	
	public GraphNode(T value){
		this.neighbours =  new LinkedList<>();
		this.setValue(value);
		this.wasVisited = false;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public LinkedList<GraphNode<T>> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(LinkedList<GraphNode<T>> neighbours) {
		this.neighbours = neighbours;
	}
	public void addNeighbour(GraphNode<T> node){
		this.neighbours.add(node);
	}
	public void removeNeighbour(GraphNode<T> node){
		this.neighbours.remove(node);
	}

	public boolean wasVisited() {
		return wasVisited;
	}

	public void markVisited() {
		this.wasVisited = true;
	}
	public void setUnvisited(){
		this.wasVisited = false;
	}
	
}
