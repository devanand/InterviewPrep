/*
 * Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
 */
package algos.array;

/**
 *
 * @author anand
 */
public class MaximumSumContiguousArray
{
    public static void getMaxSum(int arr[])
    {
        int sumInc = 0,
            maxTill = 0;
        
        for (int a : arr)
        {
            
            sumInc += a;
            if (sumInc < 0)
            {
                sumInc = maxTill = 0;
                
            }
            if (maxTill < sumInc)
            {
                maxTill = sumInc;
            }
        }
        System.out.println(maxTill);
    }
    
    public static void main(String[] args)
    {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};//{-5, -1, -8, -9}; //{34, -50, 42, 14, -5, 86};
        getMaxSum(arr);
    }
}
