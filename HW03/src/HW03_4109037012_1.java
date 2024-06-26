// find from mid

public class HW03_4109037012_1 extends One_0k_rock 
{
	public static void main(String[] args) 
	{
		HW03_4109037012_1 test = new HW03_4109037012_1();
		String[] str = {"01","1100" ,"1111"} ;
		Stopwatch stopwatch = new Stopwatch();
		boolean[] res = test.one0k(str);
		
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
		
		test.show(res);
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
				int left = s.length()/2-1, right = s.length()/2;
				ans[i] = true;
				while(left > -1)
				{
					if(s.charAt(left) == '1' || s.charAt(right) == '0')	// false condition
					{
						ans[i] = false;
						break;
					}
					left--;
					right++;
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