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
                        grid[row][col] = num;
                    }
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
        }
        return true;
    }
    
    public boolean isSafe(int grid[][], int row, int col, int num)
    {
        return isNotUsedInRow(grid, row, num) 
               && isNotUsedInCol(grid, col, num) 
                && isNotUsedInBox(grid, row - row%3, col - col%3, num);
    }
    
    private boolean isNotUsedInRow(int grid[][], int row, int num)
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
    
    private boolean isNotUsedInCol(int grid[][], int col, int num)
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
    
    private boolean isNotUsedInBox(int grid[][], int startRow, int startCol, int num)
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
}
