package problems;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeEvalChallenge {

	static class Bridge implements Comparable<Bridge>{

		int id;
		double x0;
		double y0;
		double x1;
		double y1;
		HashSet<Bridge> intersectionSet;

		public Bridge(String id,double x0,double y0,double x1, double y1) {
			this.x0 = x0;
			this.y0 = y0;
			this.x1 = x1;
			this.y1 = y1;
			this.id = Integer.parseInt(id);
			intersectionSet = new HashSet<>();
		}

		public int calculateOrientation(double x0,double y0, double x1, double y1, double x2,double y2)
		{

			double val = (y1 - y0) * (x2- x1) -
					(x1 - x0) * (y2 -y1);

			if (equalsDouble(val,0)) return 0;  // colinear

			return (val > 0)? 1: 2; // clock or counterclock wise
		}

		public boolean intersect(Bridge otherBridge){

			int o1 = calculateOrientation(this.x0,this.y0, this.x1,this.y1, otherBridge.x0,otherBridge.y0);
			int o2 = calculateOrientation(this.x0,this.y0, this.x1,this.y1, otherBridge.x1,otherBridge.y1);
			int o3 = calculateOrientation(otherBridge.x0,otherBridge.y0, otherBridge.x1,otherBridge.y1, this.x0,this.y0);
			int o4 = calculateOrientation(otherBridge.x0,otherBridge.y0, otherBridge.x1,otherBridge.y1, this.x1,this.y1);

			if (o1 != o2 && o3 != o4)
				return true;

			return false;
		}

		public boolean saveIntersect(Bridge otherBridge){

			if(!intersectionSet.contains(otherBridge) && intersect(otherBridge)){
				otherBridge.saveIntersect(this,true);
				return intersectionSet.add(otherBridge);
			}
			return true;
		}
		public boolean saveIntersect(Bridge otherBridge,boolean knownIntersection){
			if(knownIntersection == false){
				return saveIntersect(otherBridge);
			}
			return intersectionSet.add(otherBridge);
		}
		public int getIntersectSize(){
			return intersectionSet.size();
		}
		public boolean removeIntersection(Bridge otherBridge){
			return intersectionSet.remove(otherBridge);
		}

		@Override
		public int compareTo(Bridge otherBridge) {

			if(this.getIntersectSize() == otherBridge.getIntersectSize()){
				return this.id - otherBridge.id;
			}

			return this.getIntersectSize() - otherBridge.getIntersectSize();
		}

	}

	@SuppressWarnings("resource")
	public static void buildBridges (String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		String[]  values;

		Pattern r = Pattern.compile("\\-*\\d+\\.\\d+"); 
		Matcher m;
		ArrayList<CodeEvalChallenge.Bridge> bridges = new ArrayList<>();
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			values = line.split(":");
			m = r.matcher(values[1]);
			bridges.add(CodeEvalChallenge.parseEntryToBridge(values[0],m));
		}
		for(int i = 0; i < bridges.size()-1;i++){
			for(int j = i+1; j<bridges.size();j++){
				bridges.get(i).saveIntersect(bridges.get(j));
			}
		}
		Collections.sort(bridges);

		CodeEvalChallenge.Bridge b;
		while(bridges.get(bridges.size()-1).getIntersectSize() > 0){
			b = bridges.remove(bridges.size()-1);
			for(int i = bridges.size() -1 ; i >= 0 ; i--){
				if(bridges.get(i).getIntersectSize() == 0) break;
				bridges.get(i).removeIntersection(b);
			}
			Collections.sort(bridges);
		}
		for (CodeEvalChallenge.Bridge br : bridges){

			System.out.println(br.id);
		}

	}

	static boolean equalsDouble(double a, double b){
		double value = a - b;
		double epsilon = 1E-5;

		if(Math.abs(value) < epsilon){
			return true;
		}
		return false;
	}

	static CodeEvalChallenge.Bridge parseEntryToBridge(String id,Matcher m){
		m.find();
		double x0 = Double.parseDouble(m.group());
		m.find();
		double y0 = Double.parseDouble(m.group());
		m.find();
		double x1 = Double.parseDouble(m.group());
		m.find();
		double y1 = Double.parseDouble(m.group());

		return new CodeEvalChallenge.Bridge(id,x0,y0,x1,y1);
	}

	public static int getLastDigit(int n){
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
	@SuppressWarnings("resource")
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
	@SuppressWarnings("resource")
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
	@SuppressWarnings("resource")
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
	@SuppressWarnings("resource")
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

}
