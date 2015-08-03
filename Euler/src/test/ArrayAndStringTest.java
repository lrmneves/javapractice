package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

		assertArrayEquals(arr,answer);

	}

	@Test
	public void threeBucketsTest(){
		int [] arr = new int[]{0,1,1,2,0,1,2,3,5,0,0};
		ArrayAndStringProblems.threeBuckets(arr,1);
		int [] answer = new int [] {0,0,0,0,1,1,1,3,5,2,2};
		assertArrayEquals(arr,answer);

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
		String ans =  "    #  "
					+ "    #  "
					+ "    #  "
					+ "    #  "
					+ "    # #"
					+ "    # #"
					+ " #  ###"
					+ " # ####"
					+ " ######"
					+ "#######";
		assertEquals(ArrayAndStringProblems.printFromBottom(new int [] {1,4,2,3,10,4,6}),ans);
	}
	@Test
	public void kthLargestTest(){
		int [] arr = new int [] {2,7,1,3,8};

		int [] answer = new int[]{8,7,3};

		arr = ArrayAndStringProblems.kthLargestElements(arr, 3);

		assertArrayEquals(arr,answer);

	}
	@Test
	public void OtherProductTest(){
		int [] arr = new int []{1,2,3,4};
		int [] ret = new int []{24,12,8,6};
		arr = ArrayAndStringProblems.getOtherProducts(arr);
		
		assertArrayEquals(arr,ret);
		
	}
	@Test
	public void getDepthTest(){
		int [] arr = new int [] {1,1,3,2,8,-1,4};
		
		int k1 = 1;
		int k2 = 0;
		int k3 = 2;
		int k4 = 6;
		
		assertEquals(ArrayAndStringProblems.getDepth(arr,k1),Integer.MAX_VALUE);
		assertEquals(ArrayAndStringProblems.getDepth(arr,k2),Integer.MAX_VALUE);
		assertEquals(ArrayAndStringProblems.getDepth(arr,k3),Integer.MAX_VALUE);
		assertEquals(ArrayAndStringProblems.getDepth(arr,k4),2);
	}
	
	@Test
	public void reverseWordsTest(){
		
		String str1 = "a b";
		String str2 = " ba na na ";
		String str3 = "abc ";
		String str4 = " ";
		
		assertEquals(ArrayAndStringProblems.reverseWords(str1), "b a");
		assertEquals(ArrayAndStringProblems.reverseWords(str2), " na na ba ");
		assertEquals(ArrayAndStringProblems.reverseWords(str3), " abc");
		assertEquals(ArrayAndStringProblems.reverseWords(str4), " ");

	}
	@Test
	public void rotateArrayTest(){
		int [] arr = new int [] {0,1,2,3,4};
		int [] ans = new int [] {3,4,0,1,2};
		ArrayAndStringProblems.rotateArray(arr, 2);
		
		assertArrayEquals(arr,ans);

	}
	
	@Test
	public void nextPermutationTest(){
		int [] perm1 = new int[]{0};
		int [] perm2 = new int[] {1,0,2,4,3};
		int [] perm3 = new int[] {0,4,3,2,1};
		int [] perm4 = new int[] {4,3,2,1};
		
		assertArrayEquals(ArrayAndStringProblems.nextPermutation(perm1),new int[]{0});
		assertArrayEquals(ArrayAndStringProblems.nextPermutation(perm2),new int[]{1,0,3,2,4});
		assertArrayEquals(ArrayAndStringProblems.nextPermutation(perm3),new int[]{1,0,2,3,4});
		assertArrayEquals(ArrayAndStringProblems.nextPermutation(perm4),new int[0]);
	}
	
	@Test
	public void stringToIntTest(){
		String s1 = "123";
		String s2 = "1001";
		String s3 = "1250";
		
		int integer1 = 123;
		int integer2 = 1001;
		int integer3 = 1250;
		
		assertEquals(integer1,ArrayAndStringProblems.stringToInt(s1));
		assertEquals(integer2,ArrayAndStringProblems.stringToInt(s2));
		assertEquals(integer3,ArrayAndStringProblems.stringToInt(s3));
		
		assertEquals(ArrayAndStringProblems.intToString(integer1),s1);
		assertEquals(ArrayAndStringProblems.intToString(integer2),s2);
		assertEquals(ArrayAndStringProblems.intToString(integer3),s3);
	}
	@Test
	public void minSumTest(){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//[[2],[3,4],[6,5,7],[4,1,8,3]]
		List<Integer> level1 = new ArrayList<Integer>();
		level1.add(2);
		List<Integer> level2 = new ArrayList<Integer>();
		level2.add(3); level2.add(4);
		List<Integer> level3 = new ArrayList<Integer>();
		level3.add(6);level3.add(5);level3.add(7);
		List<Integer> level4 = new ArrayList<Integer>();
		level4.add(4);level4.add(1);level4.add(8);level4.add(3);
		
		list.add(level1); list.add(level2);list.add(level3);list.add(level4);
		
		assertEquals(ArrayAndStringProblems.minimumTotal(list),11);

	}
	@Test
	public void consecutiveTest(){
		int [] arr = new int []{100,4,200,1,3,2};
		assertEquals(ArrayAndStringProblems.longestConsecutive(arr),4);

	}
}
