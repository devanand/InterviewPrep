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
public class DecodeMessageWays
{
    public static int decode(char message[], int n, int dp[])
    {
        if (n == 0 || n == 1)
        {
            return 1;
        }
        if (dp[n] != -1)
        {
            return dp[n];
        }
        int total = decode(message, n-1, dp);
        if (n >= 2) {
            total += decode(message, n-2, dp);
        }
        dp[n] = total;
        return total;
     }
    
    public static void main(String[] args)
    {
        String message = "1111";
        int dp[] = new int[message.length() + 1];
        for (int i= 0; i < dp.length; i++)
        {
            dp[i] = -1;
        }
        decode(message.toCharArray(), message.length(), dp);
        System.out.println(dp[message.length()]);
    }
}
