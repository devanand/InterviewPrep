/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.linkedlist;

/**
 *
 * @author anand
 */
public class MergeTwoSortedLinkedLists
{
    public static Node merge(Node n1, Node n2)
    {
        if (n1 == null) 
        {
            return n2;
        }
        if (n2 == null)
        {
            return n1;
        }
        
        if (n1.value < n2.value)
        {
            n1.right = merge(n1.right, n2);
            return n1;
        }
        
        n2.right = merge(n1, n2.right);
        return n2;
    }
}
