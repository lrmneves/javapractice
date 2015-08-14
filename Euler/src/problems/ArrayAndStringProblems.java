package problems;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class ArrayAndStringProblems {

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

	public static int [] getOtherProducts(int[] X){
		int[] R = new int[X.length];

		int p = 1;
		for(int i = 0; i < X.length;i++){
			R[i] = p;
			p*=X[i];
		}
		p=1;
		for(int j = X.length-1;j>=0;j--){
			R[j]*=p;
			p*=X[j];
		}

		return R;
	}

	public static int [] kthLargestElements(int [] arr,int k ){
		int [] ret = new int[k];

		int n = arr.length;
		boolean swapped = true;
		int i = 0;
		while(!swapped || i < k){
			swapped = false;
			for(int j = 1; j < n; j ++)
			{
				if(arr[j -1] > arr[j]) ArrayAndStringProblems.swap(arr,j-1,j);
				swapped = true;
			}
			i++;
		}

		for(int w = 0; w < ret.length;w++){
			ret[w] = arr[arr.length- 1 - w];
		}

		return ret;
	}

	public static String printFromBottom(int [] arr){
		
		int max = ArrayAndStringProblems.getMax(arr);
		StringBuilder[] builderArr = new StringBuilder[max];

		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < builderArr.length; j++){
				int blankCount = max - arr[i];
				if(builderArr[j] == null) builderArr[j] = new StringBuilder();
				if(j < blankCount) builderArr[j].append(" ");
				else builderArr[j].append("#");
			}

		}
		StringBuilder lastBuilder = new StringBuilder();
		for(StringBuilder builder : builderArr){
			lastBuilder.append(builder.toString());
		}
		return lastBuilder.toString();
	}

	public static int getMax(int[] arr){
		int max = Integer.MIN_VALUE;
		for(int i : arr){
			if ( i > max) max = i;
		}
		return max;
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
		return ArrayAndStringProblems.printMatrix(matrix,matrix.length,matrix.length);
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

	public static boolean hasUniqueChars(String str){
		if(str.length() <2) return true;
		BitSet bitset = new BitSet(256);

		for(int i = 0; i<str.length(); i++){
			if(bitset.get(str.charAt(i))) return false;
			bitset.set(str.charAt(i));
		}
		return true;
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

	public static boolean isRotation(String s1, String s2){
		if(s1.length() != s2.length() || s1.length() == 0) return false;

		return ArrayAndStringProblems.isSubstring(s1+s1,s2);

	}

	public static boolean isSubstring(String s1, String s2){
		if(s2.length() > s1.length() || s1.length() ==0 || s2.length() ==0) return false;
		return s1.contains(s2);
	}
	public static int getDepth(int [] arr, int k){
		if(arr == null || arr.length == 0 || k < 0 || k > arr.length ) return 0;
		int count = 1;
		while(arr[k] > 0 && arr[k] < arr.length){
			k = arr[k];
			count++;
			if(count > arr.length) return Integer.MAX_VALUE;
		}
		return count;
	}

	public static String reverseWords(String str){
		if(str == null || str.length() <2) return str;
		StringBuilder builder = new StringBuilder();
		int lastNonCharIndex = str.length();
		for(int i = str.length()-1 ; i >= 0; i--){

			if(str.charAt(i) == ' '){
				for(int j = i+1; j < lastNonCharIndex ; j++){
					builder.append(str.charAt(j));
				}
				builder.append(str.charAt(i));
				lastNonCharIndex = i;
			}
		}
		if(lastNonCharIndex > 0){
			for(int j = 0; j < lastNonCharIndex; j++){
				builder.append(str.charAt(j));
			}
		}
		return builder.toString();

	}
	public static void rotateArray(int [] arr, int k){
		if (arr == null || arr.length<2) return;

		int lastValue = arr[0];
		int nextValue;
		int index = 0;

		for(int i = 0; i < arr.length ; i++ ){
			index = (index + k)%(arr.length);
			nextValue = arr[index];
			arr[index] = lastValue;
			lastValue = nextValue;
			if(index == 0) {
				index++;
				lastValue = arr[index];
			}

		}
	}
	public static void reverseArray(int [] arr,int start,int end){

		while (end > start){
			swap(arr,end--,start++);
		}
	}
	public static int [] nextPermutation(int[] arr){
		if(arr == null || arr.length <2) return arr;
		int startIndex = arr.length-2;
		while(startIndex>=0 && arr[startIndex] >= arr[startIndex+1]) startIndex--;
		if(startIndex == -1) return new int [0];

		int swapIndex = startIndex;
		for(int i = startIndex+1; i < arr.length; i++){
			if(arr[i] > arr[startIndex]) swapIndex = i;
			else break;
		}
		int [] nextPerm = arr.clone();
		swap(nextPerm,startIndex,swapIndex);

		reverseArray(nextPerm,startIndex+1, nextPerm.length-1);

		return nextPerm;


	}
	public static int stringToInt(String s){
		HashMap<Character,Integer> charToIntMap = new HashMap<>();
		charToIntMap.put('0', 0);
		charToIntMap.put('1', 1);
		charToIntMap.put('2', 2);
		charToIntMap.put('3', 3);
		charToIntMap.put('4', 4);
		charToIntMap.put('5', 5);
		charToIntMap.put('6', 6);
		charToIntMap.put('7', 7);
		charToIntMap.put('8', 8);
		charToIntMap.put('9', 9);

		int unitCount = 1;
		int ret = 0;

		for(int i = s.length() -1; i>=0;i--){
			ret += charToIntMap.get(s.charAt(i))*unitCount;
			unitCount*=10;
		}

		return ret;
	}

	public static String intToString( int number){
		StringBuilder builder = new StringBuilder();
		while(number > 0){
			builder.append(number%10);
			number/=10;
		}
		return builder.reverse().toString();
	}
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size() < 1) return 0;
		int steps = triangle.size() -1;
		for(int i = 0; i < steps;i++){
			for(int j = 0; j < triangle.get(i).size();j++){
				if(j == 0) {
					triangle.get(i+1).set(j,triangle.get(i+1).get(j) + triangle.get(i).get(j));
					if(i == 0) triangle.get(i+1).set(j+1,triangle.get(i+1).get(j+1) + triangle.get(i).get(j));
					else{
						triangle.get(i+1).set(j+1,Math.min(triangle.get(i+1).get(j+1) + triangle.get(i).get(j),triangle.get(i+1).get(j+1) + triangle.get(i).get(j+1)));
					}
				}
				else if ( j == triangle.get(i).size() - 1) {
					triangle.get(i+1).set(j+1,triangle.get(i+1).get(j+1) + triangle.get(i).get(j));
				}else{
					triangle.get(i+1).set(j+1,Math.min(triangle.get(i+1).get(j+1) + triangle.get(i).get(j),triangle.get(i+1).get(j+1) + triangle.get(i).get(j+1)));
				}
			}
		}
		int minSum = Integer.MAX_VALUE;

		for(int k = 0; k < triangle.get(steps).size();k++){
			if(triangle.get(steps).get(k) < minSum) 
				minSum = triangle.get(steps).get(k);
		}
		return minSum;
	}
	public static boolean isPalindrome(int x){
		int div = 1;
		while(x/Math.pow(10,div) >= 10) div++;


		return true;
	}
	public static int longestConsecutive(int[] nums) {
		if(nums != null && nums.length < 1) return 0;
		int count = 0;
		HashSet<Integer> set = new HashSet<>();
		
		for(int n : nums){
			set.add(n);
		}
		
		for(int n : nums){
			int left = n -1;
			int right = n + 1;
			if(!set.contains(n)) continue;
			while(set.contains(left)){
				set.remove(left);
				left--;
			}
			while(set.contains(right)){
				set.remove(right);
				right++;
			}
			if(count < (right - left -1)) count = (right - left -1);
			set.remove(n);
		}
		
		return count;

	}
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
		if(a == null || a.size() == 0) return a;
		int start = 0;
		int end = 0;
		int maxStart = start;
		int maxEnd = end;
		BigInteger sum = BigInteger.ZERO;
		BigInteger maxSum = sum;
		boolean wasNeg = false;
		for(int i = 0; i < a.size(); i++){
			if(a.get(i) >= 0) {
				if(wasNeg){
					start = i;
					end = i+1;
					wasNeg = false;
				}else{
					end++;
				} 
				sum = sum.add(BigInteger.valueOf(a.get(i)));
			}
			else if(a.get(i) < 0){
				if(wasNeg) continue;
				if(maxSum.compareTo(sum) == -1) {
					maxSum = sum;
					maxEnd = end;
					maxStart = start;
				}
				else if(maxSum == sum){
					if(maxEnd - maxStart < end - start){
						maxEnd = end;
						maxStart = start;
					}
				}
				wasNeg = true;
				sum = BigInteger.ZERO;
			}
		}
		if(maxStart == maxEnd && maxStart == 0){
			maxStart = start;
			maxEnd = end;
		}
		if(maxSum.compareTo(sum) == -1) {
			maxEnd = end;
			maxStart = start;
		}
		return new ArrayList<Integer>(a.subList(maxStart,maxEnd));
	}
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() < 1) return 0;
        
        HashMap<Character,Integer> uniqueMap = new HashMap<>();
        String ans = "";
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            if(uniqueMap.containsKey(s.charAt(i))) {
                uniqueMap.put(s.charAt(i),uniqueMap.get(s.charAt(i)) +1);
                end++;
            }
            else{
                uniqueMap.put(s.charAt(i),1);
                if(uniqueMap.size() > 2){
                    if(end - start > ans.length()) ans = s.substring(start,end);
                    while (uniqueMap.size() > 2 && start <= end){
                        if(uniqueMap.get(s.charAt(start)) == 1) uniqueMap.remove(s.charAt(start));
                        else{
                             uniqueMap.put(s.charAt(start),uniqueMap.get(s.charAt(start)) - 1);
                        }
                        start++;
                    }
                }
                end++;
            }
        } 
        if(end - start > ans.length()) ans = s.substring(start,end);
        
        return ans.length();
    }
	public static int binarySearch(int[] nums, int value){
		if(nums == null || nums.length < 1) return -1;
		int start = 0;
		int end = nums.length -1;
		int mid = (end + start)/2;
		
		while (start < end){
			if(nums[mid] < value){
				start = mid +1;
			}else if(nums[mid] > value){
				end = mid - 1;
			}else{
				return mid;
			}
			mid = (end+start)/2;
		}
		return -1;
	}
}
