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
public class KthPalindrome
{   
    public int kthPalindrome(String str, String reverseStr, int l1, int l2, int dp[][])
    {
        if (l1 == 0)
        {
            dp[l1][l2] = l2;
            return l2;
        }
        
        if (l2 == 0)
        {
            dp[l1][l2] = l1;
            return l1;
        }
        
        if (str.charAt(l1) == str.charAt(l2))
        {
            if (dp[l1+1][l2+1] == Integer.MIN_VALUE)
            {
                dp[l1+1][l2+1] = kthPalindrome(str, reverseStr, l1+1, l2+1, dp);
            }
            
            return dp[l1+1][l2+1];
        }
        
        if (dp[l1+1][l2] == Integer.MIN_VALUE)
        {
            dp[l1+1][l2] = kthPalindrome(str, reverseStr, l1+1, l2, dp);
        }
        
        if (dp[l1][l2+1] == Integer.MIN_VALUE)
        {
            dp[l1][l2+1] = kthPalindrome(str, reverseStr, l1, l2+1, dp); 
        }
        
        return Math.min(dp[l1+1][l2], dp[l1][l2+1]);
    }
    
    public static void kthPalindrome(String str, String reverseStr)
    {
        int dp[][] = new int[str.length() + 1][reverseStr.length() + 1];
        for (int i = 0; i <= str.length(); i++)
        {
            for (int j = 0; j <= reverseStr.length(); j++)
            {
                if (i == 0)
                {
                    dp[i][j] = j;
                }
                else if (j == 0)
                {
                    dp[i][j] = i;
                }
                else if (str.charAt(i-1) == reverseStr.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        System.out.println(dp[str.length()][reverseStr.length()]);
    }
    
    public static void main(String[] args)
    {
        String str = "abcbea";
        int dp[][] = new int[str.length()+1][str.length()+1];
        new KthPalindrome().kthPalindrome(str, "aebcba", str.length()-1, str.length()-1, dp);
        System.out.println(dp[str.length()+1][str.length()+1]);
        
    }
}
