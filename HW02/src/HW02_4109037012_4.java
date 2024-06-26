
public class HW02_4109037012_4 extends FourSum {
	
	public static void main(String[] args) {
		
		HW02_4109037012_4 test = new HW02_4109037012_4();		
		int[] A = {-1 , 1 ,1, 2 , -4, 4 , 8 , -3};
		Stopwatch stopwatch = new Stopwatch();
		System.out.println("4Sum is zero: "+test.F_sum(A));
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
		
	}
	
	@Override
	public int F_sum(int[] A) {
		
		int[] orderedArr;
		orderedArr = merge_sort(A);
		
		System.out.print("merge sort:");
        for(int p = 0; p < orderedArr.length ; p++) {
        	System.out.print(orderedArr[p] + " ");
        }
        System.out.println();
        
		int cnt = 0 , len = orderedArr.length;
		
		for ( int i = 0 ; i < len-3 ; i++ ) {
			for ( int j = i+1 ; j < len - 2 ; j++ ){
				
				int left = j+1 , right = len-1;
				while (left < right) {
					int fSum = orderedArr[i] + orderedArr[j] + orderedArr[left] + orderedArr[right];
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
	
	
	private int[] merge_sort(int[] arr){
//		System.out.println(arr[0].sum);
		int[] orderedArr;
		orderedArr = new int[arr.length];
		
        for(int i = 2; i < arr.length << 1; i = i << 1) {
            for(int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = (left + (i >> 1)) >= arr.length ? (arr.length - 1) : (left + (i >> 1));
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
        
        
        return orderedArr;
	}	

}
