package utils;

public class BST <T extends Comparable<T>> extends BinaryTree<T> {

	public BST(BinaryTreeNode<T> head) {
		super(head);
	}

	public void insertNode(T value){
		insertNode(new BinaryTreeNode<T>(value));
	}
	public void insertNode(BinaryTreeNode<T> node){
		BinaryTreeNode<T> current = head;

		while (current != null){

			if(node.compareTo(current) > 0){
				if(current.getRight() == null){
					current.setRight(node);
					break;
				}
				current = current.getRight();
			}
			else{
				if(current.getLeft() == null){
					current.setLeft(node);
					break;
				}
				current = current.getLeft();
			}
		}
		balanceTree();
		return;
	}

	public void rotationLL(BinaryTreeNode<T> nodeParent, BinaryTreeNode<T> node){
		BinaryTreeNode<T> left = node.getLeft();
		node.setLeft(left.getRight());
		left.setRight(node);
		
		if(nodeParent != null) nodeParent.setLeft(left);
		else head = left;
		
		node.balanceFactor = 0;
		left.balanceFactor = 0;

	}
	public void rotationRR(BinaryTreeNode<T> nodeParent, BinaryTreeNode<T> node){
		BinaryTreeNode<T> right = node.getRight();
		node.setRight(right.getLeft());
		right.setLeft(node);
		
		if(nodeParent != null) nodeParent.setRight(right);
		else head = right;
		
		node.balanceFactor = 0;
		right.balanceFactor = 0;

	}
	public void rotationLR(BinaryTreeNode<T> nodeParent,BinaryTreeNode<T>node){
		BinaryTreeNode<T> left = node.getLeft();
		BinaryTreeNode<T> grandchild = left.getRight();

		left.setRight(grandchild.getLeft());

		grandchild.setLeft(left);
		node.setLeft(grandchild.getRight());

		grandchild.setRight(node);

		if(nodeParent != null)nodeParent.setLeft(grandchild);
		else head = grandchild;
		
		if (grandchild.balanceFactor == 1){
			node.balanceFactor = -1;
			left.balanceFactor=0;
		}else if(grandchild.balanceFactor == 0){
			node.balanceFactor = 0;
			left.balanceFactor = 0;
		}else{
			node.balanceFactor =0;
			left.balanceFactor = 1;
		}
		grandchild.balanceFactor = 0;
		
	}
	public void rotationRL(BinaryTreeNode<T> nodeParent,BinaryTreeNode<T>node){
		BinaryTreeNode<T> right = node.getRight();
		BinaryTreeNode<T> grandchild = right.getLeft();

		right.setLeft(grandchild.getRight());

		grandchild.setRight(right);
		node.setRight(grandchild.getLeft());

		grandchild.setLeft(node);

		if(nodeParent != null) nodeParent.setRight(grandchild);
		else head = grandchild;
		
		if (grandchild.balanceFactor == 1){
			right.balanceFactor = -1;
			node.balanceFactor=0;
		}else if(grandchild.balanceFactor == 0){
			node.balanceFactor = 0;
			right.balanceFactor = 0;
		}else{
			node.balanceFactor =1;
			right.balanceFactor = 0;
		}
		grandchild.balanceFactor = 0;
	}

	public void balanceTree(){
		balanceTree(head);
	}

	private int balanceTree(BinaryTreeNode<T> node) {
		if (node.isLeaf()){
			return 0;
		}
		else{
			int leftHeight = (node.getLeft()!=null?balanceTree(node.getLeft()):0);
			int rightHeight = (node.getRight() != null? balanceTree(node.getRight()):0);
			node.balanceFactor = leftHeight - rightHeight;
			if(node.getLeft() != null &&  node.getLeft().getBalanceFactor() >= 2){ 
				if(node.getLeft().getLeft().getBalanceFactor() > 0 ){
					rotationLL(node,node.getLeft());
				}
				else{
					rotationLR(node,node.getLeft());
				}	
				leftHeight = (node.getLeft()!=null?balanceTree(node.getLeft()):0);
				rightHeight = (node.getRight() != null? balanceTree(node.getRight()):0);
				node.balanceFactor = leftHeight - rightHeight;
			}
			if(node.getRight()!= null && node.getRight().getBalanceFactor() <= -2){ 
				if(node.getRight().getRight().getBalanceFactor() > 0 ){
					rotationRL(node,node.getRight());
				}
				else{
					rotationRR(node,node.getRight());
				}
				leftHeight = (node.getLeft()!=null?balanceTree(node.getLeft()):0);
				rightHeight = (node.getRight() != null? balanceTree(node.getRight()):0);
				node.balanceFactor = leftHeight - rightHeight;
			}
			if(node == head){
				if(node.getBalanceFactor() >= 2){ 
					if(node.getLeft().getBalanceFactor() > 0 ){
						rotationLL(null,node);
					}
					else{
						rotationLR(null,node);
					}	
				}
				if(node.getBalanceFactor() <= -2){ 
					if(node.getRight().getBalanceFactor() > 0 ){
						rotationRL(null,node);
					}
					else{
						rotationRR(null,node);
					}
				}
			}

			return Math.max(Math.abs(leftHeight), Math.abs(rightHeight)) +1 ;
		}

	}
}
