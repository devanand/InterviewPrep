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
public class MorrisTraversal
{
    public void morrisTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }
        Node current, pre;
        current = root;
        
        while(current !=null)
        {
            if (current.left == null)
            {
                System.out.println(current.value);
            }
            else 
            {
                pre = current.left;
                
                while(pre.right != null && pre.right != current)
                {
                    pre = pre.right;
                }
                if (pre.right == null)
                {
                    pre.right = current;
                    current = current.left;
                }
                else
                {
                    pre.right = null;
                    System.out.println(current.value);
                    current = current.right;
                }
            }
        }
    }
}
