//All the bottoms should be given 1 candy in the final result.
//The neighbors of the bottoms should be given 1 more candy as we move from bottom point to peak point.
public class HW05_4109037012_3 extends littlebit {

	public static void main(String[] args) {
		HW05_4109037012_3 hw_3 = new HW05_4109037012_3();
		int[] arr = {39,7,1,34,50,33,41,59,90,74,74,64,25,70,93,71,7,95,69,45};
		int ans = hw_3.l_bit(arr);
		System.out.print( "ans3 = "+ ans );
	}

	@Override
	public int l_bit(int[] A) {
        int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < A.length; i++) {
//        	System.out.println("A " + A[i-1]+":" + A[i]);
            if (A[i] >= A[i-1]) {
            	if( A[i] == A[i-1] ) {
            		total += prev - countDown;
            		continue;
            	}
                if (countDown > 0) {
                    total += countDown*(countDown+1)/2; // arithmetic progression
//                    System.out.println("c = "+countDown+"     t1= " + total);
                    if (countDown >= prev) {
                    	total += countDown - prev + 1;
//                    	System.out.println("t2= " + total +"   c=:"+countDown+"  p:"+ prev);
                    }
                    countDown = 0;
                    prev = 1;
                }
                prev += 1;
//                prev = A[i] == A[i-1] ? 1 : prev+1;
                total += prev;
//                System.out.println("t3= " + total+"  p:"+ prev);
            }else countDown++;
        }
        if (countDown > 0) { // if we were descending at the end
            total += countDown*(countDown+1)/2;
//            System.out.println("t4= " + total);
            if (countDown >= prev) total += countDown - prev + 1;
//            System.out.println("t5= " + total);
        }
        return total;
	}

}
