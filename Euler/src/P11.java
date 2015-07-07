import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import utils.*;

public class P11 {

	
	   
		static int getLastDigit(int n){
			int last = n%10;
			while(last > 9){
				last = last%10;
			}
			return (int)last;
		}
		static void addSurrondings(int[][] arr,int i, int j){
			try{
				arr[i-1][j] = arr[i-1][j] +1;
			}catch(Exception e){
			}
			try{
				arr[i-1][j-1] = arr[i-1][j-1] +1;
			}catch(Exception e){
			}
			try{
				arr[i-1][j+1] = arr[i-1][j+1] +1;
			}catch(Exception e){
			}
			try{
				arr[i][j-1] = arr[i][j-1] +1;
			}catch(Exception e){
			}
			try{
				arr[i][j+1] = arr[i][j+1] +1;
			}catch(Exception e){
			}
			try{
				arr[i+1][j+1] = arr[i+1][j+1] +1;
			}catch(Exception e){
			}
			try{
				arr[i+1][j] = arr[i+1][j] +1;
			}catch(Exception e){
			}
			try{
				arr[i+1][j-1] = arr[i+1][j-1] +1;
			}catch(Exception e){
			}
			
		}
	    public static void mineSweeper (String[] args) throws IOException {
	        File file = new File(args[0]);
	        BufferedReader buffer = new BufferedReader(new FileReader(file));
	        String line;
            String [] values;
            String [] dimensions;
            StringBuilder builder = new StringBuilder();
	        while ((line = buffer.readLine()) != null) {
	            line = line.trim();
	            values = line.split(";");
	            builder.setLength(0);
	            dimensions = values[0].split(",");
	            int m = Integer.parseInt(dimensions[0]);
	            int n = Integer.parseInt(dimensions[1]);

	            int [][] countField = new int [m][n];
	            for(int k =0 ; k<values[1].length();k++){
	            	if(values[1].charAt(k) == '*'){
	            		addSurrondings(countField,k/n,k%n);
	            	}
	            }
	            
	            for(int i = 0; i < m;i++){
	            	for(int j = 0; j < n; j++){
	            		if(values[1].charAt(i*n + j) != '*'){
	            			builder.append(countField[i][j]);
	            		}
	            		else{
	            			builder.append("*");
	            		}
	            	}
	            }
	            System.out.println(builder.toString());
	        }
	    }
		
	    public static void digitStatistics (String[] args) throws IOException {
	        File file = new File(args[0]);
	        BufferedReader buffer = new BufferedReader(new FileReader(file));
	        String line;
	        String [] arr = new String[10];
	        String [] values;
	        int a;
	        BigInteger n;
	        StringBuilder builder = new StringBuilder();
	        
	        BigInteger ZERO = new BigInteger("0");
	        BigInteger ONE = new BigInteger("1");
	        BigInteger TWO = new BigInteger("2");

	        BigInteger FOUR = new BigInteger("4");

	        while ((line = buffer.readLine()) != null) {
	            line = line.trim();
	            values = line.split(" ");
	            builder.setLength(0);
	            a = Integer.parseInt(values[0].trim());
	            n = new BigInteger(values[1]);
	            if(a == 0 || a == 1 || a == 5 || a == 6){
	            	arr[getLastDigit(a)] = new String(n.toString());
	            }
	            else if( a == 4 || a == 9){
	            	arr[getLastDigit(a)] = new String(n.mod(TWO).compareTo(ZERO) == 0?n.divide(TWO).toString():
	            		n.divide(TWO).add(ONE).toString());
	         
	            	arr[getLastDigit(a*a)] = new String(n.divide(TWO).toString());

	            }
	            else if (a == 2 || a== 3 || a == 7 || a == 8){
	            	
	            	
	            	arr[a] = new String(n.mod(FOUR).compareTo(ZERO) == 1? n.divide(FOUR).add(ONE).toString():
	            		n.divide(FOUR).toString());
	            	arr[getLastDigit(a*a)] = new String(n.mod(FOUR).compareTo(ONE) == 1? n.divide(FOUR).add(ONE).toString():
	            		n.divide(FOUR).toString());
	            	arr[getLastDigit(a*a*a)] = new String(n.mod(FOUR).compareTo(TWO) == 1? n.divide(FOUR).add(ONE).toString():
	            		n.divide(FOUR).toString());
	            	arr[getLastDigit(a*a*a*a)] = new String(n.divide(FOUR).toString());

	            }
	            for(int i = 0; i < arr.length;i++){
	            	builder.append(i).append(": ").append(arr[i] == null?0:arr[i]).append(", ");
	            }
	            System.out.println(builder.toString().substring(0,builder.length()-2));
	            arr = new String[10];
	        }
	    }
	
	
	    public static void uniqueElements (String[] args) throws IOException {
	        File file = new File(args[0]);
	        BufferedReader buffer = new BufferedReader(new FileReader(file));
	        String line;
	        String [] values;
	        BitSet bitSet;
	        int last;
	        String delimiter = ",";
	        StringBuilder builder = new StringBuilder();
	        while ((line = buffer.readLine()) != null) {
	            line = line.trim();
	            builder.setLength(0);
	            values = line.split(delimiter);
	            last = Integer.parseInt(values[values.length-1]);
	            bitSet = new BitSet(last+1);
	            for(int i = 0; i<values.length;i++){
	            	if(!bitSet.get(Integer.parseInt(values[i]))){
	            		bitSet.set(Integer.parseInt(values[i]));
	            		builder.append(Integer.parseInt(values[i])).append(delimiter);
	            	}
	            	
	            }
	         
	            
	            System.out.println(builder.toString().substring(0,builder.length()-1));
	        }
	    }
	
	

	public static void prefixReader (String[] args) throws IOException {
	        File file = new File(args[0]);
	        BufferedReader buffer = new BufferedReader(new FileReader(file));
	        String line;
	        LinkedList<Double> numberQueue = new LinkedList<>();
	        Stack<Character> operatorStack = new Stack<>();
	        
	        while ((line = buffer.readLine()) != null) {
	            line = line.trim();
	            numberQueue.clear();
	            operatorStack.clear();
	            for(int i = 0; i< line.length(); i++){
	            	try{
	            		numberQueue.add(Double.parseDouble(String.valueOf(line.charAt(i))));
	            	}catch (Exception e){
	            		if(line.charAt(i) != ' ') operatorStack.push(line.charAt(i));
	            	}
	            }
	            double value1 = numberQueue.removeFirst();
	            
	            double value2 = numberQueue.isEmpty()?0:numberQueue.removeFirst();
	            char operator;
	            
	            while(!operatorStack.isEmpty()){
	            	operator = operatorStack.pop();
	            
	            	switch(operator){
	            	case '*':
	            		value1 = value1*value2;
	            		break;
	            	case '/':
	            		value1 = value1/value2;
	            		break;
	            	case '+':
	            		value1 = value1+value2;
	            		break;
	            	case '-':
	            		value1 = value1-value2;
	            	}
            		if(!operatorStack.isEmpty()) value2 = numberQueue.removeFirst();
	            }
	            System.out.println((int)value1);
	        }
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
	public static boolean hasUniqueChars(String str){
		if(str.length() <2) return true;
		BitSet bitset = new BitSet(256);

		for(int i = 0; i<str.length(); i++){
			if(bitset.get(str.charAt(i))) return false;
			bitset.set(str.charAt(i));
		}
		return true;
	}
	public static void removeDuplicates(LinkedList<Integer> list){
		if(list.size() <2) return;
		HashSet<Integer> seen = new HashSet<>();
		Iterator<Integer> it = list.iterator();
		seen.add(it.next());
		int currentValue;
		while(it.hasNext()){
			currentValue = it.next();
			if(seen.contains(currentValue)) it.remove();
			else seen.add(currentValue);
		}
	}
	public static BinaryTree<Integer> createBinarySearchTree(int [] sortedArr){
		if(sortedArr.length == 0) return null;
		int middle = sortedArr.length/2;
		BinaryTree<Integer> tree = new BinaryTree<>(new BinaryTreeNode<Integer>(sortedArr[middle]));
		//calculate left tree
		createBinaryTreeWorker(tree.getHead(),sortedArr,0,middle-1,false);
		createBinaryTreeWorker(tree.getHead(),sortedArr,middle+1,sortedArr.length-1,true);
		return tree;
	}

	private static void createBinaryTreeWorker(BinaryTreeNode<Integer> node, int [] arr, int start, int end,boolean isRight){
		if( start >end) return;
		int middle = (start + end)/2;
		if (isRight) node.setRight(new BinaryTreeNode<Integer>(arr[middle]));
		else node.setLeft(new BinaryTreeNode<Integer>(arr[middle]));

		createBinaryTreeWorker((isRight?node.getRight():node.getLeft()),arr,start,middle-1,false);
		createBinaryTreeWorker((isRight?node.getRight():node.getLeft()),arr,middle+1,end,true);
	}
	public static void partitionList(MyLinkedList<Integer> list, int value) {
		if (list.getSize() < 1) return;

		LinkedListNode<Integer> current = list.getHead();
		LinkedListNode<Integer> firstHalf = null;
		LinkedListNode<Integer> secondHalf = null;
		LinkedListNode<Integer> aux;

		while(current != null){
			if (current.getValue() < value){
				if(firstHalf == null) {
					firstHalf = current;
					list.setHead(firstHalf);
				}
				else{
					firstHalf.setNext(current);
					firstHalf = current;
				}
				current = current.getNext();

			}
			else{
				if(secondHalf == null){
					secondHalf = current;
					current = current.getNext();
					secondHalf.setNext(null);
				}
				else{
					aux = current.getNext();
					current.setNext(secondHalf);
					secondHalf = current;
					current = aux;
				}
				if(firstHalf == null) list.setHead(secondHalf);
			}

		}
		if(firstHalf != null) firstHalf.setNext(secondHalf);
	}
	public static void hanoiTower(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> s3){
		hanoiWorker(s1.size(),s1,s2,s3);
	}
	private static void hanoiWorker(int n, Stack<Integer> beg, Stack<Integer> aux, Stack<Integer> end){
		if(n == 1){
			end.add(beg.pop());
		}
		else{
			hanoiWorker(n-1,beg,end,aux);
			hanoiWorker(1,beg,aux,end);
			hanoiWorker(n-1,aux,beg,end);
		}
	}

	public static boolean isPermutation(String s1, String s2){
		if(s1.length() != s2.length() || s1.length() == 0 || s2.length() == 0) return false;

		int [] timesSeen = new int[256];

		for (int i = 0; i < s1.length();i++){
			timesSeen[s1.charAt(i)]++;
		}
		for(int j = 0; j < s2.length();j++){
			timesSeen[s2.charAt(j)]--;
			if(timesSeen[s2.charAt(j)] < 0) return false;
		}
		return true;	
	}
	public static void rotateMatrix(int [][] matrix){

		for(int layer = 0; layer < matrix.length/2; layer++){
			//for readability only
			int first = layer;
			int last = matrix.length - 1 - layer;
			for(int i = first; i < last ; i++){
				int offset = i - first;
				int aux = matrix[last-offset][first];

				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = matrix[first][i];
				matrix[first][i] = aux;

			}
		}

	}

	public static void setToZero(int[][] matrix){
		int n = matrix.length;
		int m = matrix[0].length;

		BitSet rowBitSet = new BitSet(n);
		BitSet columnBitSet = new BitSet(m);

		for(int i = 0; i < n; i ++){
			for(int j = 0; j< m; j++){
				if(matrix[i][j] == 0){
					rowBitSet.set(i);
					columnBitSet.set(j);

				}
			}
		}
		for(int i = 0; i < n; i ++){
			for(int j = 0; j< m; j++){
				if(rowBitSet.get(i) || columnBitSet.get(j)) matrix[i][j] = 0;
			}
		}
	}



	public static void swap2d(int[][]arr, int i0 , int j0, int i1, int j1 ){
		int aux = arr[i0][j0];
		arr[i0][j0] = arr[i1][j1];
		arr[i1][j1] = aux;
	}

	public static String printSquareMatrix(int [][] matrix){
		return printMatrix(matrix,matrix.length,matrix.length);
	}

	public static String printMatrix(int [][] matrix,int n, int m){
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < n;i++){
			buffer.append("[");
			for(int j = 0; j <m ; j++){
				buffer.append(matrix[i][j]).append(" ");
			}
			buffer.deleteCharAt(buffer.length()-1).append("]\n");
		}
		return buffer.toString();
	}

	public static boolean isSubstring(String s1, String s2){
		if(s2.length() > s1.length() || s1.length() ==0 || s2.length() ==0) return false;
		return s1.contains(s2);
	}
	public static boolean isRotation(String s1, String s2){
		if(s1.length() != s2.length() || s1.length() == 0) return false;

		return isSubstring(s1+s1,s2);

	}

	public static boolean isListPalindrome(LinkedList<Character> list){

		Iterator<Character> it = list.iterator();
		Stack<Character> stack = new Stack<>();
		int size = 0;
		while(it.hasNext()){
			stack.push(it.next());
			size++;
		}

		it = list.iterator();

		for(int i = 0; i < size/2 ; i++){
			char c1 = stack.pop();
			char c2 = it.next();
			if(c1 != c2) return false;
		}
		return true;

	}
	public static void sortStack(Stack<Integer> stack){
		if(stack.isEmpty()) return;

		Stack<Integer> auxStack = new Stack<>();
		int largest = stack.pop();
		int size = 1;

		while(!stack.isEmpty()){
			int value = stack.pop();
			if(value > largest){
				auxStack.push(largest);
				largest = value;
			}
			else{
				auxStack.push(value);
			}
			size++;
		}
		while(!auxStack.isEmpty()){
			stack.push(auxStack.pop());
		}
		auxStack.push(largest);

		largest = stack.pop();

		for(int i = 1 ; i < size-1; i++){
			while(!stack.isEmpty()){
				int value = stack.pop();
				if(value > largest){
					auxStack.push(largest);
					largest = value;
				}
				else{
					auxStack.push(value);
				}
			}
			for(int j = 0; j < size - i -1; j++){
				stack.push(auxStack.pop());
			}
			auxStack.push(largest);
			largest = stack.pop();
		}
		stack.push(largest);
		while(!auxStack.isEmpty()){
			stack.push(auxStack.pop());
		}
	}
	public static HashMap<Integer,LinkedList<Integer>> getLevelLinkedLists(BinaryTree<Integer> tree){
		
		HashMap<Integer,LinkedList<Integer>> map = new HashMap<>();
		BinaryTreeNode<Integer> head = tree.getHead();
		int level = 0;
		calculateLevelLinkedLists(head,level,map);
		
		return map;
		
	}
	private static void calculateLevelLinkedLists(BinaryTreeNode<Integer> node,
			int level, HashMap<Integer, LinkedList<Integer>> map) {

		if(map.containsKey(level)){
			map.get(level).add(node.getValue());
		}
		else{
			map.put(level, new LinkedList<Integer>());
			map.get(level).add(node.getValue());
		}
		
		if(node.getLeft() != null) calculateLevelLinkedLists(node.getLeft(),level + 1, map);
		
		if(node.getRight() != null) calculateLevelLinkedLists(node.getRight(), level + 1, map);
		
		
	}
	
	public static boolean isBST(BinaryTree<Integer> tree){
		return isBSTWorker(tree.getHead(),false) > 0? true:false;
	}
	private static int isBSTWorker(BinaryTreeNode<Integer> node,boolean isLeft) {
		if(node.isLeaf()){
			return node.getValue();
		}
		int leftMaxValue;
		int rightMinValue;
		if(node.getLeft() != null){
			leftMaxValue = isBSTWorker(node.getLeft(),true);
			if(node.getValue() <= leftMaxValue || leftMaxValue == -1) return -1;
		}
		else{
			leftMaxValue = node.getValue();
		}
		if(node.getRight() != null){
			rightMinValue = isBSTWorker(node.getRight(),false);
			if(node.getValue()>= rightMinValue || rightMinValue == -1) return -1;
		}
		else{
			rightMinValue = node.getValue();
		}
		
		if(isLeft) return rightMinValue;
		else return leftMaxValue;
		
	}
	public static int robotMove(int x0, int y0, int x1, int y1){
		return robotMove(x0,y0,x1,y1,new int[x1+1][y1+1]);
	}
	private static int robotMove(int x0, int y0, int x1, int y1, int[][] visitedArray) {
		if(x0 == x1 && y0 == y1) return 1;
		
		int right = 0;
		int left = 0;
		if(x0 < x1){
			right = visitedArray[x0+1][y0] != 0? visitedArray[x0+1][y0]:robotMove(x0+1,y0,x1,y1,visitedArray);
		}
		if(y0 < y1){
			left = visitedArray[x0][y0+1] != 0? visitedArray[x0][y0+1]:robotMove(x0,y0+1,x1,y1,visitedArray);
		}
		if(visitedArray[x0][y0] == 0) {
			visitedArray[x0][y0] = left+right;
		}
		return visitedArray[x0][y0];
	}
	
	public static int numberOfPaths(int x0, int y0, int x1, int y1){
		int xMoves = x1-x0;
		int yMoves = y1-y0;
		int [] computedFact = new int[xMoves + yMoves + 1];
		return factorial(xMoves + yMoves,computedFact)/(factorial(xMoves,computedFact) *factorial(yMoves,computedFact));
	}
	
	public static int factorial(int n,int[]  arr){
		if (n <= 1) return 1;
		if(arr[n] != 0) return arr[n];
		
		 arr[n] =  n*factorial(n-1,arr);
		 return arr[n];
	}
	public static int magicIndex(int[] arr) {
		return magicIndex(arr,0,arr.length-1);
	}
	private static int magicIndex(int[] arr, int start, int end) {
		if(start>end) return -1;
		
		int index = (end+start)/2;
		
		if(arr[index] > index){
			int left = magicIndex(arr,start,index-1);
			if (left != -1) return left;
			return magicIndex(arr,index+1,end);
				
		}
		if(arr[index] < index){
			int right = magicIndex(arr,index+1,end);
			if(right != -1) return right;
			return magicIndex(arr,start,index-1);
		}
		
		return index;
	}
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> originalSet) {
		ArrayList<ArrayList<Integer>> setOfSets = new ArrayList<>();
		ArrayList<Integer> set = new ArrayList<>();
		setOfSets.add(set);
		getSubsetsWorker(set,originalSet,setOfSets,0);
		return setOfSets;
	}
	private static void getSubsetsWorker(ArrayList<Integer> set,
			ArrayList<Integer> originalSet, ArrayList<ArrayList<Integer>> setOfSets, int lastStored) {
		
		for(int i = lastStored; i < originalSet.size(); i++){
			ArrayList<Integer> newSet = new ArrayList<>();
			newSet.addAll(0, set);
			newSet.add(originalSet.get(i));
			setOfSets.add(newSet);
			getSubsetsWorker(newSet,originalSet,setOfSets,i+1);
		}
	}
	public static Set<String> allPermutation(String str) {
		if(str == null) return null;
		HashSet<String> set = new HashSet<String>();
		if(str.equals("")){
			set.add("");
			return set;
		}
		for(int i = 0; i < str.length(); i++){
			String permString = removeCharAt(str,i);
			for(int j = 0; j< permString.length();j++){
				set.add(insertCharAt(permString,str.charAt(i),j));
			}
		}
		return set;
	}

	public static String removeCharAt(String str,int index){
		return str.substring(0,index) + str.substring(index+1);
	}
	public static String insertCharAt(String str,char ch, int index){
		return str.substring(0,index) + ch + str.substring(index);
	}
	
//	public static String printParentesis(int number){
//		if(number == 1) return "()";
//		
//	}
	
	public static int getChange(int n){
		return getChange(n,new int[]{25,10,5,1},0,new int[4][n+1]);
	}
	
	private static int getChange(int n, int[] coins, int index, int[][] seenArr) {

		if(seenArr[index][n] > 0) return seenArr[index][n];
		
		if(index>= coins.length-1) return 1;
		int coin = coins[index];
		int ways = 0;
		
		for(int i = 0; i*coin <= n;i++){
			int remaining = n - i*coin;
			ways += getChange(remaining,coins,index+1,seenArr);
		}
		seenArr[index][n] = ways;
		return seenArr[index][n];
	}
	
	
	
	
//	public static int [] mergeSort(int [] arr){
//		return mergeSortWorker(arr,0,arr.length-1);
//	}

//	public static  int [] mergeSortWorker(int [] arr, int start, int end){
//		if(start >= end) return 
//	}
//	}
}
