import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
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

}
