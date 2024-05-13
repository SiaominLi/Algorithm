
public class HW08_4109037012_3 extends MaxLandArea {

	public static void main(String[] args) {
		HW08_4109037012_3 t3 = new HW08_4109037012_3();
		int[][] array = {{0,1,1},{1,0,1},{0,1,1}}; 
		System.out.println(t3.maxLandArea(array));	
	}
	
	@Override
	public int maxLandArea(int[][] array) {
		int maxArea = 0;
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                if(array[i][j] == 1) {
                    maxArea = Math.max(maxArea, findArea(array, i, j));
                }
            }
        }
        return maxArea;
	}
	private int findArea(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return 0;
        
        grid[row][col] = 0;
        int count = 1;

        count += findArea(grid, row, col-1);
        count += findArea(grid, row, col+1);
        count += findArea(grid, row-1, col);
        count += findArea(grid, row+1, col);

        return count;
    }
	
}
