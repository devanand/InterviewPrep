/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graph;

/**
 *
 * @author anand
 */
public class SudokuSolver
{
    public static boolean solveSudoku(int grid[][])
    {
        for (int row=0; row < 9 ; row++)
        {
            for (int col = 0; col < 9; col++)
            {
                if (grid[row][col] == 0)
                {
                    for (int num = 1; num <= 9; num++)
                    {
                        if (isSafe(grid, row, col, num))
                        {
                            grid[row][col] = num;
                            if (solveSudoku(grid))
                            {
                                return true;
                            }
                            else
                            {
                                grid[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isSafe(int grid[][], int row, int col, int num)
    {
        return isNotUsedInRow(grid, row, num) 
               && isNotUsedInCol(grid, col, num) 
                && isNotUsedInBox(grid, row - row%3, col - col%3, num);
    }
    
    private static boolean isNotUsedInRow(int grid[][], int row, int num)
    {
        for (int i = 0; i < 9; i++)
        {
            if (grid[row][i] == num)
            {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean isNotUsedInCol(int grid[][], int col, int num)
    {
        for (int i = 0; i < 9; i++)
        {
            if (grid[i][col] == num)
            {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isNotUsedInBox(int grid[][], int startRow, int startCol, int num)
    {
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (grid[i+startRow][j+startCol] == num)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        int grid[][] = {
                        {9,0,0,1,0,0,0,0,5},
			{0,0,5,0,9,0,2,0,1},
			{8,0,0,0,4,0,0,0,0},
			{0,0,0,0,8,0,0,0,0},
			{0,0,0,7,0,0,0,0,0},
			{0,0,0,0,2,6,0,0,9},
			{2,0,0,3,0,0,0,0,6},
			{0,0,0,2,0,0,9,0,0},
			{0,0,1,9,0,4,5,7,0},
                     };
        
        solveSudoku(grid);
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println("");
        }
    }
}
