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
public class MoveZerosToright
{
   public void moveZerosToRight(int arr[])
   {
       int count = 0;
       for (int i=0; i < arr.length; i++)
       {
           if (arr[i] != 0)
           {
               arr[count] = arr[i];
               count++;
           }
       }
       
       while(count < arr.length) 
       {
           arr[count++] = 0;
       }
   }
}
