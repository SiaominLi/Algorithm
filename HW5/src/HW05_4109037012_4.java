
public class HW05_4109037012_4 extends littlebit{

	public static void main(String[] args) {
		HW05_4109037012_4 hw_4 = new HW05_4109037012_4();
		int[] arr = {0,1,3,3,5,2};
		int ans = hw_4.l_bit(arr);
		System.out.print( "ans4 = "+ ans );

	}

	@Override
	public int l_bit(int[] A) {
		int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= A[i-1]) {
                if (countDown > 0) {
                    total += countDown*(countDown+1)/2; // arithmetic progression
                    if (countDown >= prev) total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = A[i] == A[i-1] ? 1 : prev+1;
                total += prev;
            }else countDown++;
        }
        if (countDown > 0) { // if we were descending at the end
            total += countDown*(countDown+1)/2;
            if (countDown >= prev) total += countDown - prev + 1;
        }
        return total;
	}

}
