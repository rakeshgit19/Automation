package Array;

import java.util.Arrays;
import java.util.Collections;

public class SortingAnArrayInDescendingOrder 
{

	public static void main(String[] args) 
	{
		Integer [] i = {-1,23,344,56,87};
		Arrays.sort(i,Collections.reverseOrder());
		
		for(Integer in:i)
		{
			System.out.println(in);
		}

	}

}
