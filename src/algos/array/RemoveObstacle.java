/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.array;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anand
 */
public class RemoveObstacle
{
    private boolean isSafe(int mat[][], int visited[][], int x, int y)
    {
        return !(mat[x][y] == 0 || visited[x][y] != 0);
    }

    private boolean isValid(int x, int y, int xMax, int yMax)
    {
        return (x < xMax && y < yMax && x >= 0 && y >= 0);
    }
    
    int removeObstacle(int[][]lotMatrix, int visited[][], int i, int j, int x, int y, int min_dist, int dist)
    {
        if (i == x && j == y)
        {
            return Integer.min(dist, min_dist);
        }
        
        visited[i][j] = 1;
        int paths[][] = {
                            {0, -1},
                            {-1, 0},
                            {0, 1},
                            {1, 0}
                        };
        
        for (int path[] : paths)
        {
            int pathI = i + path[0];
            int pathJ = j + path[1];
            if (isValid(pathI, pathJ, lotMatrix.length, lotMatrix[0].length)
                && isSafe(lotMatrix, visited, pathI, pathJ)) 
            {
                min_dist = removeObstacle(lotMatrix, visited, pathI, pathJ, x, y,
                                                                        min_dist, dist + 1);
            }
            
        }

        visited[i][j] = 0;

        return min_dist;
    }
    
    
    public static void main(String[] args)
    {
        int lotMatrix[][]= {
            {1, 1, 1},
            {0, 1, 0},
            {1, 9, 0}
        };
        int visited[][] = new int[3][3];
        int path = new RemoveObstacle().removeObstacle(lotMatrix, visited, 0, 0, 2, 1, Integer.MAX_VALUE, 0);
        
        System.out.println(path == Integer.MAX_VALUE ? -1 : path);
    }
    
}
