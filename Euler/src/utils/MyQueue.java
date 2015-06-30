package utils;

import java.util.Stack;
/**
 * Queue implementation with two stacks
 * @author lrmneves
 *
 * @param <T>
 */
public class MyQueue<T> {
	
	Stack<T> stack1;
	Stack<T> stack2;
	
	public MyQueue(){
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	public boolean add(T value){
		return stack1.add(value);
	}
	
	public T pop(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.add(stack1.pop());
			}
		}
		if(stack2.isEmpty()) return null;
		return stack2.pop();
	}
	
}
