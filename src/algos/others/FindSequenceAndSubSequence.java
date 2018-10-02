/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.others;

import java.util.Arrays;

/**
 *
 * @author anand
 */
public class FindSequenceAndSubSequence
{
    public static void setSequence(int iStart, int iEnd, int arr[])
    {
        int subArr[] = new int[iEnd-iStart+1];
        for (int i=iStart, j=0; i<=iEnd; i++, j++)
        {
            subArr[j] = arr[i];
        }
        System.out.println(Arrays.toString(subArr));
    }
    
    public static void printSequences(int arr[])
    {
        int diff = arr[1] - arr[0];
        int diffCount = 1;
        int iStart = 0;
        int iEnd = 1;
        for (int i=1; i< arr.length -1; i++)
        {
            int currentDiff = arr[i+1] - arr[i];
            if (currentDiff == diff)
            {
                diffCount++;
                iEnd = i+1;
                if (i+1 == arr.length - 1 && diffCount >=2)
                {
                    setSequence(iStart, iEnd, arr);
                }
            }
            else
            {
                if (diffCount > 1)
                {
                    setSequence(iStart, iEnd, arr);
                }
                iStart = i;
                iEnd = i+1;
                diff = currentDiff;
                diffCount = 1;
            }
        }
    }
    
    public static void main(String ar[])
    {
        int arr[] = {1, 2, 3, 4};
        printSequences(arr);
    }
}
