public class HW10_4109037012_1 extends Buy_Phone{
	public static void main(String[] args) {
		HW10_4109037012_1 t1 = new HW10_4109037012_1();
//		int[][] input = {{3,1},{4,5},{5,4},{2,11},{9,1}};
		int[][] input = {{1,1},{2,4},{2,10},{5,4},{4,8},{5,5},{8,4},{10,2},{10,1}};
		int[][] ans = t1.bestPhone(input);
		for(int i=0 ; i<ans.length; i++ ) {
			System.out.println(ans[i][0]+","+ans[i][1]);
		}
	}
	public int[][] bestPhone(int[][] inputArr){
		int LEN=inputArr.length, END=LEN-1;
		int i, j, len=LEN;
		for(i=0; i<END; ++i){
			for(j=END; j>i; --j){
				if(inputArr[j]==null) {
					continue;
				}
				else if(inputArr[i]==null){
					len--; 
					break; 
				}
				else if(inputArr[j][0]>=inputArr[i][0] && inputArr[j][1]>=inputArr[i][1]){
					inputArr[i]=null; 
					len--; 
					break;
				}
			}
		}
		int[][] TMP = new int[len][];
		for(i=j=0; i<LEN; ++i) {
			if(inputArr[i]!=null){
				TMP[j++]=inputArr[i]; 
			}
		}
		return TMP;
	}
}