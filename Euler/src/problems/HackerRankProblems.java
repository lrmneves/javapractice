package problems;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HackerRankProblems {

	public static void angryProfessor(String[] args) {
		Scanner in = new Scanner(System.in);

		while(in.hasNext()){
			String [] parameters = in.nextLine().split(" ");
			int k = Integer.parseInt(parameters[1]);
			String [] students = in.nextLine().split(" ");
			int studentsOnTime = 0;
			for (String s : students){

				if(Integer.parseInt(s) <= 0) studentsOnTime++;

				if(studentsOnTime >= k) {

					System.out.println("NO");
					break;
				}
			}
			if(studentsOnTime < k)  System.out.println("YES");

		}
	}

	static PriorityQueue<Double> maxHeap;
	static PriorityQueue<Double> minHeap;

	public static double getMedian(double v, double median){
		if(v > median) minHeap.add(v);
		else maxHeap.add(v);
		while (minHeap.size() < maxHeap.size()){
			minHeap.add(maxHeap.poll());
		}
		while( maxHeap.size() < minHeap.size() ) {

			if(maxHeap.peek() > minHeap.peek()) minHeap.add(maxHeap.poll());
			maxHeap.add(minHeap.poll());
		}
		if(maxHeap.size()>minHeap.size()) median = maxHeap.peek();
		else median = (minHeap.peek() + maxHeap.peek())/2;

		return median;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		maxHeap = new PriorityQueue<>(n, Collections.reverseOrder());
		minHeap = new PriorityQueue<>(n);

		double median = in.nextDouble();
		System.out.println(median);
		double v;
		if( n >= 2) {
			v = in.nextDouble();
			if(v > median) {
				minHeap.add(v);
				maxHeap.add(median);
			}
			else {
				minHeap.add(median);
				maxHeap.add(v);
			}

			median = (minHeap.peek() + maxHeap.peek())/2;
			System.out.println(median);

			int count = 3;
			while(count <= n){
				if(count != n) v = in.nextDouble();
				else{
					if(in.hasNextDouble()){
						v = in.nextDouble();
						
					}
				}

				median = getMedian(v,median);
				System.out.println(median);
				count++;

			}
			

		}
	}
}
