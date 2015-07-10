package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

import problems.RecursionAndTreeProblems;
import datastructures.*;

public class RecursionAndTreeTest {

	@Test
	public void BalancedBinaryTreeTest(){
		BinaryTreeNode<Integer> head = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);

		three.setRight(four);

		head.setLeft(one);
		head.setRight(three);

		BinaryTree<Integer> tree = new BinaryTree<Integer>(head);

		assertTrue(tree.isBalanced());

		four.setRight(five);

		assertFalse(tree.isBalanced());

		assertEquals(tree.getHeight(),3);

	}
	@Test
	public void TransverseBinaryTreeTest(){
		BinaryTreeNode<Integer> head = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);

		three.setRight(four);

		head.setLeft(one);
		head.setRight(three);

		four.setRight(five);

		int [] pre = new int[] {2,1,3,4,5};
		int [] in = new int [] {1,2,3,4,5};
		int [] pos = new int[] {1,5,4,3,2};

		ArrayList<Integer> ret = RecursionAndTreeProblems.inOrderTransversal(head);
		for(int i = 0; i < in.length;i++){
			assertEquals((int)ret.get(i),in[i]);
		}
		ret = RecursionAndTreeProblems.preOrderTransversal(head);
		for(int i = 0; i < pre.length;i++){
			assertEquals((int)ret.get(i),pre[i]);
		}

		ret = RecursionAndTreeProblems.postOrderTransversal(head);

		for(int i = 0; i < pos.length;i++){
			assertEquals((int)ret.get(i),pos[i]);
		}
	}
	@Test
	public void LevelOrderTransverseBinaryTreeTest(){
		BinaryTreeNode<Integer> head = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> one = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> three = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> four = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer> five = new BinaryTreeNode<Integer>(5);

		three.setRight(four);

		head.setLeft(one);
		head.setRight(three);

		four.setRight(five);

		ArrayList<ArrayList<Integer>> ret = RecursionAndTreeProblems.levelOrderTransversal(head);
		int [] levelOne = new int[] {2};
		int [] levelTwo = new int[] {1,3};
		int [] levelThree = new int[] {4};
		int [] levelFour = new int [] {5};

		assertEquals(ret.size(),4);

		for(int i = 0; i < levelOne.length; i++){
			assertEquals((int)ret.get(0).get(i),levelOne[i] );
		}
		for(int i = 0; i < levelTwo.length; i++){
			assertEquals((int)ret.get(1).get(i),levelTwo[i] );
		}
		for(int i = 0; i < levelThree.length; i++){
			assertEquals((int)ret.get(2).get(i),levelThree[i] );
		}
		for(int i = 0; i < levelFour.length; i++){
			assertEquals((int)ret.get(3).get(i),levelFour[i] );
		}
	}

	@Test(timeout = 100)
	public void climbLadderTest(){
		assertEquals("Ladder with 3 steps is not ok",3,RecursionAndTreeProblems.climbLadder(3));
		assertEquals("Ladder with 4 steps is not ok",5,RecursionAndTreeProblems.climbLadder(4));
		assertEquals("Ladder with 1000 steps is not ok",new Long(9079565065540428013L),(Long)RecursionAndTreeProblems.climbLadder(1000));
	}

	@Test
	public void createBinarySearchTreeTest(){
		int [] arr = new int [] {1,2,3,4,5,6,7};
		BinaryTree<Integer> tree = RecursionAndTreeProblems.createBinarySearchTree(arr);
		ArrayList<ArrayList<Integer>> ret = RecursionAndTreeProblems.levelOrderTransversal(tree.getHead());
		int [] levelOne = new int[] {4};
		int [] levelTwo = new int[] {2,6};
		int [] levelThree = new int[] {1,3,5,7};

		for(int i = 0; i < levelOne.length; i++){
			assertEquals((int)ret.get(0).get(i),levelOne[i] );
		}
		for(int i = 0; i < levelTwo.length; i++){
			assertEquals((int)ret.get(1).get(i),levelTwo[i] );
		}
		for(int i = 0; i < levelThree.length; i++){
			assertEquals((int)ret.get(2).get(i),levelThree[i] );
		}
	}

	@Test
	public void HanoiTowerTest(){
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		Stack<Integer> s3 = new Stack<>();

		s1.add(4);
		s1.add(3);
		s1.add(2);
		s1.add(1);
		s1.add(0);

		RecursionAndTreeProblems.hanoiTower(s1, s2, s3);

		assertEquals(s3.size(),5);

		for(int i = 0; i < 5;i++){
			assertEquals((int) s3.pop(),i);
		}
	}

	@Test
	public void LevelLinkedListTest(){
		int [] arr = new int [] {1,2,3,4,5,6,7};
		BinaryTree<Integer> tree = RecursionAndTreeProblems.createBinarySearchTree(arr);

		int [] levelOne = new int[] {4};
		int [] levelTwo = new int[] {2,6};
		int [] levelThree = new int[] {1,3,5,7};

		HashMap<Integer,LinkedList<Integer>> map = RecursionAndTreeProblems.getLevelLinkedLists(tree);

			LinkedList<Integer> list = map.get(0);
			for(int i = 0; i< list.size();i++){
				assertEquals(levelOne[i],(int)list.get(i));
			}
			list = map.get(1);
			for(int i = 0; i< list.size();i++){
				assertEquals(levelTwo[i],(int)list.get(i));
			}
			list = map.get(2);
			for(int i = 0; i< list.size();i++){
				assertEquals(levelThree[i],(int)list.get(i));
			}
	}
	@Test
	public void isBSTTest(){
		int [] arr = new int [] {1,2,3,4,5,6,7};
		BinaryTree<Integer> tree = RecursionAndTreeProblems.createBinarySearchTree(arr);
		assertTrue(RecursionAndTreeProblems.isBST(tree));

		arr = new int [] {1,2,3,7,5,6,4};
		tree = RecursionAndTreeProblems.createBinarySearchTree(arr);
		assertFalse(RecursionAndTreeProblems.isBST(tree));		
	}

	@Test
	public void robotMoveTest(){

		assertEquals(RecursionAndTreeProblems.numberOfPaths(0, 0,1 ,1),RecursionAndTreeProblems.robotMove(0, 0, 1, 1));
		assertEquals(RecursionAndTreeProblems.numberOfPaths(0, 0,1 ,2),RecursionAndTreeProblems.robotMove(0, 0, 1, 2));
		assertEquals(RecursionAndTreeProblems.numberOfPaths(0, 0,2 ,2),RecursionAndTreeProblems.robotMove(0, 0, 2, 2));
		assertEquals(RecursionAndTreeProblems.numberOfPaths(0, 0,3 ,4),RecursionAndTreeProblems.robotMove(0,0,3,4));

	}

	@Test
	public void magicIndexTest(){
		int [] arr1 = new int [] {-1,0,2,5,7};
		int [] arr2 = new int [] {1,2,3,4,5};
		int [] arr3 = new int [] {-1,0,3,3,5};

		assertEquals(RecursionAndTreeProblems.magicIndex(arr1), 2);
		assertEquals(RecursionAndTreeProblems.magicIndex(arr2), -1); 
		assertEquals(RecursionAndTreeProblems.magicIndex(arr3), 3);
	}
	@Test
	public void subsetTest(){

		ArrayList<Integer> originalSet = new ArrayList<>();
		originalSet.add(1);
		originalSet.add(2);

		String [] answers = new String [] {"","1 ","1 2 ", "2 "};

		ArrayList<ArrayList<Integer>> subsets = RecursionAndTreeProblems.getSubsets(originalSet);
		int i = 0;
		for(ArrayList<Integer> set: subsets){
			String s = "";
			for(Integer element : set){
				s += element + " ";
			}
			assertEquals(answers[i++], s);
		}
	}
	@Test
	public void allPermutationTest(){
		String s1 = "abc";
		Set<String> set = RecursionAndTreeProblems.allPermutation(s1);
		String [] strs = new String []{"cab","abc","bac","acb"};
		Object [] setToString = set.toArray();
		for(int i = 0 ; i<strs.length;i++){
			assertEquals(strs[i],setToString[i]);
		}
	}
	@Test(timeout = 100)
	public void getChangeTest(){
		assertEquals(RecursionAndTreeProblems.getChange(1),1);
		assertEquals(RecursionAndTreeProblems.getChange(5),2);
		assertEquals(RecursionAndTreeProblems.getChange(10),4);
		RecursionAndTreeProblems.getChange(1000);
	}

}
