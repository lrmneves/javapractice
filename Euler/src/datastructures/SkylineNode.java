package datastructures;

public class SkylineNode implements Comparable<SkylineNode>{
	int heigth;
	private int x0;
	private int x1;
	private SkylineNode left;
	private SkylineNode right;
	
public SkylineNode(int x0,int x1, int h){
	this.setX0(x0);
	this.setX1(x1);
	this.heigth = h;
	setLeft(null);
	setRight(null);
}
	
	@Override
	public int compareTo(SkylineNode o) {
		if(this == o) return 0;
		SkylineNode obj = (SkylineNode) o;
		if(obj.heigth == heigth) return 0;
		if(obj.heigth > heigth) return 1;
		return -1;
	}

	public int getX0() {
		return x0;
	}

	public void setX0(int x0) {
		this.x0 = x0;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public SkylineNode getRight() {
		return right;
	}

	public void setRight(SkylineNode right) {
		this.right = right;
	}

	public SkylineNode getLeft() {
		return left;
	}

	public void setLeft(SkylineNode left) {
		this.left = left;
	}
	
}
