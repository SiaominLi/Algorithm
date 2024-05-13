public class HW10_4109037012_2 extends Buy_Phone{
	int n;
    int[][] ans;
    int[][] inputArr;
    public int[][] bestPhone(int[][] inputArr){
        n = inputArr.length;
        int i,j;
        this.inputArr = inputArr;
        quick_sort(0,n-1);
        int num=0,maxy;
        int[] remind = new int[n];
        for(i=0;i<n;i++){
            maxy = inputArr[i][1];
            for(j=i+1;j<n;j++){
                if(inputArr[j][1]>=maxy){
                    maxy = inputArr[j][1];
                    i = j;
                }
            }
            remind[num++] = i;
        }
        ans = new int[num][2];
        for(i=0;i<num;i++){
            ans[i][0] = inputArr[remind[i]][0];
            ans[i][1] = inputArr[remind[i]][1];
        }
        return ans;
    }
    public void quick_sort(int left,int right){
        int i,j;
        int[] temp = new int[2];
        if(left<right){
            int[] s=inputArr[(left+right)>>1];
            i=left;
            j=right;
            while(i<j) {
                while((inputArr[i][0] < s[0]) || ((inputArr[i][0] == s[0])&&(inputArr[i][1] < s[1]))) i++;//to right
                while(inputArr[j][0] > s[0] || ((inputArr[j][0] == s[0])&&(inputArr[j][1] > s[1]))) j--;// to left
                if(i >= j) break;
                temp = inputArr[i];
                inputArr[i] = inputArr[j];
                inputArr[j] = temp;
            }
            quick_sort(left,i-1);
            quick_sort(j+1,right);
        }
    }
    public static void main(String[] args) {
		
    	HW10_4109037012_2 t2 = new HW10_4109037012_2();
		int[][] input = {{3,1},{4,5},{5,4},{2,11},{9,1}};
    	//[[4,5],[5,4],[2,11],[9,1]]
//		int[][] input = {{1,1},{2,4},{2,10},{5,4},{4,8},{5,5},{8,4},{10,2},{10,1}};
		//[[2,10],[4,8],[5,5],[8,4],[10,2]]
		int[][] fin = t2.bestPhone(input);
		for(int i=0 ; i<fin.length; i++ ) {
			System.out.println(fin[i][0]+","+fin[i][1]);
		}

	}
}
