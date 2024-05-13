public class HW06_4109037012_1 extends MedianOfArrays{

	public static void main(String[] args) {
		HW06_4109037012_1 hw6 = new HW06_4109037012_1();
		int[][] arr = {{3}, {-1, 5}, {-2, 5, 12}} ;
		double ans = hw6.find_median(arr);
		System.out.print( "ans = "+ ans );
	}

	@Override
	public double find_median(int[][] arrays){
		// flatten the 2-D array
        int size = 0;
        for (int[] subArr : arrays) {
            size += subArr.length;
        }
//        System.out.println( "size = "+size  );
        int[] flattened = new int[size];
        int index = 0;
        for (int[] subArr : arrays) {
            for (int num : subArr) {
                flattened[index++] = num;
            }
        }
        // sort the flattened array
        flattened = merge_sort(flattened);
        // find the median
        if (size % 2 == 0) {
            int mid = (size / 2);
            return (flattened[(mid - 1)] + flattened[mid]) / 2.0;
        } else {
            return flattened[(int) (size / 2.0)];
        }
	}
	private int[] merge_sort(int[] arr){
        int[] orderedArr = new int[arr.length];
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
