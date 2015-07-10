package datastructures;

public class MyHeap {
	int [] heapArray;
	int lastElement;
	boolean isMin;// defines if it is a max or a min heap
	
	private void swapValues(int i, int j){
		int aux = heapArray[i];
		heapArray[i] = heapArray[j];
		heapArray[j] = aux;
	}
	public MyHeap(int size, boolean isMin){
		this.heapArray = new int[size];
		this.lastElement = -1;
		this.isMin = isMin;
	}
	public boolean isEmpty(){
		return lastElement == -1;
	}
	public boolean isFull(){
		return lastElement == heapArray.length - 1;
	}
	public void insert(int value){
		if (isFull()) return;
		
		int index = ++lastElement;
		int parentIndex = (index-1)/2;
		heapArray[index] = value;
		if (isMin){
			while(heapArray[index] < heapArray[parentIndex]){
				swapValues(index,parentIndex);
				index = parentIndex;
				parentIndex = (index-1)/2;
			}	
		}
		else{
			while(heapArray[index] > heapArray[parentIndex]){
				swapValues(index,parentIndex);
				index = parentIndex;
				parentIndex = (index-1)/2;
			}	
		}
		
	}
	public int extract(){
		if(this.isEmpty()) return -1;
		
		int value = heapArray[0];
		heapArray[0] = heapArray[lastElement];
		heapArray[lastElement--] = 0;
		int index = 0;
		
		if(isMin){
			while((2*index +2 <= lastElement) && 
					(heapArray[index] > heapArray[2*index + 1]||heapArray[index] > heapArray[2*index + 2])){
				if(heapArray[2*index + 1] < heapArray[2*index + 2]){
					swapValues(index,2*index+1);
					index = 2*index+1;
				}
				else{
					swapValues(index,2*index+2);
					index = 2*index+2;
				}
			}
			if(2*index + 1 <= lastElement){
				if(heapArray[2*index + 1] < heapArray[index]){
					swapValues(index,2*index+1);
				}
			}
		}
		else{
			while((2*index +2 <= lastElement) && 
					(heapArray[index] < heapArray[2*index + 1]||heapArray[index] < heapArray[2*index + 2])){
				if(heapArray[2*index + 1] > heapArray[2*index + 2]){
					swapValues(index,2*index+1);
					index = 2*index+1;
				}
				else{
					swapValues(index,2*index+2);
					index = 2*index+2;
				}
			}
			if(2*index + 1 <= lastElement){
				if(heapArray[2*index + 1] > heapArray[index]){
					swapValues(index,2*index+1);
				}
			}
		}
		return value;
	}
	
	public void printHeap(){
		for(int a: heapArray){
			System.out.println(a);
		}
	}
	
}
