package test;

import static org.junit.Assert.*;

import org.junit.Test;

import problems.CodeEvalChallenge;
import problems.RecursionAndTreeProblems;
import datastructures.BST;
import datastructures.BinaryTreeNode;
import datastructures.Graph;
import datastructures.GraphNode;
import datastructures.MyHeap;

public class OtherTest {

	public static Graph<Integer> createTestGraph(){
		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(1,2);
		graph.addEdge(1,3);

		graph.addEdge(2,3);
		graph.addEdge(2,5);

		graph.addEdge(3,3);

		graph.addEdge(4,1);
		graph.addEdge(4,2);
		graph.addEdge(4,5);

		graph.addEdge(5,3);

		return graph;

	}

	@Test
	public void getLastDigitTest(){
		assertEquals(7,CodeEvalChallenge.getLastDigit(7));
		assertEquals(9,CodeEvalChallenge.getLastDigit(7*7));
		assertEquals(3,CodeEvalChallenge.getLastDigit(7*7*7));
		assertEquals(1, CodeEvalChallenge.getLastDigit(7*7*7*7));
	}

	@Test
	public void bstTest(){
		BST<Integer> bst = new BST<>(new BinaryTreeNode<Integer>(4));
		int [] arr = new int [] {1,2,3,5,6,7};
		for(int i: arr){
			bst.insertNode(i);
		}
		assertTrue(RecursionAndTreeProblems.isBST(bst));
		assertTrue(RecursionAndTreeProblems.isBalanced(bst));

	}
	@Test
	public void graphTest(){
		Graph<Integer> graph = createTestGraph();
		int [] dfsRet =  new int [] {5,3,2,1};
		int i = 0;
		for(GraphNode<Integer> n : graph.dfs(4)){
			assertEquals(dfsRet[i],(int) n.getValue());
			i++;
		}
		assertEquals(graph.dfs(3).size(),0);
		assertEquals((int)graph.dfs(5).getFirst().getValue(),3);

		int [] bfsRet = new int []{1,2,5,3};
		i = 0;
		for(GraphNode<Integer> n : graph.bfs(4)){
			assertEquals(bfsRet[i],(int) n.getValue());
			i++;
		}
	}

	@Test
	public void testHeap(){
		MyHeap minHeap = new MyHeap(10,true);
		MyHeap maxHeap = new MyHeap(10,false);

		for(int i = 0; i < 10;i++){
			minHeap.insert(i);
			maxHeap.insert(i);
		}

		for(int i = 0; i < 10;i++){

			assertEquals(minHeap.extract(),i);
		}
		for(int i = 9; i>=0; i--){
			assertEquals(maxHeap.extract(),i);
		}
	}
}
