    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author anand
 */
public class FindSubsetsAddUptoN
{
    public static int findSubsets(int a[], int total, int n, Map <String, Integer>dp)
    {
        String key = total + ":" + n;
        if (dp.containsKey(key))
        {
            return dp.get(key);
        }
        if (total == 0)
        {
            return 1;
        }
        if ( n < 0 || total < 0)
        {
            return 0;
        }
        
        int tempTotal = 0;
        if (a[n] > total)
        {
             tempTotal = findSubsets(a, total, n-1, dp);
        }
        else
        {
            tempTotal = findSubsets(a, total-a[n], n-1, dp) + findSubsets(a, total, n-1, dp);
        }
        dp.put(key, tempTotal);
        return tempTotal;
    }
    
    public static void main(String[] args)
    {
        int a[] = {2, 4, 6, 10};
        int total = 16;
        Map <String, Integer> dp = new HashMap<>();
        System.out.println(findSubsets(a, total, a.length - 1, dp));
        System.out.println(dp);
        
    }
}
