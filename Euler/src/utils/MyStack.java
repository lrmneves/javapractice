package utils;

public class MyStack<T> {
	private MyLinkedList<T> stack;
	private MyLinkedList<T> maxStack;
	
	public MyStack(){
		stack = new MyLinkedList<T>();
		maxStack = new MyLinkedList<T>();
	}
	
	public T pop(){
		maxStack.removeFromBeggining();
		return stack.removeFromBeggining().getValue();
		
	}
	
	public T peek(){
		if(stack.getSize() == 0) return null;
		return stack.getHead().getValue();
	}
	
	public void push(T value){
		stack.addNodeBeggining(new LinkedListNode<T>(value));
		if((int) value > (int) maxStack.getHead().getValue()){
			maxStack.addNodeBeggining(new LinkedListNode<T> (value));
		}
		else{
			maxStack.addNodeBeggining(new LinkedListNode<T> (maxStack.getHead().getValue()));
		}
		
	}
	
	public T max(){
		if(stack.getSize() == 0) return null;
		return maxStack.getHead().getValue();
	}
}
