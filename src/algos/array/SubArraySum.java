/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.array;

/**
 *
 * @author anand
 */
public class SubArraySum
{
    public static boolean subsetSum(int a[], int sum)
    {
        boolean dp[][] = new boolean[a.length+1][sum+1];
        for (int i=0;i < a.length; i++)
        {
            dp[i][0] = true;
        }
        
        for (int j = 1; j <= sum; j++)
        {
            dp[0][j] = false;
        }
        
        for (int i = 1; i <=a.length; i++)
        {
            for (int j = 1; j <= sum; j++)
            {
                dp[i][j] = dp[i-1][j];
                if (a[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - a[i-1]];
                }
            }
        }
        
        return dp[a.length][sum];
    }
    
    public static void main(String[] args)
    {
        int a[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        
        System.out.println(subsetSum(a, sum));
    }
}
