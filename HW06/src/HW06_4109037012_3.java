
public class HW06_4109037012_3 extends MedianOfArrays {

	public static void main(String[] args) {
		HW06_4109037012_3 test = new HW06_4109037012_3();
//		int[][] arrays = {{1,3,10}, {-1,5,7}, {-2,5,12}};
		// Sorted: [-2, -1, 1, 3, 5, 5, 7, 10, 12], Median: 5.0
//		int[][] arrays = {{3, 7}, {-1,5,10}, {-2,1,12}};
		// Sorted: [-2, -1, 1, 3, 5, 7, 10, 12], Median: 4.0
//		int[][] arrays = {{3,5,7,13},{9,21},{3,4,7},{16}};
		// Sorted: [3, 3, 4, 5, 7, 7, 9, 13, 16, 21], Median: 7.0
//		int[][] arrays = {{3,5,7,13},{9,21},{3,4,8},{16,100}};
		// Sorted: [3, 3, 4, 5, 7, 8, 9, 13, 16, 21, 100], Median: 8.0
		int[][] arrays = {{1,1,7,7}};
		System.out.println(test.find_median(arrays));

	}
	@Override
	public double find_median(int[][] arrays) {
		int N = 0, MAX = arrays[0][0], MIN = arrays[0][0];
		for (int i = 0; i < arrays.length; i++) {
			int len = arrays[i].length - 1;
			if (arrays[i][0] < MIN)
				MIN = arrays[i][0];
			if (arrays[i][len] > MAX)
				MAX = arrays[i][len];
			N += (len + 1);
		}
		if ((N & 1) == 0) {
			double m1 = (double) outer(arrays, MAX, MIN, N / 2);
			double m2 = (double) outer(arrays, MAX, MIN, N / 2 + 1);
			return (m1 + m2) / 2;
		} else
			return (double) outer(arrays, MAX, MIN, N / 2 + 1);
	}

	public int outer(int[][] arrays, int max, int min, int limit) {
		while (max - min > 1) {
			int mid, right = 0;
			mid = (max + min) / 2;
			for (int i = 0; i < arrays.length; i++) {
				int l = arrays[i].length;
				if (mid > arrays[i][l - 1])
					continue;
				else if (mid < arrays[i][0])
					right += l;
				else
					right += binarySearch(arrays[i], mid);
			}
			if (right >= limit)
				min = mid;
			else
				max = mid;
		}
		for (int i = 0; i < arrays.length; i++)
			if (binarySearch(arrays[i], max) >= limit)
				return max;
		return min;
	}

	public int binarySearch(int ary[], int pivot) {
		int left = 0, right = ary.length - 1, number = 0, mid = 0;
		while (right - left > 1) {
			mid = (left + right) / 2;
			if (ary[mid] >= pivot)
				right = mid;
			else
				left = mid;
		}
		if (ary[left] >= pivot)
			number = left;
		else if (ary[right] >= pivot)
			number = right;
		return ary.length - number;
	}
}
