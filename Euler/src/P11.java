import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import utils.*;

public class P11 {
	
	public static void main(String args[]){
	
	}
	//O(n)
	public static int[] twoSum(int [] arr, int value){
		if (arr.length<2) return null;
		int [] ret = new int[2];
		
		HashMap<Integer,Integer> numberMap = new HashMap<Integer,Integer>();
		
		for (int i = 0; i < arr.length; i++){
			numberMap.put(arr[i],i);//O(n)
		}
		
		for(int j = 0; j< arr.length; j++){//O(n)
			if(numberMap.containsKey(value - arr[j])){
				ret[0] = j;
				ret[1] = numberMap.get(value - arr[j]);

				return ret;
			}
		}
		
		return null;
	}
	//O(n^2)
	public static ArrayList<Integer[]> tripleSum(int[] arr, int value) {
		if (arr.length < 3) return null;
		Arrays.sort(arr);//O(nlog(n))
		ArrayList<Integer[]> ret = new ArrayList<Integer[]>();
		int head;
		int tail;
		int sum;
		for(int i = 0; i < arr.length; i++){//O(n)

			head = i+1;
			tail = arr.length-1;

			
			while(head < tail){//O(n)
				sum = arr[head] + arr[i] + arr[tail];
				if(sum == value){
					ret.add(new Integer []{arr[head],arr[i],arr[tail]});
					head++;
					tail--;
					while (head < tail && arr[head] == arr[head + 1] ) head++;
					while(head < tail && arr[tail] == arr[tail - 1]) tail--;
				}
				else if (sum < value){
					head++;
				}
				else{
					tail--;
				}
			}
			while (i < arr.length - 1 && arr[i] == arr[i+1] ) i++;
			
		}
		
		return ret;
	}
	
	public static int closestTripleSum(int[] arr, int value){
		if (arr.length < 3) return 0;
		Arrays.sort(arr);//O(nlog(n))

		int sum = 0;
		int head;
		int tail;
		int closestSum = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++){//O(n)

			head = i+1;
			tail = arr.length-1;

			
			while(head < tail){//O(n)
				sum = arr[head] + arr[i] + arr[tail];
				if (sum == value) return sum;
				if(Math.abs(sum - value) < Math.abs(closestSum - value)){
					closestSum = sum;
				}
				if(sum < value){
					head++;
				}
				else{
					tail--;
				}

			}
		}
		return closestSum;
		
	}
//	public static String sumBinary(String bin1, String bin2){
////		
//	}
	public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2){
		
		LinkedList<Integer> ret = new LinkedList<Integer>();
		
		int n1 = l1.peek() != null ? l1.poll(): 0;
		int n2 = l2.peek() !=null ? l2.poll(): 0;
		
		int carry = 0;
		
		while (l1.peek() != null|| l2.peek()!=null){
			ret.add((n1+n2+carry)%10);
			carry = (n1+n2+carry)/10;
			n1 = l1.peek() != null? l1.poll(): 0;
			n2 = l2.peek() != null? l2.poll(): 0;
		}
		
		if(carry > 0){
			ret.add(carry+n1+n2);
		}
		return ret;
			
	}
	public static ArrayList<ArrayList<String>> findAnagrams(ArrayList<String> strings){
		if (strings.size() < 2) return null;
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		
		HashMap<Integer,ArrayList<String>> anagramMap = new HashMap<Integer,ArrayList<String>>();
		int stringValue;
		
		for(String s : strings){
			if(s.length() > 0){
				stringValue = 0;
				for(int i = 0; i < s.length(); i++){
					stringValue = stringValue + s.charAt(i);
				}
				if(!anagramMap.containsKey(stringValue)){
					ArrayList<String> list =  new ArrayList<String>();
					list.add(s);
					anagramMap.put(stringValue,list);
				}
				else{
					anagramMap.get(stringValue).add(s);
				}
			}
		}
		
		for(int key : anagramMap.keySet()){
			if(anagramMap.get(key).size() > 1){
				ret.add(anagramMap.get(key));
			}
		}
		return ret;
	}
	//O(n)
	public static int bestStock(int[] arr) {
		int maxProfit = 0;
		int minValue = Integer.MAX_VALUE;
		
		for(int price : arr){
			if (price < minValue){
				minValue = price;
			}
			else if (price - minValue > maxProfit){
				maxProfit = price - minValue;
			}
		}
		
		return maxProfit;
	}
	//O(n)
	public static int bestStock2(int[] arr) {
		int maxProfit = 0;
		int lastValue = Integer.MAX_VALUE;
		
		for(int price : arr){
			if (price - lastValue > 0){
				maxProfit = maxProfit + (price - lastValue);
			}
			lastValue = price;
		}
		
		return maxProfit;
	}
//	public static int bestStock3(int[] arr){
//		int maxProfit = 0;
//		int lastValue = Integer.MAX_VALUE;
//		
//		
//		
//		return maxProfit;
//	}
	public static boolean isBalanced(BinaryTree<Integer> tree){
		return tree.isBalanced();
	}
	
	public static ArrayList<Integer> inOrderTransversal(BinaryTreeNode<Integer> binaryTreeNode){
		if (binaryTreeNode == null) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(binaryTreeNode.getLeft() != null) result.addAll(inOrderTransversal(binaryTreeNode.getLeft()));
		result.add((int)binaryTreeNode.getValue());
		if(binaryTreeNode.getRight() != null) result.addAll(inOrderTransversal(binaryTreeNode.getRight()));
		
		return result;
	}
	public static ArrayList<Integer> preOrderTransversal(BinaryTreeNode<Integer> head){
		if (head == null) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add((int)head.getValue());
		if(head.getLeft() != null) result.addAll(inOrderTransversal(head.getLeft()));
		if(head.getRight() != null) result.addAll(inOrderTransversal(head.getRight()));
		
		return result;
	}
	public static ArrayList<Integer> postOrderTransversal(BinaryTreeNode<Integer> head){
		if (head == null) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(head.getLeft() != null) result.addAll(postOrderTransversal(head.getLeft()));

		if(head.getRight() != null) result.addAll(postOrderTransversal(head.getRight()));
		result.add((int)head.getValue());

		return result;
	}
	public static ArrayList<ArrayList<Integer>> levelOrderTransversal(BinaryTreeNode<Integer> head){
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		
		queue.add(head);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> layer = new ArrayList<Integer>();
		
		int currentLevel = 1;
		int nextLevel = 0;
		int visited = 0;
		
		BinaryTreeNode<Integer> current;
		
		
		while (!queue.isEmpty()){
			current = queue.poll();
			visited++;
			layer.add((int)current.getValue());
			if(current.getLeft() != null){
				nextLevel++;
				queue.add(current.getLeft());
			}
			if(current.getRight() != null){
				nextLevel++;
				queue.add(current.getRight());
			}
			if (visited == currentLevel){
				ret.add(layer);
				layer = new ArrayList<Integer>();
				currentLevel = nextLevel;
				visited = 0;
				nextLevel = 0;
			}
			
		}
		
		return ret;
		
	}
	public static void reverseList(LinkedList<Integer> list){
		
	}
	public static long  climbLadder(int n){
		return climbLadderAux(n,new long[n+1]);
	}
	public static long climbLadderAux(int n,long[] dynamic) {
		if (n <= 0) return 0;
		if(n <= 2) return n;
		long a = (dynamic[n-1] != 0? dynamic[n-1]:climbLadderAux(n-1,dynamic));
		long b = (dynamic[n-2] != 0? dynamic[n-2]:climbLadderAux(n-2,dynamic));
		
		dynamic[n] = a+b;
		
		return dynamic[n];
	}
	public static void swap(int[] arr, int i, int j){
		int aux = arr[i];
		arr[i] = arr[j];
		arr[j] = aux;
	}
	public static void arrangeArray(int[] arr) {
		if (arr.length<2) return;
		int lastOne = 0;
		
		for (int i = 1;i < arr.length;i++){
			if(arr[i] - arr[i-1] == 1){
				lastOne = i;
			}
			else if(arr[i] - arr[i-1] == -1){
				swap(arr,lastOne,i);
				lastOne++;
			}
		}
	}
	public static void threeBuckets(int[] arr,int index) {
		int value = arr[index];
		int smallerCount = 0;

		for (int i = 0;i < arr.length;i++){
			if(arr[i] < value) smallerCount++;
		
		}
		int leftIndex = 0;
		int middleIndex = smallerCount;
		
		for(int i = 0; i<arr.length;i++){
			if (arr[i] < value){
				swap(arr,i,leftIndex++);
			}
		}
		for(int i = middleIndex;i<arr.length;i++){
			if(arr[i] == value){
				swap(arr,i,middleIndex++);
			}
		}
	}
	public static int integerDivision(int dividend, int divisor){
		int quotient = 0;
		
		while(dividend >= (divisor + divisor)){
			quotient += 2;
			dividend = dividend - (divisor + divisor);
		}
		if(dividend >= divisor){
			quotient++;
		}
		return quotient;
	}
	public static Character firstNonRepeated(String str){
		if (str == null || str.length() == 0) return null;
		if(str.length() < 2) return str.charAt(0);
		
		HashMap<Character,Integer> countMap = new HashMap<Character,Integer>();
		
		for( int i = 0; i < str.length(); i++){
			if(countMap.containsKey(str.charAt(i))){
				countMap.put(str.charAt(i), -1);
			}
			else{
				countMap.put(str.charAt(i), 1);
			}
		}
		for(int j = 0; j<str.length();j++){
			if(countMap.get(str.charAt(j)) == 1){
				return str.charAt(j);
			}
		}
		return null;
	}
	public static String removeChars(String str, String remove){
		HashSet<Character> removeChars = new HashSet<Character>();
		for(int i = 0; i < remove.length(); i++){
			removeChars.add(remove.charAt(i));
		}
		StringBuilder builder = new StringBuilder();
		for(int j = 0; j < str.length();j++){
			if(!removeChars.contains(str.charAt(j))){
				builder.append(str.charAt(j));
			}
		}
		return builder.toString();
	}
}
