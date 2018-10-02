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
class Total
{
    int total;
}
public class UniversalValueTree
{
    
    public static boolean univalTree(Node root, Total t)
    {
        if (root == null)
        {
            return true;
        }
        
        boolean left = univalTree(root.left, t);
        boolean right = univalTree(root.right, t);
        if (!left || !right)
        {
            return false;
        }
        
        if ((root.left != null && root.left.value != root.value) || (root.right != null && root.right.value != root.value))
        {
            return false;
        }
        t.total++;
        return true;
        
    }
    
    public static void main(String[] args)
    {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        Total t = new Total();
        univalTree(root, t);
        System.out.println(t.total);
    }
}
