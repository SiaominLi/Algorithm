
public class HW01_4109037012_1 extends ArrayData {
	int M = -9999999;
	int m = 9999999;
	
	public HW01_4109037012_1( int[] A ) {
		this.A = A;
		for(int i=0; i<A.length; i++) {
			if(A[i] > M) {
				M = A[i];
			}
		}
		for(int i=0; i<A.length; i++) {
			if(A[i] < m) {
				m = A[i];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = {-9355, 1, 2278, 333, 97, 1, -68, 123, -77993};
		HW01_4109037012_1 test = new HW01_4109037012_1(A);
		System.out.println(test.max());
		System.out.println(test.min());
	}
	
	@Override
	public int max() {
		return M;
	}
	@Override
	public int min() {
		return m;
	}
}
