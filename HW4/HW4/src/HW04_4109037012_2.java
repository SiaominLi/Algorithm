//1/3 tesing
public class HW04_4109037012_2 extends doge_coin {

	public static void main(String[] args) {
		HW04_4109037012_2 hw2 = new HW04_4109037012_2();
		int[] arr = {7,6,4,3,1} ;
		int ans = hw2.doge(arr);
		System.out.print(ans);
	}

	@Override
	public int doge(int[] price) {
		int min = price[0] , minus = 0;
		for(int i = 1 ; i < price.length/3 ; i++ ) {
			if( price[i] < min )
				min = price[i];
			else if( price[i] - min > minus ) 
				minus = price[i] - min;
		}
		return minus;
	}

}