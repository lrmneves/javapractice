package problems.algorithms;
import java.util.LinkedList;

import problems.ArrayAndStringProblems;


public class SortingAlgorithm {

	public static int [] mergeSort(int [] arr){
		if (arr == null || arr.length < 2) return arr;
	
		return SortingAlgorithm.mergeSort(arr,0,arr.length-1);
	}

	public static int[] mergeSort(int[] arr,int start,int end) {
		if(arr == null) return null;
		if(arr.length == 1)return arr;
		if(start == end) return new int[]{arr[start]};
	
		int middle = (end + start)/2;
	
		int [] left = mergeSort(arr,start,middle);
		int [] right = mergeSort(arr,middle+1,end);
	
		return SortingAlgorithm.merge(left,right);
	}

	static int [] merge(int [] left, int [] right){
		if(left == null) return right;
		if(right == null) return left;
	
		int [] mergeArr = new int[left.length + right.length];
	
		int leftIndx = 0;
		int rightIndx = 0;
	
		for( int i = 0; i < mergeArr.length;i++){
			if(leftIndx > left.length -1) mergeArr[i] = right[rightIndx++];
			else if(rightIndx > right.length -1) mergeArr[i] = left[leftIndx++];
			else{
				if(left[leftIndx] < right[rightIndx]){
					mergeArr[i] = left[leftIndx++];
				}
				else{
					mergeArr[i] = right[rightIndx++];
				}
			}
		}
		return mergeArr;
	
	
	}

	public static int [] countingSort(int [] arr){
	
		if (arr == null || arr.length < 2) return arr;
	
		int[] retArr = arr.clone();
	
	
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
	
		for(int i = 0; i < arr.length; i++){
			if(max < arr[i]) max = arr[i];
			if(min > arr[i]) min = arr[i];
		}
		int [] countingSortArr = new int[(min < 0?Math.abs(min):0) + Math.abs(max) + 1];
	
		for(int i = 0; i < arr.length; i++){
			countingSortArr[arr[i]+(min < 0?Math.abs(min):0)]++;
		}
		int j =0;
		for(int i =0; i < countingSortArr.length;i++){
			while(countingSortArr[i] > 0){
				retArr[j++] = i - (min < 0?Math.abs(min):0);
				countingSortArr[i]--;
			}
		}
		return retArr;
	
	
	}

	static int partition(int [] arr, int start, int end){
	
		int wall = start;
	
		while(start < end){
			if(arr[start] < arr[end]){
				ArrayAndStringProblems.swap(arr,start,wall);
				wall++;
			}
			start++;
		}
		if(wall != start) ArrayAndStringProblems.swap(arr,wall,end);
		return wall;
	}

	static void quickSort(int[] quickSortArr, int start, int end) {
	
		if(start<end){
			int newPivot = partition(quickSortArr,start,end);
	
	
			quickSort(quickSortArr,start,newPivot-1);
			quickSort(quickSortArr,newPivot+1,end);
		}
	}

	public static int [] quickSort(int [] arr){
		if (arr == null || arr.length < 2) return arr;
	
		//sorts in place, but would affect the original array
		int [] quickSortArr = arr.clone();
		quickSort(quickSortArr,0,quickSortArr.length-1);
		return quickSortArr;
	}

	public static int [] insertionSort(int [] arr){
		//sorts in place, but would affect the original array
		if (arr == null || arr.length < 2) return arr;
	
		int [] insertionSortArr = arr.clone();
		for(int i = 0; i < insertionSortArr.length-1; i++){
			int j = i+1;
			while(j > 0 && insertionSortArr[j] < insertionSortArr[j-1]){
				ArrayAndStringProblems.swap(insertionSortArr,j,j-1);
				j--;
			}	
		}
		return insertionSortArr;
	}

	@SuppressWarnings("unchecked")
	public static int [] radixSort(int [] arr){
		//sorts in place, but would affect the original array
		if (arr == null || arr.length < 2) return arr;
	
		int [] radixSortArr = arr.clone();
	
		LinkedList<Integer> [] buckets = new LinkedList[10];
		for(int i = 0; i < buckets.length;i++){
			buckets[i] = new LinkedList<Integer>();
		}
		int m = 10;
		int n = 1;
		int max = -1;
		while(max != 0){
			max = 0;
			for(int i = 0; i < radixSortArr.length; i++){
				buckets[(radixSortArr[i]%m - radixSortArr[i]%n)/n].add(radixSortArr[i]); 
			}
			m*=10;
			n*=10;
	
			int i = 0;
			for(int j = 0; j < buckets.length;j++){
				while(!buckets[j].isEmpty()){
					radixSortArr[i] = buckets[j].removeFirst();
					int value =  (radixSortArr[i]%m - radixSortArr[i]%n)/n;
					if(value > max) max = value;
					i++;
				}
			}
		}
		return radixSortArr;
	
	
	
	}

}
