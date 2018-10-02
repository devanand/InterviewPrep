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
public class SegregateEvenOdd
{
    public void segregateEvenOdd(int arr[])
    {
        int left = 0, right = arr.length - 1;
        
        while(left < right)
        {
            while (arr[left] %2 == 0 && left < right)
            {
                left++;
            }
            while (arr[right]%2 == 1 && left <right)
            {
                right--;
            }
            if (left < right)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}
