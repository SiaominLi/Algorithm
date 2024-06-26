public class HW08_4109037012_1 extends MaxLandArea {

	public static void main(String[] args) {
		HW08_4109037012_1 t1 = new HW08_4109037012_1();
		int[][] array = {{0,1,1},{1,0,1},{0,1,1}}; 
		System.out.println(t1.maxLandArea(array));	
	}
	@Override
	public int maxLandArea(int[][] array) {
		int result = 0;
        for(int i = 0 ; i < array.length ; i++){
            for(int j = 0 ; j < array[0].length ; j++){
                if(array[i][j] == 1){
                    result = Math.max(result, island(i, j, array));
                }
            }
        }
        return result;
	}
	
	private int island(int x, int y, int[][] grid){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0){
            return 0;
        }
        grid[x][y] = 0;
        return island(x + 1, y, grid) + island(x - 1, y, grid) + island(x, y + 1, grid) + island(x, y - 1, grid) + 1;
    }

}
