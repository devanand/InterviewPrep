/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.array;

import java.math.BigInteger;

/**
 *
 * @author anand
 */
public class BinarianOfAnArray
{
    public int solution(int[] A)
    {
        BigInteger binarian = BigInteger.ZERO;
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] == 0)
            {
                binarian = binarian.add(BigInteger.ONE);
            }
            else
            {
                binarian = binarian.add(BigInteger.valueOf((1 << A[i])));
            }
        }
        BigInteger solution = BigInteger.ONE;
        int result = 0;
        while (true)
        {
            if (solution.shiftLeft(1).compareTo(binarian) == 1 )
            {
                binarian = binarian.subtract(solution);
                solution = BigInteger.ONE;
                result++;
                if (binarian.equals(BigInteger.ZERO))
                {
                    break;
                }
                
            }
            else
            {
                solution = solution.shiftLeft(1);
            }
            
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        BinarianOfAnArray a = new BinarianOfAnArray();
        int A[] = {1, 5, 4};
        System.out.println(a.solution(A));
    }
}
