package utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph<T> {
	
	HashMap<T,GraphNode<T>> nodeMap;
	boolean isDirected;
	
	public Graph(){
		this(false);
	}
	public Graph(boolean isDirected){
		nodeMap = new HashMap<>();
		this.isDirected = isDirected;
	}
	
	public void addNode(T nodeValue){
		if(!nodeMap.containsKey(nodeValue)){
			nodeMap.put(nodeValue,new GraphNode<T>(nodeValue));
		}
	}
	
	public void addEdge(T n1, T n2){
		if(!nodeMap.containsKey(n1)) addNode(n1);
		if(!nodeMap.containsKey(n2)) addNode(n2);
		
		nodeMap.get(n1).addNeighbour(nodeMap.get(n2));
		if(!isDirected) nodeMap.get(n2).addNeighbour(nodeMap.get(n1));


	}
	public void setAllUnvisited(){
		for(GraphNode<T> node : nodeMap.values()){
			node.setUnvisited();
		}
	}
	public LinkedList<GraphNode<T>> dfs(T nodeValue){
		GraphNode<T> node = nodeMap.get(nodeValue);
		LinkedList<GraphNode<T>> visitedNodes = new LinkedList<>();
		Stack<GraphNode<T>> dfsStack = new Stack<>();
		setAllUnvisited();
		
		dfsStack.add(node);
		
		while(!dfsStack.isEmpty()){
			node = dfsStack.pop();
			if(!node.wasVisited()){
				node.markVisited();
				if(!node.getValue().equals(nodeValue)) visitedNodes.add(node);
				
				for(GraphNode<T> n : node.getNeighbours()){
					if(!n.wasVisited()) dfsStack.push(n);
				}
			}
		}
		return visitedNodes;
	}
	
	public LinkedList<GraphNode<T>> bfs(T nodeValue){
		
		GraphNode<T> node = nodeMap.get(nodeValue);
		LinkedList<GraphNode<T>> visitedNodes = new LinkedList<>();
		Queue<GraphNode<T>> bfsQueue = new LinkedList<>();
		setAllUnvisited();
		
		bfsQueue.add(node);
		
		while(!bfsQueue.isEmpty()){
			
			node = bfsQueue.poll();
			if(!node.wasVisited()){
				node.markVisited();
				if(!node.getValue().equals(nodeValue)) visitedNodes.add(node);
				
				for(GraphNode<T> n : node.getNeighbours()){
					if(!n.wasVisited()) bfsQueue.add(n);
				}
			}
		}
		return visitedNodes;
		
	}
}
