/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author anand
 */
public class AllPermutationsOfNumbers
{
    private void numberPermutations(String s, int l, int r, Set <String> numbers)
    {
        if (l == r)
        {
            if (s.charAt(0) != 48)
            {
                numbers.add(s);
            }
            return;
        }
        for (int i=l; i <= r; i++)
        {
            s = swapString(s, l, i);
            numberPermutations(s, l+1, r, numbers);
            s = swapString(s, l, i);
        }
    }
    
    private String swapString(String a, int i, int j)
    {
        char temp; 
        char[] strArr = a.toCharArray(); 
        temp = strArr[i] ; 
        strArr[i] = strArr[j]; 
        strArr[j] = temp; 
        return String.valueOf(strArr); 
    }
    
    public int solution(int N)
    {
        Set <String> numberSet = new HashSet<>();
        String numString = new StringBuilder().append(N).toString();
        numberPermutations(numString, 0, numString.length() - 1, numberSet);
        System.out.println(numberSet);
        System.out.println(numberSet.size());
        return numberSet.size();
    }
    
    
    public int solution1(int N)
    {
        int a[] = new int[10];
        int x = N;
        while (x > 0)
        {
           int d = x % 10;
           a[d] += 1;
           x = x/10;
        }
        
        int totFact = 0, totFactZeros = 0;
        int sepFact = 1, sepFactZeros = 1;
        
        for (int i=0; i< a.length; i++) 
        {
            if (a[i] > 0)
            {
                if (i == 0 && a[i] > 0) 
                {
                    sepFactZeros *= (fact(a[i]-1));
                    totFactZeros += a[i] - 1;
                }
                else
                {
                    sepFactZeros *= fact(a[i]);
                    totFactZeros += a[i];
                }
                sepFact *= fact(a[i]);
                totFact += a[i];
            }
            
        }
        totFact = fact(totFact);
        totFactZeros = fact(totFactZeros);
        int totalCombinations = totFact/sepFact;
        int totalCombinationsZeros = totFactZeros/sepFactZeros;
        return a[0] > 0 ? totalCombinations - totalCombinationsZeros : totalCombinations;
    }
    
    private int fact(int n)
    {
        int fact = 1;
        for (int i = 2; i <=n; i++)
        {
            fact *= i;
        }
        return fact;
    }
    public static void main(String[] args)
    {
        AllPermutationsOfNumbers num = new AllPermutationsOfNumbers();
        System.out.println(num.solution1(120));
    }
}
