public class HW10_4109037012_4 extends Buy_Phone
{
    final static public int[][] work_array=new int[200000][2];
    final static public int[][] reverse_ans=new int[200000][2];
    @Override
    public int[][] bestPhone(int[][] inputArr)
    {
        int len = inputArr.length;
        Sort(inputArr,0,len--);
        int min=inputArr[len][1];
        reverse_ans[len]=inputArr[len];
        int count=len-1;
        for(int i=count;i!=-1;i--)
            if(inputArr[i][1]>min)
            {
                min=inputArr[i][1];
                reverse_ans[count--]=inputArr[i];
            }
        int[][] ans =new int[len=len-count][2];
        System.arraycopy(reverse_ans, count+1, ans, 0, len);
        return ans;
    }
    private static void Sort(int[][] array,int start, int count) 
    { 
        if (count < 2) 
            return;
        int mid=count>>1;
        Sort(array, start,mid); 
        Sort(array, start + mid, count - mid); 
        Merge(array, start, mid, start + mid, count - mid); 
    } 
    private static void Merge(int[][] array, int leftStart, int leftCount, int rightStart, int rightCount) 
    { 
        int i = leftStart, j = rightStart, leftBound = leftStart + leftCount, rightBound = rightStart + rightCount, index = leftStart; 
        while (i < leftBound || j < rightBound) 
        { 
            if (i < leftBound && j < rightBound) 
            { 
                if (array[j][0] < array[i][0]) 
                    work_array[index] = array[j++]; 
                else if(array[j][0] > array[i][0])
                    work_array[index] = array[i++];
                else
                    if(array[j][1] < array[i][1]) 
                        work_array[index] = array[j++]; 
                    else
                        work_array[index] = array[i++];
            } 
            else if (i < leftBound) 
                work_array[index] = array[i++]; 
            else
                work_array[index] = array[j++]; 
            ++index; 
        } 
        for (i = leftStart; i < index; ++i) 
            array[i] = work_array[i]; 
    }
    public static void main(String[] args) {
		HW10_4109037012_4 t4 = new HW10_4109037012_4();
//		int[][] input = {{3,1},{4,5},{5,4},{2,11},{9,1}};
    	//[[4,5],[5,4],[2,11],[9,1]]
		int[][] input = {{1,1},{2,4},{2,10},{5,4},{4,8},{5,5},{8,4},{10,2},{10,1}};
		//[[2,10],[4,8],[5,5],[8,4],[10,2]]
		int[][] ans = t4.bestPhone(input);
		
		for(int i=0 ; i<ans.length; i++ ) {
			System.out.println(ans[i][0]+","+ans[i][1]);
		}
	}
}