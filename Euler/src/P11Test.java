import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import utils.*;

import org.junit.Test;


public class P11Test {

	@Test
	public void twoSumTest() {
		int [] arr = new int []{2,7,11,15};
		int value = 9;
		int [] ret = P11.twoSum(arr,value);

		assertEquals(ret[0],0);
		assertEquals(ret[1],1);

		value = 13;
		ret = P11.twoSum(arr,value);

		assertEquals(ret[0],0);
		assertEquals(ret[1],2);
	}

	@Test
	public void threeSumTest(){
		int [] arr = new int []{-1,0,1,2,-1,-4};
		int value = -6;
		int sum;

		ArrayList<Integer[]> ret = P11.tripleSum(arr,value);
		assertEquals(ret.size(),1);

		for(Integer[] tuple : ret){
			sum = 0;
			for(Integer i : tuple){
				sum+= i;
			}
			assertEquals(sum,value);
		}

		value = 0;
		ret = P11.tripleSum(arr,value);
		assertEquals(ret.size(),2);

		for(Integer[] tuple : ret){
			sum = 0;
			for(Integer i : tuple){
				sum+= i;
			}
			assertEquals(sum,value);
		}



	}
	@Test
	public void closesThreeSumTest(){
		int [] arr = new int []{-1,2,1,-4};
		int value = 1;
		int sum = P11.closestTripleSum(arr, value);
		assertEquals(sum, 2);
	}

	@Test
	public void sumBinaryTest(){
		//		String b1 = "110";
		//		String b2 = "00";

		//		String ret = P11.sumBinary(b1, b2);

		//		assertTrue(ret.equals("110"));
	}

	@Test
	public void sumTwoNumbersTest(){
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();

		l1.add(2);l1.add(4);l1.add(3);
		l2.add(5);l2.add(6);l2.add(4);
		LinkedList<Integer> ret = P11.addTwoNumbers(l1, l2);

		assertEquals(ret.poll(), new Integer(7));
		assertEquals(ret.poll(), new Integer(0));
		assertEquals(ret.poll(), new Integer(8));

	}

	@Test
	public void anagramList(){
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("listen");
		strings.add("silent");
		strings.add("egg");
		strings.add("solve");
		strings.add("loves");

		ArrayList<ArrayList<String>> ret = P11.findAnagrams(strings);
		assertEquals(ret.size(),2);
		assertEquals(ret.get(0).size(),2);		
	}

	@Test
	public void bestStockTest(){
		int [] arr = new int[] {5,7,4,2,5,9,8,1};
		int max = P11.bestStock(arr);
		assertEquals(max,7);
	}
	@Test
	public void bestStockTest2(){
		int [] arr = new int[] {5,7,4,2,5,9,8,1};
		int max = P11.bestStock2(arr);
		assertEquals(max,9);
	}
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

		ArrayList<Integer> ret = P11.inOrderTransversal(head);
		for(int i = 0; i < in.length;i++){
			assertEquals((int)ret.get(i),in[i]);
		}
		ret = P11.preOrderTransversal(head);
		for(int i = 0; i < pre.length;i++){
			assertEquals((int)ret.get(i),pre[i]);
		}

		ret = P11.postOrderTransversal(head);

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

		ArrayList<ArrayList<Integer>> ret = P11.levelOrderTransversal(head);
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
	@Test
	public void reverseListTest(){
		LinkedListNode<Integer> first = new LinkedListNode<Integer>(0);
		LinkedListNode<Integer> second = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> third = new LinkedListNode<Integer>(2);
		LinkedListNode<Integer> fourth = new LinkedListNode<Integer>(3);

		MyLinkedList<Integer> list = new MyLinkedList<Integer>(first);
		list.appendNode(second);
		list.appendNode(third);
		list.appendNode(fourth);
		LinkedListNode<Integer> current = first;

		for(int i = 0; i < list.getSize();i++){
			assertEquals(i,(int)current.getValue());
			current = current.getNext();
		}
		list.reverseList();
		current = list.getHead();

		for(int i = list.getSize() -1; i >=0;i--){
			assertEquals(i,(int)current.getValue());
			current = current.getNext();
		}

	}
	@Test
	public void mergeListTest(){

		LinkedListNode<Integer> first = new LinkedListNode<Integer>(0);
		LinkedListNode<Integer> second = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> third = new LinkedListNode<Integer>(2);
		LinkedListNode<Integer> fourth = new LinkedListNode<Integer>(3);
		LinkedListNode<Integer> fifth = new LinkedListNode<Integer>(4);


		MyLinkedList<Integer> list1 = new MyLinkedList<Integer>(first);
		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>(second);

		list1.appendNode(third);
		list2.appendNode(fourth);
		list2.appendNode(fifth);

		LinkedListNode<Integer> current; 
		list1.mergeTo(list2);
		current = list1.getHead();

		for(int i = 0; i < list1.getSize();i++){
			assertEquals(i,(int)current.getValue());
			current = current.getNext();
		}



	}
	@Test
	public void hasCycleTest(){
		LinkedListNode<Integer> first = new LinkedListNode<Integer>(0);
		LinkedListNode<Integer> second = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> third = new LinkedListNode<Integer>(2);
		LinkedListNode<Integer> fourth = new LinkedListNode<Integer>(3);

		MyLinkedList<Integer> list = new MyLinkedList<Integer>(first);
		list.appendNode(second);
		list.appendNode(third);
		list.appendNode(fourth);

		assertEquals(null,list.hasCycle());
		fourth.setNext(second);
		assertSame(fourth,list.hasCycle());

	}

	@Test
	public void calculateMedian(){
		LinkedListNode<Integer> first = new LinkedListNode<Integer>(0);
		LinkedListNode<Integer> second = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> third = new LinkedListNode<Integer>(2);
		LinkedListNode<Integer> fourth = new LinkedListNode<Integer>(3);
		LinkedListNode<Integer> fifth = new LinkedListNode<Integer>(4);
		LinkedListNode<Integer> sixth = new LinkedListNode<Integer>(5);

		MyLinkedList<Integer> list = new MyLinkedList<Integer>(first);

		list.appendNode(second);
		list.appendNode(third);
		list.appendNode(fourth);
		list.appendNode(fifth);
		fifth.setNext(first);

		assertEquals(2.0,list.calculateMedian(third),0.001);
		assertEquals(2.0,list.calculateMedian(fifth),0.001);

		fifth.setNext(null);
		list.appendNode(sixth);

		sixth.setNext(first);

		assertEquals(2.5,list.calculateMedian(third),0.001);
	}
	@Test
	public void removeKthTest(){
		LinkedListNode<Integer> first = new LinkedListNode<Integer>(0);
		LinkedListNode<Integer> second = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> third = new LinkedListNode<Integer>(2);
		LinkedListNode<Integer> fourth = new LinkedListNode<Integer>(3);


		MyLinkedList<Integer> list = new MyLinkedList<Integer>(first);

		list.appendNode(second);
		list.appendNode(third);
		list.appendNode(fourth);


		assertEquals(list.getSize(),4);

		list.removeKth(2);

		assertEquals(list.getSize(),3);

		LinkedListNode<Integer> current = list.getHead(); 

		for(int i = 0; i < list.getSize();i++){
			if(i == 2) i = 3;
			assertEquals((int)current.getValue(),i);
			current= current.getNext();
		}
	}
	@Test(timeout = 100)
	public void climbLadderTest(){
		assertEquals("Ladder with 3 steps is not ok",3,P11.climbLadder(3));
		assertEquals("Ladder with 4 steps is not ok",5,P11.climbLadder(4));
		assertEquals("Ladder with 1000 steps is not ok",new Long(9079565065540428013L),(Long)P11.climbLadder(1000));
	}
	@Test
	public void arrangeArrayTest(){
		int [] arr = new int[]{0,1,1,0,0,1,0};
		P11.arrangeArray(arr);
		int [] answer = new int [] {0,0,0,0,1,1,1};

		for(int i = 0; i<arr.length;i++){
			assertEquals(arr[i],answer[i]);
		}
	}
	@Test
	public void threeBucketsTest(){
		int [] arr = new int[]{0,1,1,2,0,1,2,3,5,0,0};
		P11.threeBuckets(arr,1);
		int [] answer = new int [] {0,0,0,0,1,1,1,3,5,2,2};

		for(int i = 0; i<arr.length;i++){
			assertEquals(arr[i],answer[i]);
		}
	}
	@Test
	public void integerDivisionTest(){
		long start = System.nanoTime();
		int answer = P11.integerDivision(1000000000, 10);
		long end = System.nanoTime();


		assertEquals(1000000000/10,answer);
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
	@Test
	public void nonRepeatedTest(){
		String test1 =  "a";
		String test2 = "total";
		String test3 = "teeter";

		assertEquals(P11.firstNonRepeated(test1), (Character) 'a');
		assertEquals(P11.firstNonRepeated(test2), (Character) 'o');
		assertEquals(P11.firstNonRepeated(test3), (Character) 'r');

	}

	@Test
	public void removeCharsTest(){
		String test1 =  "a";
		String test2 = "total";
		String test3 = "teeter";

		assertEquals(P11.removeChars(test1,"a"), "");
		assertEquals(P11.removeChars(test2,"ao"), "ttl");
		assertEquals(P11.removeChars(test3,"er"), "tt");

	}
	@Test
	public void hasUniqueCharsTest(){
		String test1 = "";
		String test2 = "abc";
		String test3 = "abcdertfsa";

		assertTrue(P11.hasUniqueChars(test1));
		assertTrue(P11.hasUniqueChars(test2));
		assertFalse(P11.hasUniqueChars(test3));
	}
	@Test
	public void removeDuplicatesTest(){
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(1);
		list.add(4);
		list.add(2);
		list.add(3);
		list.add(4);

		P11.removeDuplicates(list);

		Integer [] arr = new Integer[] {1,4,2,3};

		for(int i = 0; i<list.size();i++){
			assertEquals(arr[i],list.get(i));
		}
	}
	@Test
	public void createBinarySearchTreeTest(){
		int [] arr = new int [] {1,2,3,4,5,6,7};
		BinaryTree<Integer> tree = P11.createBinarySearchTree(arr);
		ArrayList<ArrayList<Integer>> ret = P11.levelOrderTransversal(tree.getHead());
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
	public void partitionListTest(){
		LinkedListNode<Integer> first = new LinkedListNode<Integer>(4);
		LinkedListNode<Integer> second = new LinkedListNode<Integer>(7);
		LinkedListNode<Integer> third = new LinkedListNode<Integer>(9);
		LinkedListNode<Integer> fourth = new LinkedListNode<Integer>(5);
		LinkedListNode<Integer> fifth = new LinkedListNode<Integer>(10);
		LinkedListNode<Integer> sixth = new LinkedListNode<Integer>(3);

		MyLinkedList<Integer> list = new MyLinkedList<Integer>(first);

		list.appendNode(second);
		list.appendNode(third);
		list.appendNode(fourth);
		list.appendNode(fifth);	
		list.appendNode(sixth);

		P11.partitionList(list,6);

		int[] arr = new int []{4,5,3,10,9,7};

		assertEquals(6,list.getSize());
		LinkedListNode<Integer> current = list.getHead();
		int i = 0;
		while (current != null){
			assertEquals(current.getValue(),new Integer(arr[i++]));
			current = current.getNext();
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

		P11.hanoiTower(s1, s2, s3);

		assertEquals(s3.size(),5);

		for(int i = 0; i < 5;i++){
			assertEquals((int) s3.pop(),i);
		}
	}

	@Test
	public void isPermutationTest(){
		String s1 = "banana";
		String s2 = "1";
		String s3 = "nanaba";
		String s4 = "banany";

		assertFalse(P11.isPermutation(s1,s2));
		assertTrue(P11.isPermutation(s1, s3));
		assertFalse(P11.isPermutation(s1, s4));
	}
	@Test
	public void rotateMatrixTest(){
		int n = 4;

		int[][] matrix = new int[n][n];

		for (int i = 0; i < n;i++){
			for(int j = 0; j <n ; j++){
				matrix[i][j]= i+j;
			}	
		}
		String matrixString = 
				"[0 1 2 3]\n"
						+ "[1 2 3 4]\n"
						+ "[2 3 4 5]\n"
						+ "[3 4 5 6]\n";

		assertEquals(P11.printSquareMatrix(matrix),matrixString);

		P11.rotateMatrix(matrix);

		String rotatedMatrixString = 
				"[3 2 1 0]\n"
						+ "[4 3 2 1]\n"
						+ "[5 4 3 2]\n"
						+ "[6 5 4 3]\n";

		assertEquals(P11.printSquareMatrix(matrix),rotatedMatrixString);

	}
	@Test
	public void isRotationTest(){
		String s1 = "banana";
		String s2 = "nanaba";
		String s3 = "1";
		String s4 = "nanana";

		assertTrue(P11.isRotation(s1, s2));
		assertFalse(P11.isRotation(s1, s3));
		assertFalse(P11.isRotation(s1, s4));	
	}

	@Test
	public void setToZeroTest(){
		int n = 3;
		int m = 4;
		int [][] matrix = new int [n][m];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				matrix[i][j] = i+j;
			}
		}
		String matrixString = 
				"[0 1 2 3]\n"
						+ "[1 2 3 4]\n"
						+ "[2 3 4 5]\n";

		assertEquals(P11.printMatrix(matrix, n, m),matrixString);

		P11.setToZero(matrix);

		String zeroMatrix = 
				"[0 0 0 0]\n"
						+ "[0 2 3 4]\n"
						+ "[0 3 4 5]\n";
		assertEquals(P11.printMatrix(matrix, n, m),zeroMatrix);
	}
	@Test
	public void isListPalindromeTest(){
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('r');
		list.add('a');
		list.add('r');
		list.add('a');

		assertTrue(P11.isListPalindrome(list));
		LinkedList<Character> list2 = new LinkedList<>();

		list2.add('b');
		list2.add('a');
		list2.add('n');
		list2.add('a');
		list2.add('n');
		list2.add('a');

		assertFalse(P11.isListPalindrome(list2));
	}

	@Test
	public void sortStackTest(){
		Stack<Integer> stack = new Stack<>();
		stack.push(7);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(6);

		int [] arr = new int[]{7,6,5,2,1};

		P11.sortStack(stack);
		assertEquals(stack.size(),5);

		for(int i = 0; i < arr.length; i++){
			assertEquals(arr[i],(int) stack.pop());
		}
	}

}
