package problem_15;

/**
 * 	Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 *	
 *	How many such routes are there through a 20×20 grid?
 *
 *	@author Freddy
 */
public class Problem15
{
	private static final int ROWS = 20, COLUMNS = 20;
	private static final long[][] GRID = new long[ROWS + 1][COLUMNS + 1];
	
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		System.out.println(countPaths(0, 0) + " routes solved in " + (System.currentTimeMillis() - start) + "ms");
	}
	
	/**
	 * Starts off at the specified cell of the grid,
	 * and counts how many routes there are to the
	 * bottom right corner (only being able to move
	 * right and down)
	 *   
	 * @param row the row to start at
	 * @param column the column to start at  
	 * @return # routes there are to the bottom right corner (from the top left), respecting movement restrictions (only right and down)
	 */
	private static long countPaths(int row, int column)
	{
		//base case -> sum for this cell already found
		if(GRID[row][column] != 0)
			return GRID[row][column];
		
		//base case -> path found
		if(row == ROWS || column == COLUMNS)
		{
			GRID[row][column] = 1;
			return 1;
		}
		
		//base case -> path numbers for neighbors to south and north have already been calculated, so just sum them
		if(GRID[row + 1][column] != 0 && GRID[row][column + 1] != 0)
		{
			long sum = GRID[row + 1][column] + GRID[row][column + 1];
			GRID[row][column] = sum;
			return sum;
		}
		
		/*
		 * We recursively call this function, and return the # of paths
		 * to the bottom right from the cell to the right, as well as
		 * the cell to the south
		 */
		countPaths(row + 1, column);
		countPaths(row, column + 1);
		return countPaths(row, column);
	}
}
