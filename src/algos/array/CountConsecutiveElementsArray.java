/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.array;

/**
 *
 * @author anand
 */
public class CountConsecutiveElementsArray
{
    public static void countConsecutive(char arr[])
    {
        char current = arr[0];
        int count = 1;
        StringBuilder s = new StringBuilder();
        for (int i = 1; i<arr.length;i++)
        {
            if (arr[i] == current)
            {
                count++;
            }
            else
            {
                s.append(current);
                s.append(count);
                current = arr[i];
                count = 1;
            }
        }
        s.append(current);
        s.append(count);
        System.out.println(s.toString());
    }
    
    public static void main(String[] args)
    {
        char arr[] = "aaaabbbcd".toCharArray();
        countConsecutive(arr);
    }
}
