
//better and quickSort
public class HW02_4109037012_5 extends FourSum {
	
	public static void main(String[] args) {
		
		HW02_4109037012_5 test = new HW02_4109037012_5();		
		int[] A = {-1 , 1 ,1, 2 , -4, 4 , 8 , -3};
		Stopwatch stopwatch = new Stopwatch();
		System.out.println("4Sum is zero: "+test.F_sum(A));
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);

	}
	
	@Override
	public int F_sum(int[] A) {
		int cnt = 0 , len = A.length;
		this.quickSort(A, 0, A.length-1); // quickSort: O(NlogN)
		
		for ( int i = 0 ; i < len-3 && A[i] < 0 ; i++ ) {
			for ( int j = i+1 ; j < len - 2 && A[i] + A[j] < 0 ; j++ ){
				
				int left = j+1 , right = len-1;
				while (left < right) {
					int fSum = A[i] + A[j] + A[left] + A[right];
					if (fSum == 0)
					{
						cnt++;
						left++;
						right--;
					}
					else if (fSum < 0) left++;
					else right--;
				}
			}
		}
		return cnt;
	}
	
	public void quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);

	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	private int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
}
