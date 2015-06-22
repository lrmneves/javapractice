package utils;

public class BinaryTree<T>{
	BinaryTreeNode<T> head;
	public BinaryTree(BinaryTreeNode<T> head){
		this.head = head;
	}
	public BinaryTreeNode<T> getHead(){
		return head;
	}
	public int getHeight(){
		return head.getHeight();
	}
	public boolean isBalanced(){
		return head.isBalanced() != -1;
	}

}


