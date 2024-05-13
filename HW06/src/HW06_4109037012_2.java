
public class HW06_4109037012_2 extends MedianOfArrays {

	public static void main(String[] args) {
		HW06_4109037012_2 test = new HW06_4109037012_2();
		int[][] arrays = {{1,3,10}, {-1,5,7}, {-2,5,12}};
		// Sorted: [-2, -1, 1, 3, 5, 5, 7, 10, 12], Median: 5
//		int[][] arrays = {{3}, {-1,5}, {-2,5,12}};
		
		long startTime = System.currentTimeMillis();
		System.out.println("Result: " + test.find_median(arrays));
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime) + "ms");
	}

	@Override
	public double find_median(int[][] arrays) {
		int length = countTotalNums(arrays);
		
		if (length % 2 == 1)
			return (double) findKth(arrays, length/2 + 1);
		else {
			double left = (double) findKth(arrays, length/2);
			double right = (double) findKth(arrays, length/2 + 1);
			return (left + right) * 0.5;
		}
			
	}	// end for find_median()
	
	private int countTotalNums(int[][] array) {
		int total = 0;
		
		for (int i = 0; i < array.length; i++)
			total += array[i].length;
		
		return total;
	}	// end for countTotalNums()
	
	private int findKth(int[][] array, int k) {
		int start = Integer.MIN_VALUE, end = Integer.MAX_VALUE, mid;	// value boundary
		
		while (start+1 < end) {
			mid = (start + end) / 2;
			
			if (getGreaterNums(array, mid) >= k) 
				start = mid;
			else 
				end = mid;
		}
		
		if (getGreaterNums(array, end) >= k)
			return end;
		
		return start;
	}	// end for findKth()
	
	private int getGreaterNums(int[][] array, int target) {
		int count = 0;
		for (int i = 0; i < array.length; i++)
			count += getGreaterNumsInArray(array[i], target);
		
		return count;
	}	// end for getGreaterNums()
	
	private int getGreaterNumsInArray(int[] array, int target) {
		int start = 0, end = array.length-1, mid;
		target = 5;
		for (int i = 0;i < array.length; i++)
			System.out.print(array[i]+" ");
		System.out.println(" target = "+target);
		while (start+1 < end) {
			mid = (start + end)/2;
			if (array[mid] >= target)
				end = mid;
			else
				start = mid;
		}
		
		if (array[start] >= target) 
		{
			int test = array.length - start;
			System.out.println("test = "+test);
			return test;
		}
			
		
		if (array[end] >= target) 
		{
			int test = array.length - end;
			System.out.println("test = "+test);
			return test;
		}
			
		
		return 0;
	}	// end for getGreaterNumsInArray()
}