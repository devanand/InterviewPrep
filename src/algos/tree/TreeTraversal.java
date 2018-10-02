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
public class TreeTraversal
{
    public void inOrder(Node root)
    {
        if (root == null)
        {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }
    
    public void preOrder(Node root)
    {
        if (root == null)
        {
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void postOrder(Node root)
    {
        if (root == null)
        {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }
}
