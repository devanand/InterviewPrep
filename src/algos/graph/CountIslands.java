/*
Given a boolean 2D matrix, find the number of islands. 
A group of connected 1s forms an island. For example, the below matrix contains 5 islands
*/
package algos.graph;

/**
 *
 * @author anand
 */
public class CountIslands
{
    
    public boolean isSafe(int a[][], int i, int j, boolean visited[][])
    {
        return (i >= 0 && i <a.length 
                && j >=0 && j < a[0].length
                && !visited[i][j] && a[i][j] == 1);
    }
    
    public void dfs(int a[][], int i, int j, boolean visited[][])
    {
        int k1[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int k2[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[i][j] = true;
        for (int k = 0; k < k1.length; k++)
        {
            if (isSafe(a, i+k1[k], j+k2[j], visited))
            {
                dfs(a, i+k1[k], j+k2[k], visited);
            }
        }
    }
    
    public void noOfIslands(int a[][], boolean visited[][])
    {
        int count = 0;
        for (int i=0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                if (a[i][j] == 1 && !visited[i][j])
                {
                    dfs(a, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    
    public static void main(String[] args)
    {
        int a[][] = {{1, 0, 0, 1},
                     {1, 1, 0, 0}};
        boolean visited[][] = new boolean[a.length][a[0].length];
        new CountIslands().noOfIslands(a, visited);
        
    }
}
