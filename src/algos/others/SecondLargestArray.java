/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.others;

/**
 *
 * @author anand
 */
public class SecondLargestArray
{
    public static void secondLargest(int a[])
    {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        for (int i=0; i<a.length; i++)
        {
            if (a[i] > max) 
            {
                secMax = max;
                max = a[i];
            }
            else if (a[i] > secMax && a[i] < max)
            {
                secMax = a[i];
            }
        }
        System.out.println("Max "+ max + "Second max " + secMax);
    }
    
    public static void main(String[] args)
    {
        int a[] = {2, 2, 2, 2};
        secondLargest(a);
    }
}
