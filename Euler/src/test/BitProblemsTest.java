package test;

import static org.junit.Assert.*;

import org.junit.Test;

import problems.BitProblems;

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
	
}
