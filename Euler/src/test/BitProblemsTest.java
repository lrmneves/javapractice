package test;

import static org.junit.Assert.*;

import org.junit.Test;

import problems.BitProblems;
import problems.algorithms.SortingAlgorithm;

public class BitProblemsTest {

	@Test
	public void clearLastBitsTest() {
		//101 -> 100
		assertEquals(4,BitProblems.clearLastBits(5, 1));
		
		assertEquals(8, BitProblems.clearLastBits(15, 3));
	}
	
	@Test
	public void getBitTest(){
		assertEquals(true, BitProblems.getBit(5, 3));
	}
	
	@Test
	public void setBitTest(){
		assertEquals(5,BitProblems.setBit(4, 0));
		assertEquals(6,BitProblems.setBit(4, 1));
	}
	
	@Test
	public void unsetBitTest(){
		assertEquals(4,BitProblems.unsetBit(5, 0));
	}
	
	@Test
	public void clearFirstBitsTest(){
		assertEquals(3, BitProblems.clearFirstBits(15, 2));
		assertEquals(7, BitProblems.clearFirstBits(15, 3));

	}
	
	@Test
	public void setBitToValueTest(){
		assertEquals(3, BitProblems.setBitToValue(7, 2, 0));
		assertEquals(16, BitProblems.setBitToValue(0, 4, 1));

	}
	
	@Test
	public void insertMToNTest(){
		assertEquals(BitProblems.insertMToN(16, 3, 2, 1),28);
		assertEquals(BitProblems.insertMToN(16, 3, 1, 0),22);

	}
	@Test
	public void swapBitsTest(){
		assertEquals(BitProblems.swapBits(5),10);
	}
	@Test
	public void countFlipTest(){
		assertEquals(BitProblems.countFlipBits(29, 15),2);
	}
	@Test
	public void patternTest(){
		System.out.println(BitProblems.patternCreator(6, 1, 1));
	}
	@Test
	public void countOnesTest(){
		long startTime = System.nanoTime();

		assertEquals(BitProblems.countOnes(5),2);
		assertEquals(BitProblems.countOnes(7),3);
		assertEquals(BitProblems.countOnes(15),4);
		assertEquals(BitProblems.countOnes((int)Math.pow(2, 30)),1);
		long endTime = System.nanoTime();
		
		System.out.println("Count ones took " + String.valueOf(endTime-startTime));
		
		startTime = System.nanoTime();

		assertEquals(BitProblems.countOnesFaster(5),2);
		assertEquals(BitProblems.countOnesFaster(7),3);
		assertEquals(BitProblems.countOnesFaster(15),4);
		assertEquals(BitProblems.countOnesFaster((int)Math.pow(2, 30)),1);
		endTime = System.nanoTime();

		System.out.println("Fast Count ones took " + String.valueOf(endTime-startTime));

		
	}
	@Test
	public void swapBitsIndexTest(){
		assertEquals(BitProblems.swapBitsIndex(5, 1, 2),3);
	}
	@Test
	public void isPowerOfTwo(){
		assertTrue(BitProblems.isPowerOfTwo(2));
		assertTrue(BitProblems.isPowerOfTwo(16));
		assertTrue(BitProblems.isPowerOfTwo(1024));
		assertTrue(BitProblems.isPowerOfTwo(256));
		assertFalse(BitProblems.isPowerOfTwo(258));
		assertFalse(BitProblems.isPowerOfTwo(1000));


	}
	
}
