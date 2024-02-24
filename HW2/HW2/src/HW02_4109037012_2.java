
import test2.Stopwatch;

public class HW02_4109037012_2 extends FourSum {

	int[] orderedArr;

	public static void main(String[] args) {
		
		HW02_4109037012_2 test = new HW02_4109037012_2();		
		int[] A = { -1 , 1 ,1, 2 , -4, 4 , 8 , -3 };
		Stopwatch stopwatch = new Stopwatch();
		System.out.println("4Sum is zero: "+test.F_sum(A));
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}
	
	@Override
	public int F_sum(int[] A) {
		
		merge_sort(A);
		
		int cnt = 0 , n = orderedArr.length;
		for (int i = 0 ; i < n - 3 ; i++) {
			if ( i > 0 && (orderedArr[i] == orderedArr[i-1]) )  continue;
			for (int j = i + 1; j < n - 2; j++) {
				
				if (j > i+1 && orderedArr[j] == orderedArr[j-1]) continue;
				int left = j+1;
				int right = n-1;
				while (left < right) {
					int fourSum = orderedArr[i] + orderedArr[j] + orderedArr[left] + orderedArr[right];
					if (fourSum == 0) {
						cnt++;
						while (left < right && orderedArr[left] == orderedArr[left + 1]) {
							left++;
						}
						while (left < right && orderedArr[right] == orderedArr[right - 1]) {
							right--;
						}
						left++;
						right--;
					}
					else if (fourSum < 0) left++;
					else right--;
				}
			}
		}
		return cnt;
	}
	
	
	private void merge_sort(int[] arr){
//		System.out.println(arr[0].sum);
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
//        System.out.print("A merge:");
//        for(int p = 0; p < arr.length ; p++) {
//        	System.out.print(arr[p] + " ");
//        }
//        System.out.println();
	}	

}
