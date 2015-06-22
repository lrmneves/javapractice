package utils;

import java.util.HashSet;

public class MyLinkedList<T> {
	LinkedListNode<T> head;
	LinkedListNode<T> tail;
	int size;

	public MyLinkedList(){
		this.head = null;
		this.tail = null;
		size = 0;
	}
	public MyLinkedList(LinkedListNode<T> head){
		this.head = head;
		this.tail = head;
		size = 1;
	}
	public void appendNode(LinkedListNode <T> node){
		if(size == 0){
			head = node;
			tail = node;
		}
		else{
			tail.setNext(node);
			tail = node;
		}
		size++;
	}
	public void addNodeBeggining(LinkedListNode<T> newHead){
		newHead.setNext(head);
		head = newHead;
		size++;
	}
	public LinkedListNode<T> removeFromBeggining(){
		if(size == 0) return null;
		LinkedListNode<T> first = head;
		head = head.getNext();
		size--;
		first.setNext(null);
		return first;
	}
//	public LinkedListNode<T> removeFromEnd(){
//		if(size == 0) return null;
//		LinkedListNode<T> last = tail;
//		
//	}
	public int getSize(){
		return size;
	}
	public LinkedListNode<T> getHead(){
		return head;
	}
	public void setHead(LinkedListNode<T> node){
		head = node;
	}
	private LinkedListNode<T> getTail() {
		return tail;
	}

	public void reverseList(){
		LinkedListNode<T> last = null;
		LinkedListNode<T> current = head;

		LinkedListNode<T> next = current.getNext();

		tail = head;

		while(current.getNext() != null){
			current.setNext(last);
			last = current;
			current = next;
			next = current.getNext();
		}
		current.setNext(last);
		head = current;
	}

	public void mergeTo(MyLinkedList<T> list2){
		LinkedListNode<T> l1 = this.getHead();
		LinkedListNode<T> l2 = list2.getHead();
		LinkedListNode<T> current;

		if((int) l1.getValue() > (int) l2.getValue()){
			current = l2;
			head = current;
			l2 = l2.getNext();
		}
		else{
			current = l1;
			l1 = l1.getNext();
		}
		while (l1!= null && l2!=null){
			if((int) l1.getValue() > (int) l2.getValue()){
				current.setNext(l2);
				l2 = l2.getNext();
			}
			else{
				current.setNext(l1);
				l1 = l1.getNext();
			}
			current = current.getNext();
		}
		if(l1 == null){
			current.setNext(l2);
			this.tail = list2.getTail();
		}
		else if(l2 == null){
			current.setNext(l1);
		}
		this.size = this.size + list2.getSize();

	}

	public LinkedListNode<T> hasCycle(){
		if(size < 2) return null;
		HashSet<LinkedListNode<T>> visitedNodes = new HashSet<LinkedListNode<T>>(this.size);

		visitedNodes.add(head);
		LinkedListNode<T> current = head.getNext();

		while(current.getNext()!= null){
			if(visitedNodes.contains(current.getNext())){
				return current;
			}
			visitedNodes.add(current);
			current = current.getNext();
		}
		return null;

	}
	public double calculateMedian(LinkedListNode<Integer> node) {
		if(size < 2) return (int) head.getValue();

		int visited = 1;
		LinkedListNode<Integer> current = node;
		LinkedListNode<Integer> first = null;


		while(!current.getNext().equals(node)){
			if(current.getValue() > current.getNext().getValue()){
				first = current.getNext();
			}
			current = current.getNext();
			visited++;
		}

		current = first;

		for(int i = 0; i<visited/2 -1;i++){
			current = current.getNext();
		}
		if(visited%2 == 1){
			return current.getNext().getValue();
		}
		return (current.getValue() + current.getNext().getValue())/2.0;

	}

	public void removeNode(LinkedListNode<T> node){

		node.setValue(node.getNext().getValue());
		node.setNext(node.getNext().getNext());
		size--;
	}

	public void removeKth(int k){
		LinkedListNode<T> faster = head;
		LinkedListNode<T> slower = head;

		for(int i = 0; i < k ; i++){
			if(faster.getNext() != null){
				faster = faster.getNext();
			}
			else return;	
		}
		while(faster != null){
			faster= faster.getNext();
			slower= slower.getNext();
		}
		removeNode(slower);	
	}

}
