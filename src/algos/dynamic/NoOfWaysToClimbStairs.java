/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.dynamic;

/**
 *
 * @author anand
 */
public class NoOfWaysToClimbStairs
{
    public static int numWays(int n, int steps[], int dp[])
    {
        if (n == 0)
        {
            return 0;
        }
        
        for (int i = 1; i <= n; i++)
        {
            int total = 0;
            for (int j = 0; j < steps.length; j++)
            {
                if (i - steps[j] >= 0)
                {
                    total += dp[i-steps[j]];
                }
            }
            dp[i] = total;
        }
        return dp[n];
    }
    
    public static void main(String[] args)
    {
        int n = 4; 
        int steps[] = {1, 2};
        int dp[] = new int[n+1];
        dp[0] = 1;
        System.out.println(numWays(n, steps, dp));
        
    }
}
