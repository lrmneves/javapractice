package utils;

public class LinkedListNode<T> {
	private T value;
	private LinkedListNode<T> next;
	
	public LinkedListNode(T value){
		this.value = value;
		this.next = null;
	}
	
	public void setNext(LinkedListNode<T> next){
		this.next = next;
	}
	
	public LinkedListNode<T> getNext(){
		return next;
	}
	public T getValue(){
		return value;
	}
	public void setValue(T value){
		this.value = value;
	}
	public boolean isTail(){
		return next == null;
	}
 }
