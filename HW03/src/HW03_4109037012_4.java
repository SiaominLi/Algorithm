// case1: find from edge: O(N/2)
//
//
//import edit4.One_0k_rock;
//import edit4.Stopwatch;

public class HW03_4109037012_4 extends One_0k_rock 
{
	public static void main(String[] args) 
	{
		System.out.println("case1:");
		HW03_4109037012_4 test = new HW03_4109037012_4();
		String[] str = {"00000000111","00000001111111" ,"000000000","1110000"};
		Stopwatch stopwatch = new Stopwatch();
		boolean[] ans = test.one0k(str);		
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
		
		test.show(ans);
	}
	
	@Override
	public boolean[] one0k(String[] str) 
	{
		boolean[] ans = new boolean[str.length];
		
		for(int i=0; i<str.length; i++)
		{
			String s = str[i];
			if(s.length()%2 == 0)
			{
				int left = 0, right = s.length()-1;
				ans[i] = true;
				while(left < s.length()/2)
				{
//					System.out.println("left = "+left+" "+s.charAt(left));
//					System.out.println("right = "+right+" "+s.charAt(right));
					if(s.charAt(left) == '1' || s.charAt(right) == '0')	// false condition
					{
						ans[i] = false;
						break;
					}
					left++;
					right--;
				}
			}
			else
			{
				ans[i] = false;
			}
		}
		
		return ans;
	}
	
	private void show(boolean[] ans)
	{
		for(int i=0; i<ans.length; i++)
		{
			System.out.print(ans[i]+", ");
		}
		System.out.println();
	}
}