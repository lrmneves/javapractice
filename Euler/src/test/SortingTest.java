package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

import org.junit.Test;

import problems.algorithms.SortingAlgorithm;

public class SortingTest {

	@Test
	public void sortingTest(){
		int n = 10000;
		int [] arr = new int [n];
		Random rand = new Random();
		for (int j = 0; j<n; j++)
		{
		    arr[j] = rand.nextInt(100000);
		}
		HashMap<Long, String> timeMap = new HashMap<>();
		PriorityQueue<Long> heap = new PriorityQueue<>(); 
		
		int [] ret = arr.clone();
		Arrays.sort(ret);

		long startTime = System.nanoTime();
		//O(nlogn) com O(n) para espaco
		int [] mergeSortArr = SortingAlgorithm.mergeSort(arr);

		long endTime = System.nanoTime();

		timeMap.put(endTime-startTime,"Merge sort: " + (endTime-startTime));
		heap.add(endTime-startTime);

		assertArrayEquals(mergeSortArr,ret);

		startTime = System.nanoTime();
		//O(n^2) na media, mas O(n) quando quase ordenado e O(1) por ser in place
		//Bom para situacoes onde vem uma coisa de cada vez
		int [] insertionSortArr = SortingAlgorithm.insertionSort(arr);
		endTime = System.nanoTime();

		timeMap.put(endTime-startTime,"Insertion sort: " + (endTime-startTime));
		heap.add(endTime-startTime);

		assertArrayEquals(insertionSortArr,ret);

		startTime = System.nanoTime();
		//O(nlogn) com O(logN) espaco e inplace. fica logN pelas chamadas recursivas
		int [] quickSortArr = SortingAlgorithm.quickSort(arr);
		endTime = System.nanoTime();
		
		timeMap.put(endTime-startTime,"Quicksort: " + (endTime-startTime));
		heap.add(endTime-startTime);

		assertArrayEquals(quickSortArr,ret);

		
		
		startTime = System.nanoTime();
		//O(kn) sendo k o numero de digitos do maior numero. O(k+n) pra espaco por conta
		// dos buckets
		int [] radixSortArr = SortingAlgorithm.radixSort(arr);
		endTime = System.nanoTime();

		timeMap.put(endTime-startTime,"Radix sort: " + (endTime-startTime));
		heap.add(endTime-startTime);
 
		assertArrayEquals(radixSortArr,ret);

		startTime = System.nanoTime();
		//Pego da internet
		int [] otherRadixSortArr = SortingAlgorithm.radixSort(arr);
		endTime = System.nanoTime();

		timeMap.put(endTime-startTime,"Other Radix sort: " + (endTime-startTime));
		heap.add(endTime-startTime);
 
		assertArrayEquals(otherRadixSortArr,ret);

		startTime = System.nanoTime();

		int [] countingSortArr = SortingAlgorithm.countingSort(arr);

		endTime = System.nanoTime();

		timeMap.put(endTime-startTime,"Counting sort: " + (endTime-startTime));
		heap.add(endTime-startTime);

		assertArrayEquals(countingSortArr,ret);

		startTime = System.nanoTime();

		int [] bubbleSortArr = SortingAlgorithm.bubbleSort(arr);

		endTime = System.nanoTime();


		timeMap.put(endTime-startTime,"Bubble sort: " + (endTime-startTime));
		heap.add(endTime-startTime);

		assertArrayEquals(bubbleSortArr,ret);

		
		while(heap.size() > 0){
			System.out.println(timeMap.get(heap.poll()));
		}
		
	}

}
