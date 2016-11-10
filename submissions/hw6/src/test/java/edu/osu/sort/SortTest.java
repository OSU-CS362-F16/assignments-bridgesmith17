package edu.osu.sort;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class SortTest  {



    private static List<Integer> randomIntegerArray(int n){
	return null;
    }
    
@Test
    public void randomTestOracle() {    

	Random r = new Random();

	int n_runs = 100; //generates 100 random tests. 
	for(int i=0;i < n_runs; i++){
	    

	int size = r.nextInt(1000);
	    // Generate a random array of size random size between 0 and 1000;
	    List<Integer> original = new ArrayList<Integer>(size);
		for(int j= 0; j < size; j++)
		{
		
			int num = r.nextInt(10);
		
			original.add(num);

		
		}
	    
	// Copy the sorted array before sorting it 
	    List<Integer> sorted = original;

	    // Sort it
	   Sort.sort(sorted);

	    // Test the result 
	   assertTrue(SortOracle.isSorted(original,sorted));
  

 	
	 }
}
    @Test
    public void randomTestAssertion() {    
	


	Random r = new Random();

	int n_runs = 100; //generates 100 random tests. 
	for(int i=0;i<n_runs;i++){
	    
	int size = r.nextInt(1000);

	    // Generate a random array of size random size between 0 and 1000;
	    List<Integer> original = new ArrayList<Integer>(size);
		for(int j= 0; j < size; j++)
		{
		
			int num = r.nextInt(10);
		
			original.add(num);

		
		}
	    
	// Copy the sorted array before sorting it 
	    List<Integer> sorted = original;
	    // Sort it
	    Sort.sort(sorted);

	    // assert all numbers are present in sorted list
	    
		int oSize = original.size();
	 int sSize = sorted.size();
	    assertEquals(oSize,sSize);

	//assert if element 8 exits it is less than 10. 
	
	if(sSize > 10)
	{
	assertTrue( sorted.get(8) <= sorted.get(10));
	}
	

	//assert that last item is greater than first element
	if(sSize > 0)
	{
	assertTrue(sorted.get(sSize-1) >= (sorted.get(0)));
	}

	//assert that the second item is greater than the first

	if (sSize > 1)
	{
	assertTrue(sorted.get(1) >= (sorted.get(0)));
	}
	
	//assert that the second to last item is less than the last item;
	if(sSize > 1)
	{
	assertTrue(sorted.get(sSize-1) >= (sorted.get(sSize-2)));
	}
   }

}
}

