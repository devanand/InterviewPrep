/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author anand
 */
public class MaxSubArray
{
    public static void maxSubArray(int a[])
    {
        Map <Integer, Integer> resultMap = new HashMap<>();
        int sum = 0,
            maxLength = 0,
                end_Index = -1,
                start_index = 0;
        for (int i=0; i<a.length;i++)
        {
            sum += (a[i] == 0 ? -1 : 1);
            
            if (sum == 0)
            {
                maxLength = i+1;
                end_Index = i;
            }
            
            if (resultMap.containsKey(sum))
            {
                if (maxLength < i - resultMap.get(sum))
                {
                    maxLength = i - resultMap.get(sum);
                    end_Index = i;
                }
            }
            else
            {
                resultMap.put(sum , i);
            }
        }
        System.out.println(end_Index);
        System.out.println(end_Index - maxLength + 1);
    }
    
    public static void main(String[] args)
    {
        
        int a[] = {1, 0, 0, 1, 0, 1, 1};
        int b[] = {0, 0, 1, 1, 0};
        maxSubArray(a);
        maxSubArray(b);
    }
}
