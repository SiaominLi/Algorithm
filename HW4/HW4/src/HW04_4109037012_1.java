public class HW04_4109037012_1 extends doge_coin 
{

	public static void main(String[] args) {
		HW04_4109037012_1 hw = new HW04_4109037012_1();
		int[] arr = {7,1,5,3,6} ;
		int ans = hw.doge(arr);
		System.out.print(ans);
	}

	public int doge(int[] price) {
		int min = price[0] , minus = 0;
		for(int i = 1 ; i < price.length ; i++ ) {
			if( price[i] < min )
				min = price[i];
			else if( price[i] - min > minus ) 
				minus = price[i] - min;
		}
		return minus;
	}
}
