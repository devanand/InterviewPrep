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
public class Node
{
    int value;
    Node right;
    Node left;
    public Node()
    {
    }
    
    public Node(int value)
    {
        this.value = value;
    }
    
    public Node(int value, Node right)
    {
        this.value = value;
        this.right = right;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public Node getRight()
    {
        return right;
    }

    public int getValue()
    {
        return value;
    }
}
