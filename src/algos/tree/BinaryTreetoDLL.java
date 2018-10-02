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
public class BinaryTreetoDLL
{
    static Node head = null;
    Node prev = null;
    public void toDll(Node root)
    {
        if(root == null)
        {
            return ;
        }
        
        toDll(root.left);
        if (prev == null)
        {
            head = root;
        }
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        toDll(root.right);
    }
    
    void print(Node head)
    {
        while (head != null)
        {
            System.out.println(head.value);
            head = head.right;
        }
    }
    
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        
        BinaryTreetoDLL dll = new BinaryTreetoDLL();
        dll.toDll(root);
        dll.print (head);
    }
}
