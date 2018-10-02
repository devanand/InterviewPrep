/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.tree;

/**
 *
 * @author anand
 */
class Node1
{
    Node1 left;
    Node1 right;
    int value, height;

    public Node1(int value)
    {
        this.value = value;
    }
    
    public Node1(Node1 left, Node1 right, int value)
    {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    
    static Node1 newNode(int value)
    {
        return new Node1(value);
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getHeight()
    {
        return height;
    }
    
    
}

public class AVLTreeInsertion
{
    
    private int height(Node1 root)
    {
        if(root == null)
        {
            return 0;
        }
        else 
        {
            return root.height;
        }
    }
    
    private int balance(Node1 rootLeft, Node1 rootRight)
    {
        return height(rootLeft) - height(rootRight);
    }
    
    public Node1 insert(Node1 root, int value)
    {
        if (root == null)
        {
            return new Node1(value);
        }
        
        if (root.value > value)
        {
            root.left = insert(root.left, value);
        }
        
        if (root.value < value)
        {
            root.right = insert(root.right, value);
        }
        
        int balance = height(root.left) - height(root.right);
        return null;
    }
}
