/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.others;

import java.util.*;

/**
 *
 * @author anand
 */
public class AllSubsets
{
    public static void printAllSubsets(char set[])
    {
        Set <String> outSet = new TreeSet<>();
        for (int i = 0 ; i <(1<<set.length);i++)
        {
            String s = "";
            for (int j = 0; j < set.length; j++) {
                if ((i & (1 << j)) > 0) {
                    s += set[j];
                }
                
            }
            outSet.add(s);
        }
        System.out.println(outSet);
    }
    
    public static void main(String[] args)
    {
        char x[] = {'e','r', 'e', 'n'};
        printAllSubsets(x);
    }
 
}
