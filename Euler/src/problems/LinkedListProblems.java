package problems;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import datastructures.LinkedListNode;
import datastructures.MyLinkedList;


public class LinkedListProblems {

	public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2){
	
		LinkedList<Integer> ret = new LinkedList<Integer>();
	
		int n1 = l1.peek() != null ? l1.poll(): 0;
		int n2 = l2.peek() !=null ? l2.poll(): 0;
	
		int carry = 0;
	
		while (l1.peek() != null|| l2.peek()!=null){
			ret.add((n1+n2+carry)%10);
			carry = (n1+n2+carry)/10;
			n1 = l1.peek() != null? l1.poll(): 0;
			n2 = l2.peek() != null? l2.poll(): 0;
		}
	
		if(carry > 0){
			ret.add(carry+n1+n2);
		}
		return ret;
	
	}

	public static void removeDuplicates(LinkedList<Integer> list){
		if(list.size() <2) return;
		HashSet<Integer> seen = new HashSet<>();
		Iterator<Integer> it = list.iterator();
		seen.add(it.next());
		int currentValue;
		while(it.hasNext()){
			currentValue = it.next();
			if(seen.contains(currentValue)) it.remove();
			else seen.add(currentValue);
		}
	}

	public static void partitionList(MyLinkedList<Integer> list, int value) {
		if (list.getSize() < 1) return;
	
		LinkedListNode<Integer> current = list.getHead();
		LinkedListNode<Integer> firstHalf = null;
		LinkedListNode<Integer> secondHalf = null;
		LinkedListNode<Integer> aux;
	
		while(current != null){
			if (current.getValue() < value){
				if(firstHalf == null) {
					firstHalf = current;
					list.setHead(firstHalf);
				}
				else{
					firstHalf.setNext(current);
					firstHalf = current;
				}
				current = current.getNext();
	
			}
			else{
				if(secondHalf == null){
					secondHalf = current;
					current = current.getNext();
					secondHalf.setNext(null);
				}
				else{
					aux = current.getNext();
					current.setNext(secondHalf);
					secondHalf = current;
					current = aux;
				}
				if(firstHalf == null) list.setHead(secondHalf);
			}
	
		}
		if(firstHalf != null) firstHalf.setNext(secondHalf);
	}

	public static boolean isListPalindrome(LinkedList<Character> list){
	
		Iterator<Character> it = list.iterator();
		Stack<Character> stack = new Stack<>();
		int size = 0;
		while(it.hasNext()){
			stack.push(it.next());
			size++;
		}
	
		it = list.iterator();
	
		for(int i = 0; i < size/2 ; i++){
			char c1 = stack.pop();
			char c2 = it.next();
			if(c1 != c2) return false;
		}
		return true;
	
	}

	public static void sortStack(Stack<Integer> stack){
		if(stack.isEmpty()) return;
	
		Stack<Integer> auxStack = new Stack<>();
		int largest = stack.pop();
		int size = 1;
	
		while(!stack.isEmpty()){
			int value = stack.pop();
			if(value > largest){
				auxStack.push(largest);
				largest = value;
			}
			else{
				auxStack.push(value);
			}
			size++;
		}
		while(!auxStack.isEmpty()){
			stack.push(auxStack.pop());
		}
		auxStack.push(largest);
	
		largest = stack.pop();
	
		for(int i = 1 ; i < size-1; i++){
			while(!stack.isEmpty()){
				int value = stack.pop();
				if(value > largest){
					auxStack.push(largest);
					largest = value;
				}
				else{
					auxStack.push(value);
				}
			}
			for(int j = 0; j < size - i -1; j++){
				stack.push(auxStack.pop());
			}
			auxStack.push(largest);
			largest = stack.pop();
		}
		stack.push(largest);
		while(!auxStack.isEmpty()){
			stack.push(auxStack.pop());
		}
	}

}
