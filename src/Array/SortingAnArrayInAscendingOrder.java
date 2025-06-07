package Array;

import java.util.Arrays;

public class SortingAnArrayInAscendingOrder 
{

	public static void main(String[] args) 
	{
		int[] i = {12,34,76,35,2,51};
		
		//now sorting in ascending order
		Arrays.sort(i);
		for(Integer it:i)
		{
			System.out.println(it);
		}

	}

}
