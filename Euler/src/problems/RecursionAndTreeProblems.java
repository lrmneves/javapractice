package problems;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import datastructures.*;

public class RecursionAndTreeProblems {

	public static boolean isBalanced(BinaryTree<Integer> tree){
		return tree.isBalanced();
	}

	public static ArrayList<Integer> inOrderTransversal(BinaryTreeNode<Integer> binaryTreeNode){
		if (binaryTreeNode == null) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(binaryTreeNode.getLeft() != null) result.addAll(inOrderTransversal(binaryTreeNode.getLeft()));
		result.add((int)binaryTreeNode.getValue());
		if(binaryTreeNode.getRight() != null) result.addAll(inOrderTransversal(binaryTreeNode.getRight()));

		return result;
	}
	public static ArrayList<Integer> preOrderTransversal(BinaryTreeNode<Integer> head){
		if (head == null) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add((int)head.getValue());
		if(head.getLeft() != null) result.addAll(inOrderTransversal(head.getLeft()));
		if(head.getRight() != null) result.addAll(inOrderTransversal(head.getRight()));

		return result;
	}
	public static ArrayList<Integer> postOrderTransversal(BinaryTreeNode<Integer> head){
		if (head == null) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(head.getLeft() != null) result.addAll(postOrderTransversal(head.getLeft()));

		if(head.getRight() != null) result.addAll(postOrderTransversal(head.getRight()));
		result.add((int)head.getValue());

		return result;
	}
	public static ArrayList<ArrayList<Integer>> levelOrderTransversal(BinaryTreeNode<Integer> head){
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();

		queue.add(head);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> layer = new ArrayList<Integer>();

		int currentLevel = 1;
		int nextLevel = 0;
		int visited = 0;

		BinaryTreeNode<Integer> current;


		while (!queue.isEmpty()){
			current = queue.poll();
			visited++;
			layer.add((int)current.getValue());
			if(current.getLeft() != null){
				nextLevel++;
				queue.add(current.getLeft());
			}
			if(current.getRight() != null){
				nextLevel++;
				queue.add(current.getRight());
			}
			if (visited == currentLevel){
				ret.add(layer);
				layer = new ArrayList<Integer>();
				currentLevel = nextLevel;
				visited = 0;
				nextLevel = 0;
			}

		}

		return ret;

	}
	public static void reverseList(LinkedList<Integer> list){

	}
	public static long  climbLadder(int n){
		return climbLadderAux(n,new long[n+1]);
	}
	public static long climbLadderAux(int n,long[] dynamic) {
		if (n <= 0) return 0;
		if(n <= 2) return n;
		long a = (dynamic[n-1] != 0? dynamic[n-1]:climbLadderAux(n-1,dynamic));
		long b = (dynamic[n-2] != 0? dynamic[n-2]:climbLadderAux(n-2,dynamic));

		dynamic[n] = a+b;

		return dynamic[n];
	}
	public static BinaryTree<Integer> createBinarySearchTree(int [] sortedArr){
		if(sortedArr.length == 0) return null;
		int middle = sortedArr.length/2;
		BinaryTree<Integer> tree = new BinaryTree<>(new BinaryTreeNode<Integer>(sortedArr[middle]));
		//calculate left tree
		createBinaryTreeWorker(tree.getHead(),sortedArr,0,middle-1,false);
		createBinaryTreeWorker(tree.getHead(),sortedArr,middle+1,sortedArr.length-1,true);
		return tree;
	}

	private static void createBinaryTreeWorker(BinaryTreeNode<Integer> node, int [] arr, int start, int end,boolean isRight){
		if( start >end) return;
		int middle = (start + end)/2;
		if (isRight) node.setRight(new BinaryTreeNode<Integer>(arr[middle]));
		else node.setLeft(new BinaryTreeNode<Integer>(arr[middle]));

		createBinaryTreeWorker((isRight?node.getRight():node.getLeft()),arr,start,middle-1,false);
		createBinaryTreeWorker((isRight?node.getRight():node.getLeft()),arr,middle+1,end,true);
	}
	public static void hanoiTower(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3){
		hanoiWorker(s1.size(),s1,s2,s3);
	}
	private static void hanoiWorker(int n, Stack<Integer> beg, Stack<Integer> aux, Stack<Integer> end){
		if(n == 1){
			end.add(beg.pop());
		}
		else{
			hanoiWorker(n-1,beg,end,aux);
			hanoiWorker(1,beg,aux,end);
			hanoiWorker(n-1,aux,beg,end);
		}
	}

	public static HashMap<Integer,LinkedList<Integer>> getLevelLinkedLists(BinaryTree<Integer> tree){

		HashMap<Integer,LinkedList<Integer>> map = new HashMap<>();
		BinaryTreeNode<Integer> head = tree.getHead();
		int level = 0;
		calculateLevelLinkedLists(head,level,map);

		return map;

	}
	private static void calculateLevelLinkedLists(BinaryTreeNode<Integer> node,
			int level, HashMap<Integer, LinkedList<Integer>> map) {

		if(map.containsKey(level)){
			map.get(level).add(node.getValue());
		}
		else{
			map.put(level, new LinkedList<Integer>());
			map.get(level).add(node.getValue());
		}

		if(node.getLeft() != null) calculateLevelLinkedLists(node.getLeft(),level + 1, map);

		if(node.getRight() != null) calculateLevelLinkedLists(node.getRight(), level + 1, map);


	}

	public static boolean isBST(BinaryTree<Integer> tree){
		return isBSTWorker(tree.getHead(),false) > 0? true:false;
	}
	private static int isBSTWorker(BinaryTreeNode<Integer> node,boolean isLeft) {
		if(node.isLeaf()){
			return node.getValue();
		}
		int leftMaxValue;
		int rightMinValue;
		if(node.getLeft() != null){
			leftMaxValue = isBSTWorker(node.getLeft(),true);
			if(node.getValue() <= leftMaxValue || leftMaxValue == -1) return -1;
		}
		else{
			leftMaxValue = node.getValue();
		}
		if(node.getRight() != null){
			rightMinValue = isBSTWorker(node.getRight(),false);
			if(node.getValue()>= rightMinValue || rightMinValue == -1) return -1;
		}
		else{
			rightMinValue = node.getValue();
		}

		if(isLeft) return rightMinValue;
		else return leftMaxValue;

	}
	public static int robotMove(int x0, int y0, int x1, int y1){
		return robotMove(x0,y0,x1,y1,new int[x1+1][y1+1]);
	}
	private static int robotMove(int x0, int y0, int x1, int y1, int[][] visitedArray) {
		if(x0 == x1 && y0 == y1) return 1;

		int right = 0;
		int left = 0;
		if(x0 < x1){
			right = visitedArray[x0+1][y0] != 0? visitedArray[x0+1][y0]:robotMove(x0+1,y0,x1,y1,visitedArray);
		}
		if(y0 < y1){
			left = visitedArray[x0][y0+1] != 0? visitedArray[x0][y0+1]:robotMove(x0,y0+1,x1,y1,visitedArray);
		}
		if(visitedArray[x0][y0] == 0) {
			visitedArray[x0][y0] = left+right;
		}
		return visitedArray[x0][y0];
	}

	public static int numberOfPaths(int x0, int y0, int x1, int y1){
		int xMoves = x1-x0;
		int yMoves = y1-y0;
		int [] computedFact = new int[xMoves + yMoves + 1];
		return factorial(xMoves + yMoves,computedFact)/(factorial(xMoves,computedFact) *factorial(yMoves,computedFact));
	}

	public static int factorial(int n,int[]  arr){
		if (n <= 1) return 1;
		if(arr[n] != 0) return arr[n];

		arr[n] =  n*factorial(n-1,arr);
		return arr[n];
	}
	public static int magicIndex(int[] arr) {
		return magicIndex(arr,0,arr.length-1);
	}
	private static int magicIndex(int[] arr, int start, int end) {
		if(start>end) return -1;

		int index = (end+start)/2;

		if(arr[index] > index){
			int left = magicIndex(arr,start,index-1);
			if (left != -1) return left;
			return magicIndex(arr,index+1,end);

		}
		if(arr[index] < index){
			int right = magicIndex(arr,index+1,end);
			if(right != -1) return right;
			return magicIndex(arr,start,index-1);
		}

		return index;
	}
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> originalSet) {
		ArrayList<ArrayList<Integer>> setOfSets = new ArrayList<>();
		ArrayList<Integer> set = new ArrayList<>();
		setOfSets.add(set);
		getSubsetsWorker(set,originalSet,setOfSets,0);
		return setOfSets;
	}
	private static void getSubsetsWorker(ArrayList<Integer> set,
			ArrayList<Integer> originalSet, ArrayList<ArrayList<Integer>> setOfSets, int lastStored) {

		for(int i = lastStored; i < originalSet.size(); i++){
			ArrayList<Integer> newSet = new ArrayList<>();
			newSet.addAll(0, set);
			newSet.add(originalSet.get(i));
			setOfSets.add(newSet);
			getSubsetsWorker(newSet,originalSet,setOfSets,i+1);
		}
	}
	
	public static Set<String> allPermutation(String str) {
		if(str == null) return null;
		
		HashSet<String> set = new HashSet<String>();
		if(str.equals("")){
			set.add("");
			return set;
		}
		for(int i = 0; i < str.length(); i++){
			String permString = removeCharAt(str,i);
			for(int j = 0; j< permString.length();j++){
				set.add(insertCharAt(permString,str.charAt(i),j));
			}
		}
		return set;
	}

	public static String removeCharAt(String str,int index){
		return str.substring(0,index) + str.substring(index+1);
	}
	public static String insertCharAt(String str,char ch, int index){
		return str.substring(0,index) + ch + str.substring(index);
	}


	public static int getChange(int n){
		return getChange(n,new int[]{25,10,5,1},0,new int[4][n+1]);
	}

	private static int getChange(int n, int[] coins, int index, int[][] seenArr) {

		if(seenArr[index][n] > 0) return seenArr[index][n];

		if(index>= coins.length-1) return 1;
		int coin = coins[index];
		int ways = 0;

		for(int i = 0; i*coin <= n;i++){
			int remaining = n - i*coin;
			ways += getChange(remaining,coins,index+1,seenArr);
		}
		seenArr[index][n] = ways;
		return seenArr[index][n];
	}
	public static ArrayList<Integer[]> calculateQueens(int gridSize){
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		calculateQueens(gridSize,0, new Integer [gridSize],result);	
		return result;
		
	}

	private static void calculateQueens(int gridSize, int row,
			Integer[] columns, ArrayList<Integer[]> result) {
		
		if(row == gridSize){
			result.add((Integer[])columns.clone());
		}else{
			for(int col = 0; col < gridSize; col++){
				if(checkValid(row,col,columns)){
					columns[row] = col;
					calculateQueens(gridSize,row+1,columns,result);
				}
			}
		}
	}

	private static boolean checkValid(int row1, int col1, Integer[] columns) {
		
		for(int row2 = 0; row2 < row1;row2++){
			int col2 = columns[row2];
			if(col1 == col2) return false;
			
			int colDistance = Math.abs(col2 - col1);
			
			int rowDistance = row1 - row2;
			
			if (colDistance == rowDistance) return false;
			
		}
		
		return true;
	}
	
	
//	public static List<int[]> getSkyline(int [][] buildings){
//		ArrayList<SkylineNode> nodeList = new ArrayList<>();
//		for(int [] building : buildings){
//			nodeList.add(new SkylineNode(building[0],building[1],building[2]));
//		}
//		Collections.sort(nodeList);
//		SkylineNode head = nodeList.get(0);
//		SkylineNode current = head;
//		SkylineNode newNode;
//		boolean stored;
//		for(int i = 1; i < nodeList.size();i++){
//			newNode = nodeList.get(i);
//			stored = false;
//			while(!stored){
//				if(newNode.getX0() > current.getX1()){
//					if(current.getRight() == null){
//						current.setRight(newNode);
//						stored = true;
//					}else{
//						current = current.getRight();
//					}
//				}else if(newNode.getX1() < current.getX0()){
//					if(current.getLeft() == null){
//						current.setLeft(newNode);
//						stored = true;
//					}else{
//						current = current.getLeft();
//					}
//				}else if(newNode.getX1() > current.getX1())
//			}
//		}
//		return new ArrayList<int[]>();
//	}
	

}
