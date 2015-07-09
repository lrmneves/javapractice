package utils;

import java.util.Comparator;

public class BinaryTreeNode<T extends Comparable<T>>{
	T value;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	int balanceFactor;


	public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
		this.value = value;
		this.left = left;
		this.right = right;
		balanceFactor = (this.left == null?0:this.left.getHeight()) - (this.right==null?0:this.right.getHeight());
	}
	public BinaryTreeNode(T value){
		this(value,null,null);
	}

	public T getValue(){
		return value;
	}
	public BinaryTreeNode<T> getLeft(){
		return left;
	}
	public BinaryTreeNode<T> getRight(){
		return right;
	}
	public boolean isLeaf(){
		return (left == null && right == null);
	}
	public void setLeft(BinaryTreeNode<T> left){
		this.left = left;
	}
	public void setRight(BinaryTreeNode<T> right){
		this.right = right;
	}
	public int getHeight(){
		if (isLeaf()){
			return 0;
		}
		else{
			return Math.max((left == null? 0:left.getHeight()),
					(right == null? 0: right.getHeight())) + 1;
		}
	}
	public int isBalanced(){
		if (isLeaf()){
			return 0;
		}
		else{
			int leftHeight = (left!=null?left.isBalanced():0);
			int rightHeight = (right != null? right.isBalanced():0);
			if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) >1){
				return -1;
			}
			return Math.max(leftHeight, rightHeight) +1 ;
		}
	}
	public int getBalanceFactor(){
		return balanceFactor;
	}
	public int updateBalanceFactor(){
		balanceFactor = (left == null?0:left.getHeight()) - (right==null?0:right.getHeight());
		return balanceFactor;
	}
	public int compareTo(BinaryTreeNode<T> node){
		return this.getValue().compareTo(node.getValue());
	}

}