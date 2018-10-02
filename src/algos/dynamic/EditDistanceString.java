/* 
 * The edit distance between two strings refers to the minimum number of character 
 * insertions, deletions, and substitutions required to change one string to the other. 
 * For example, the edit distance between “kitten” and “sitting” is three: 
 * substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
*/
package algos.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author anand
 */
public class EditDistanceString
{
    public static int editDistance(String s1, String s2, int m, int n)
    {
        if (m == 0 || n == 0)
        {
            return n + m;
        }
        
        if (s1.charAt(m) == s2.charAt(n))
        {
            return editDistance(s1, s2, m-1, n-1);
        }
        
        return 1 + Math.min(Math.min(editDistance(s1, s2, m-1, n), 
                                     editDistance(s1, s2, m, n-1)), 
                                     editDistance(s1, s2, m-1, n-1));
    }
    
    public static void dpEditDistance(String s1, String s2)
    {
        int m = s1.length(), n = s2.length();
        int dp[][] = new int[m+1][n+1];
        
        for (int i=0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0)
                {
                    dp[i][j] = j;
                }
                
                else if (j == 0)
                {
                    dp[i][j] = i;
                }
                
                else if (s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
    
    public static void editDistanceUsingMap(String s1, String s2)
    {
        int count = 0;
        int secondCharCount = 0;
        Map <String, Integer> outMap = new HashMap<>();
        for (int i=0; i < s1.length(); i++)
        {
            String s = null;
            if (i == s1.length() - 1)
            {
                s = s1.substring(i);
            }
            else
            {
                s = s1.substring(i, i+1);
            }
            if (outMap.containsKey(s))
            {
                outMap.put(s, outMap.get(s)+1);
            }
            else
            {
                outMap.put(s, 1);
            }
        }
        
        for (int i=0; i < s2.length(); i++)
        {
            String s = null;
            if (i == s2.length() - 1)
            {
                s = s2.substring(i);
            }
            else
            {
                s = s2.substring(i, i+1);
            }
            if (outMap.containsKey(s))
            {
                if (outMap.get(s) > 1)
                {
                    outMap.put(s, outMap.get(s) - 1);
                }
                else
                {
                    outMap.remove(s);
                }
            }
            else
            {
                secondCharCount++;
            }
        }
        
        System.out.println(Math.max(outMap.keySet().size(), secondCharCount));
    }
    
    public static void main(String[] args)
    {
        String s1 = "kitten";
        String s2 = "sitting";
        //System.out.println(editDistance(s1, s2, s1.length() - 1, s2.length() - 1));
        dpEditDistance(s1, s2);
        editDistanceUsingMap(s1, s2);
        
    }
}
