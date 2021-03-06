package problems;

public class BitProblems {

	public static int clearLastBits(int number, int bits){
		return (number & (~0 << bits));
	}
	public static boolean getBit(int number, int bit){
		return ((number & (1 << bit)) == 0);
	}
	
	public static int setBit(int number, int bit){
		return  number | (1 << bit);
	}
	
	public static int unsetBit(int number, int bit){
		return number & ~(1 << bit);
	}
	
	public static int clearFirstBits(int number, int bits){
		int mask = (1<<bits) - 1; // all bits before are set to 1;
		return number & mask;
	}
	
	public static int setBitToValue(int number, int i, int value){
		int mask =  ~(1 << i);
		
		return (number & mask) | value << i;
	}
	
	public static int insertMToN(int M, int N, int i , int j){
		int mask = ~(((1<<j+1) // shifts 1 j+1 to the left
				-1) // turns j through 0 a mask of 1s and all bits left to j to be zero
				& (~0 << i));//ands with 1s shifted i to left, so all zeros right to i
		//mask creates a mask like 0011100 where 1s go from j to i and negates it
		// so it becomes 1100011
		return mask & M | N << i; //by having a and with mask, all bits from j to i are 
		//set to zero. When having an or of N shifted i times to the left, we insert N to M
	}
	public static int swapBits(int number){
		int maskOdd = (number&0xaaaaaaaa) >> 1;// aaaaaaaa is 10101010...10, mask for odd bits
		int maskEven = (number&0x55555555) << 1;//55555555 is 01010101...01, mask for even bits
		return maskOdd | maskEven;
	}
	public static int countFlipBits(int a, int b){
		int flipNumber = a^b;
		int count = 0;
		while(flipNumber != 0){
//			if((flipNumber & 1) == 1) count++;
//			flipNumber >>=1;
			flipNumber&=(flipNumber-1);
			count++;
		/*
		 *Other approach was to clear the least significant bit at every iteration
		 * Instead of flipNumber >>= 1, we would do flipNumber&=(flipNumber -1),
		 * which would clear the least significant bit
		 */
		}
		return count;
	}
	
	public static int patternCreator(int n, int p, int q){
		int revPattern = ((1<< q)-1)<<p; 
		int ret = ~0^((1<<p+q) - 1);
		
		for(int i = 0; i < n; i+= p+q){
			ret |= revPattern;

			revPattern<<=p+q;
			revPattern |= ((1<<p+q) -1); 
		}
		return ~ret;
	}
	public static int countOnes(int number){
		int count = 0;
		while (number!=0){
			if((number & 1) == 1) count++;
			number>>=1;
		}
		return count;
	}
	public static int countOnesFaster(int number){
		int count = 0;
		for(count = 0; count < number; count++){
			number&=(number-1);
		}
		return count;
	}
	public static int swapBitsIndex(int number,int i, int j){
		int iAux =  (1<<i) & number;
		int jAux = (1<<j) &number;
		int iMask = ~(1<<i);
		int jMask = ~(1<<j);
		number &= iMask;
		number &= jMask;
		if(i - j > 0){
			number |= (iAux>>(i-j));
			number |= (jAux<<(i-j));
		}else{
			number |= (jAux>>(j-i));
			number |= (iAux<<(j-i));
		}
		return number;
	}
	public static boolean isPowerOfTwo(int x) {
		return (x!= 0) && (x&(x-1)) == 0;
//        return (x&(-x)) == x; //pega o bit menos significativo
    }

}

