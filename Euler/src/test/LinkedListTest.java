package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

import datastructures.LinkedListNode;
import datastructures.MyLinkedList;
import problems.LinkedListProblems;

public class LinkedListTest {

	@Test
	public void sortStackTest(){
		Stack<Integer> stack = new Stack<>();
		stack.push(7);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(6);

		int [] arr = new int[]{7,6,5,2,1};

		LinkedListProblems.sortStack(stack);
		assertEquals(stack.size(),5);

		for(int i = 0; i < arr.length; i++){
			assertEquals(arr[i],(int) stack.pop());
		}
	}

	@Test
	public void isListPalindromeTest(){
		LinkedList<Character> list = new LinkedList<>();
		list.add('a');
		list.add('r');
		list.add('a');
		list.add('r');
		list.add('a');

		assertTrue(LinkedListProblems.isListPalindrome(list));
		LinkedList<Character> list2 = new LinkedList<>();

		list2.add('b');
		list2.add('a');
		list2.add('n');
		list2.add('a');
		list2.add('n');
		list2.add('a');

		assertFalse(LinkedListProblems.isListPalindrome(list2));
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

		LinkedListProblems.partitionList(list,6);

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
	public void removeDuplicatesTest(){
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(1);
		list.add(4);
		list.add(2);
		list.add(3);
		list.add(4);

		LinkedListProblems.removeDuplicates(list);

		Integer [] arr = new Integer[] {1,4,2,3};

		for(int i = 0; i<list.size();i++){
			assertEquals(arr[i],list.get(i));
		}
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

}
