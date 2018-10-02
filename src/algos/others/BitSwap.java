/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.others;

import java.util.Scanner;

/**
 *
 * @author anand
 */
public class BitSwap
{
    public static int findNoOfBits(int number)
    {
        int count = 0;
        while (number > 0) 
        {
            number = number >> 1;
            count++;
        }
        return count;
    }
    
    public static void bitSwap(int original)
    {
        int bitCount = findNoOfBits(original);
        int output = original;
        for (int i = bitCount - 1; i >=0; i--)
        {
            int currentBit = getBitValue(output, i);
            if (i == bitCount - 1)
            {
                int nextBit = getBitValue(output, i-1);
                if (nextBit == currentBit)
                {
                    output ^= (1 << i-1);
                }
            }
            else if (i == 0)
            {
                int prevBit = getBitValue(output, i+1);
                if (prevBit == currentBit)
                {
                    output ^= (1 << i+1);
                }
            }
            else
            {
                int nextBit = getBitValue(output, i-1);
                if (nextBit == currentBit)
                {
                    output ^= (1 << i-1);
                }
                int prevBit = getBitValue(output, i+1);
                if (prevBit == currentBit)
                {
                    output ^= (1 << i+1);
                }
            }
            output ^= (1 << i);
        }
        if (output == original)
        {
            System.out.println((bitCount%2 == 0 ? "Y" : "X"));
        }
        else
        {
            System.out.println((bitCount%2 == 0 ? "X" : "Y"));
        }
    }
    
    private static int getBitValue(int num, int position)
    {
        return ((num >> position) & 1) == 1 ? 1 : 0;
    }
    
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int rounds = s.nextInt();
        for (int i=0; i< rounds; i++)
        {
            bitSwap(s.nextInt());
        }
    }
}
