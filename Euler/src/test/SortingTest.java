package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import problems.algorithms.SortingAlgorithm;

public class SortingTest {

	@Test
	public void sortingTest(){
		int n = 1000;
		int [] arr = new int [n];
		Random rand = new Random();
		for (int j = 0; j<n; j++)
		{
		    arr[j] = rand.nextInt(100000);
		}

		int [] ret = arr.clone();
		Arrays.sort(ret);

		long startTime = System.nanoTime();
		//O(nlogn) com O(n) para espaco
		int [] mergeSortArr = SortingAlgorithm.mergeSort(arr);

		long endTime = System.nanoTime();

		System.out.println("Merge sort: " + (endTime-startTime));

		for( int i = 0;i < arr.length;i++){
			assertEquals(mergeSortArr[i],ret[i]);
		}
		startTime = System.nanoTime();
		//O(n^2) na media, mas O(n) quando quase ordenado e O(1) por ser in place
		//Bom para situacoes onde vem uma coisa de cada vez
		int [] insertionSortArr = SortingAlgorithm.insertionSort(arr);
		endTime = System.nanoTime();

		System.out.println("Insertion sort: " + (endTime-startTime));

		for( int i = 0;i < arr.length;i++){
			assertEquals(insertionSortArr[i],ret[i]);
		}
		startTime = System.nanoTime();
		//O(nlogn) com O(logN) espaco e inplace. fica logN pelas chamadas recursivas
		int [] quickSortArr = SortingAlgorithm.quickSort(arr);
		endTime = System.nanoTime();
		System.out.println("Quicksort: " + (endTime-startTime));

		for( int i = 0;i < arr.length;i++){
			assertEquals(quickSortArr[i],ret[i]);
		}
		//19380492000
		//30221056000
		//757272000
		startTime = System.nanoTime();
		//O(kn) sendo k o numero de digitos do maior numero. O(k+n) pra espaco por conta
		// dos buckets
		int [] radixSortArr = SortingAlgorithm.radixSort(arr);
		endTime = System.nanoTime();

		System.out.println("Radix Sort: " + (endTime-startTime));

		for( int i = 0;i < arr.length;i++){
			assertEquals(radixSortArr[i],ret[i]);
		}
		startTime = System.nanoTime();

		int [] countingSortArr = SortingAlgorithm.countingSort(arr);

		endTime = System.nanoTime();

		System.out.println("Counting Sort: " + (endTime-startTime));

		for( int i = 0;i < arr.length;i++){
			assertEquals(countingSortArr[i],ret[i]);
		}
	}

}
