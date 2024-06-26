
public class HW08_4109037012_2 extends MaxLandArea{

	public static void main(String[] args) {
		HW08_4109037012_2 t2 = new HW08_4109037012_2();
		int[][] array = {{0,1,1},{1,0,1},{0,1,1}}; 
		System.out.println(t2.maxLandArea(array));	
	}
	public int maxLandArea(int[][] array) {
        int i , j , ans=0 , m = array.length , n = array[0].length;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (array[i][j] == 1) ans = Math.max(dfs(array, i, j, m, n), ans);
            }
        }
        return ans;
    }
    public int dfs(int[][] grid, int i, int j, int m, int n) {
        if ( i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1+dfs(grid, i - 1, j, m, n)+ dfs(grid, i + 1, j, m, n)+ dfs(grid, i, j - 1, m, n)+ dfs(grid, i, j + 1, m, n);
    }
}
