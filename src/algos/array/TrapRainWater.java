/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.array;

import java.util.Arrays;

/**
 *
 * @author anand
 */
public class TrapRainWater
{
    public static void trapRainWater(int a[])
    {
        int waterTrapped = 0;
        int left[] = new int[a.length];
        int right[] = new int[a.length];
        
        left[0] = a[0];
        
        for (int i=1; i < a.length; i++)
        {
            left[i] = Math.max(left[i-1], a[i]);
        }
        
        right[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >=0; i--)
        {
            right[i] = Math.max(right[i+1], a[i]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < a.length; i++)
        {
            waterTrapped += Math.min(left[i], right[i]) - a[i];
        }
        System.out.println(waterTrapped);
    }
    
    public static void trapRainWaterEfficient(int a[])
    {
        int waterTrapped = 0;
        int leftMax = a[0], rightMax = a[a.length - 1];
        for (int i = 1; i < a.length -1; i++)
        {
            waterTrapped += 0;
        }
    }
    
    public static void main(String[] args)
    {
        int a[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        trapRainWater(a);
        
    }
}
