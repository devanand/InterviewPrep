/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.tree;

import algos.model.Node;

/**
 *
 * @author anand
 */
public class NthLargestBST
{
    class Count {
        int c;
    }
    public void nthLargest(Node root, Count c, int k)
    {
        if (root == null && c.c > k )
        {
            return;
        }
        
        nthLargest(root.right, c, k);
        c.c++;
        if (c.c == k)
        {
            System.out.println(root.value);
            return;
        }
        
        nthLargest(root.left, c, k);
    }
}
