package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import problems.ArrayAndStringProblems;
import problems.LinkedListProblems;

public class ArrayAndStringTest {

	@Test
	public void twoSumTest() {
		int [] arr = new int []{2,7,11,15};
		int value = 9;
		int [] ret = ArrayAndStringProblems.twoSum(arr,value);

		assertEquals(ret[0],0);
		assertEquals(ret[1],1);

		value = 13;
		ret = ArrayAndStringProblems.twoSum(arr,value);

		assertEquals(ret[0],0);
		assertEquals(ret[1],2);
	}

	@Test
	public void threeSumTest(){
		int [] arr = new int []{-1,0,1,2,-1,-4};
		int value = -6;
		int sum;

		ArrayList<Integer[]> ret = ArrayAndStringProblems.tripleSum(arr,value);
		assertEquals(ret.size(),1);

		for(Integer[] tuple : ret){
			sum = 0;
			for(Integer i : tuple){
				sum+= i;
			}
			assertEquals(sum,value);
		}

		value = 0;
		ret = ArrayAndStringProblems.tripleSum(arr,value);
		assertEquals(ret.size(),2);

		for(Integer[] tuple : ret){
			sum = 0;
			for(Integer i : tuple){
				sum+= i;
			}
			assertEquals(sum,value);
		}
	}

	@Test
	public void closesThreeSumTest(){
		int [] arr = new int []{-1,2,1,-4};
		int value = 1;
		int sum = ArrayAndStringProblems.closestTripleSum(arr, value);
		assertEquals(sum, 2);
	}

	@Test
	public void sumTwoNumbersTest(){
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();

		l1.add(2);l1.add(4);l1.add(3);
		l2.add(5);l2.add(6);l2.add(4);
		LinkedList<Integer> ret = LinkedListProblems.addTwoNumbers(l1, l2);

		assertEquals(ret.poll(), new Integer(7));
		assertEquals(ret.poll(), new Integer(0));
		assertEquals(ret.poll(), new Integer(8));

	}
	@Test
	public void anagramList(){
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("listen");
		strings.add("silent");
		strings.add("egg");
		strings.add("solve");
		strings.add("loves");

		ArrayList<ArrayList<String>> ret = ArrayAndStringProblems.findAnagrams(strings);
		assertEquals(ret.size(),2);
		assertEquals(ret.get(0).size(),2);		
	}

	@Test
	public void bestStockTest(){
		int [] arr = new int[] {5,7,4,2,5,9,8,1};
		int max = ArrayAndStringProblems.bestStock(arr);
		assertEquals(max,7);
	}

	@Test
	public void bestStockTest2(){
		int [] arr = new int[] {5,7,4,2,5,9,8,1};
		int max = ArrayAndStringProblems.bestStock2(arr);
		assertEquals(max,9);
	}

	@Test
	public void arrangeArrayTest(){
		int [] arr = new int[]{0,1,1,0,0,1,0};
		ArrayAndStringProblems.arrangeArray(arr);
		int [] answer = new int [] {0,0,0,0,1,1,1};

		for(int i = 0; i<arr.length;i++){
			assertEquals(arr[i],answer[i]);
		}
	}

	@Test
	public void threeBucketsTest(){
		int [] arr = new int[]{0,1,1,2,0,1,2,3,5,0,0};
		ArrayAndStringProblems.threeBuckets(arr,1);
		int [] answer = new int [] {0,0,0,0,1,1,1,3,5,2,2};

		for(int i = 0; i<arr.length;i++){
			assertEquals(arr[i],answer[i]);
		}
	}
	@Test
	public void integerDivisionTest(){
		int answer = ArrayAndStringProblems.integerDivision(1000000000, 10);

		assertEquals(1000000000/10,answer);
	}
	@Test
	public void nonRepeatedTest(){
		String test1 =  "a";
		String test2 = "total";
		String test3 = "teeter";

		assertEquals(ArrayAndStringProblems.firstNonRepeated(test1), (Character) 'a');
		assertEquals(ArrayAndStringProblems.firstNonRepeated(test2), (Character) 'o');
		assertEquals(ArrayAndStringProblems.firstNonRepeated(test3), (Character) 'r');

	}

	@Test
	public void removeCharsTest(){
		String test1 =  "a";
		String test2 = "total";
		String test3 = "teeter";

		assertEquals(ArrayAndStringProblems.removeChars(test1,"a"), "");
		assertEquals(ArrayAndStringProblems.removeChars(test2,"ao"), "ttl");
		assertEquals(ArrayAndStringProblems.removeChars(test3,"er"), "tt");

	}
	@Test
	public void hasUniqueCharsTest(){
		String test1 = "";
		String test2 = "abc";
		String test3 = "abcdertfsa";

		assertTrue(ArrayAndStringProblems.hasUniqueChars(test1));
		assertTrue(ArrayAndStringProblems.hasUniqueChars(test2));
		assertFalse(ArrayAndStringProblems.hasUniqueChars(test3));
	}
	@Test
	public void rotateMatrixTest(){
		int n = 4;

		int[][] matrix = new int[n][n];

		for (int i = 0; i < n;i++){
			for(int j = 0; j <n ; j++){
				matrix[i][j]= i+j;
			}	
		}
		String matrixString = 
				"[0 1 2 3]\n"
						+ "[1 2 3 4]\n"
						+ "[2 3 4 5]\n"
						+ "[3 4 5 6]\n";

		assertEquals(ArrayAndStringProblems.printSquareMatrix(matrix),matrixString);

		ArrayAndStringProblems.rotateMatrix(matrix);

		String rotatedMatrixString = 
				"[3 2 1 0]\n"
						+ "[4 3 2 1]\n"
						+ "[5 4 3 2]\n"
						+ "[6 5 4 3]\n";

		assertEquals(ArrayAndStringProblems.printSquareMatrix(matrix),rotatedMatrixString);
	}
	@Test
	public void isPermutationTest(){
		String s1 = "banana";
		String s2 = "1";
		String s3 = "nanaba";
		String s4 = "banany";

		assertFalse(ArrayAndStringProblems.isPermutation(s1,s2));
		assertTrue(ArrayAndStringProblems.isPermutation(s1, s3));
		assertFalse(ArrayAndStringProblems.isPermutation(s1, s4));
	}

	@Test
	public void isRotationTest(){
		String s1 = "banana";
		String s2 = "nanaba";
		String s3 = "1";
		String s4 = "nanana";

		assertTrue(ArrayAndStringProblems.isRotation(s1, s2));
		assertFalse(ArrayAndStringProblems.isRotation(s1, s3));
		assertFalse(ArrayAndStringProblems.isRotation(s1, s4));	
	}

	@Test
	public void setToZeroTest(){
		int n = 3;
		int m = 4;
		int [][] matrix = new int [n][m];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				matrix[i][j] = i+j;
			}
		}
		String matrixString = 
				"[0 1 2 3]\n"
						+ "[1 2 3 4]\n"
						+ "[2 3 4 5]\n";

		assertEquals(ArrayAndStringProblems.printMatrix(matrix, n, m),matrixString);

		ArrayAndStringProblems.setToZero(matrix);

		String zeroMatrix = 
				"[0 0 0 0]\n"
						+ "[0 2 3 4]\n"
						+ "[0 3 4 5]\n";
		assertEquals(ArrayAndStringProblems.printMatrix(matrix, n, m),zeroMatrix);
	}
	@Test
	public void printFromBottomTest(){
		ArrayAndStringProblems.printFromBottom(new int [] {1,4,2,3,10,4,6});
	}
	@Test
	public void kthLargestTest(){
		int [] arr = new int [] {2,7,1,3,8};

		int [] answer = new int[]{8,7,3};

		arr = ArrayAndStringProblems.kthLargestElements(arr, 3);

		for(int i = 0; i < arr.length; i++){
			assertEquals(arr[i],answer[i]);
		}
	}
	@Test
	public void OtherProductTest(){
		int [] arr = new int []{1,2,3,4};
		int [] ret = new int []{24,12,8,6};
		arr = ArrayAndStringProblems.getOtherProducts(arr);
		for(int i = 0; i < arr.length; i++){
			assertEquals(arr[i],ret[i]);
		}
	}
}
