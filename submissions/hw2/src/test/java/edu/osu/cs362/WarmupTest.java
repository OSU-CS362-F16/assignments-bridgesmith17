package edu.osu.cs362;

import static org.junit.Assert.*;
import org.junit.Test;


public class WarmupTest  {
    @Test
    public void testFindIntegerExample() {

		int result = WarmUp.findInteger(new int[] { 1, 2, 3, 4, 5 }, 100);
		assertEquals(-1,result);

		for (int i = 1; i < 5; i++) {
			int result2 = WarmUp.findInteger(new int[] { 1, 2, 3, 4, 5 }, i + 1);
			assertEquals("findInteger(new int[]{1,2,3,4,5}," + i + ")", i,result2);
		}

    }

    @Test
    public void testFindInteger() {
	
	int result1 = WarmUp.findInteger(new int[] {1, 1, 1, 1, 1}, 1);
	assertEquals(0,result1);

    }


    @Test
    public void testLastZero() {
		
	int result1 = WarmUp.lastZero(new int[] { 0, 0, 0, 0, 0 });
	assertEquals(4,result1);
				
	int result2 = WarmUp.lastZero(new int[] { 0, 2, 3, 4, 5 });
	assertEquals(0,result2);
	
	int result3 = WarmUp.lastZero(new int[] { 1, 2, 3, 4, 5 });
	assertEquals(-1,result3);
	
    } 

    @Test
    public void testLast() {

	int result1 = WarmUp.last(new int [] {1, 2, 3, 4, 5}, 1);
	assertEquals(0,result1);
	
	
	int result2 = WarmUp.last(new int [] {1, 2, 3, 4, 5}, 6);
	assertEquals(-1,result2);
	
		
	int result3 = WarmUp.last(new int [5], 0);
	assertEquals(-1,result3);
	
	int result4 = WarmUp.last(new int[] {1, 2, 3, 4, 5}, 5);
	assertEquals(4,result4);
	
	int result5 = WarmUp.last(new int[] {1, 1, 1, 1, 1}, 1);
	assertEquals(4,result5);

    }
   
    @Test
    public void testPositive() {
		
	int result1 = WarmUp.positive(new int [] {5, 1, 2, 3, 4});
	assertEquals(5,result1);
	
	int result2 = WarmUp.positive(new int [] {-1, 0, 1, 2, -1});
	assertEquals(2,result2);

	int result3 = WarmUp.positive(new int [] {3, -1, 0, -1, 3});
	assertEquals(2,result3);

	int result4 = WarmUp.positive(new int [] {0, 0, 0, 0 ,0});
	assertEquals(0,result4);
	
    }
    
    @Test
    public void testOddOrPos(){
		
	int result1 = WarmUp.oddOrPos(new int [] {-5, -5, -3, -2, -1});
	assertEquals(5,result1);
	
	
	int result2 = WarmUp.oddOrPos(new int [] {2, 4, 6, 8, 4});
       	assertEquals(5,result2);
       
	int result3 = WarmUp.oddOrPos(new int [] {-5, -4, -3, -2, -1});
	assertEquals(3,result3);
	
	int result4 = WarmUp.oddOrPos(new int [] {-2, -2, -2, 0, -2});
	assertEquals(0,result4);
				     
    }

}
