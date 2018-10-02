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
public class SearchInSortedRotatedArray
{
    public int search(int a[], int l, int h, int element)
    {
        if (l > h)
        {
            return -1;
        }
        int mid = (l + h)/2;
        if (a[mid] == element)
        {
            return a[mid];

        }
        if (a[l] < a[mid])
        {
            if (element >=a[l] && element <=a[mid])
            {
               return search(a, l, mid, element);
            }
            else 
            {
                return search(a, mid+1, h, element);
            }
        }
        if (element >=a[mid+1] && element <=a[h])
        {
            return search(a, mid+1, h, element);
        }
        else
        {
            return search(a, l, mid, element);
        }
    }
}
