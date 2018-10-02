/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.others;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author anand
 */
public class StringSubstrings
{
    static int  s(String X)
    {
        char x[] = X.toCharArray();
        new StringBuilder().append(x[0]);
        Set <String> outSet = new TreeSet<>();
        int n = X.length();
        for (int i=0;i<n;i++)
        {
            for (int j=i+1;j<=n;j++)
            {
                outSet.add(X.substring(i, j));
            }
        }
        String arr[] = outSet.toArray(new String[outSet.size()]);
        return binarySearch(arr, X);
    }
    
    public static int binarySearch(String[] a, String x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
    
    public static void main(String[] args)
    {
        System.out.println(s("eren"));
    }
}
