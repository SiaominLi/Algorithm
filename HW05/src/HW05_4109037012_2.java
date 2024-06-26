
public class HW05_4109037012_2 extends littlebit
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HW05_4109037012_2 hw = new HW05_4109037012_2();
		int[] arr = {39,7,1,34,50,33,41,59,90,74,74,64,25,70,93,71,7,95,69,45} ;
		int ans = hw.l_bit(arr);
		System.out.print( "ans2 = "+ ans );
	}

	@Override
	public int l_bit(int[] A) {
		int peak = 0 , valley = 0 , candy_count = A.length ;
        for(int i = 1 ; i < A.length ;){
            if(A[i] == A[i-1]){ i++ ; continue;}
            peak = 0 ;
            valley = 0;
            while( i < A.length && A[i] > A[i-1]){
                peak++;
                i++;
                candy_count += peak;
            }
            
            while(i < A.length && A[i] < A[i-1]){
                valley++;
                i++;
                candy_count += valley;
            }    
            candy_count -= Math.min(peak,valley);
        }
        return candy_count;
	}

}
