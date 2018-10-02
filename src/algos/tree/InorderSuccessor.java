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
public class InorderSuccessor
{
    public static Node minValue(Node root)
    {
        while(root.left != null)
        {
            root = root.left;
        }
        return root;
    }
    
    public static Node inOrderSuccessor(Node root, Node n)
    {
        if (n.right != null)
        {
            return minValue(root.right);
        }
        
        Node successor = null;
        
        while(root != null)
        {
            if (n.value < root.value)
            {
                successor = root;
                root = root.left;
            }
            else if (n.value > root.value)
            {
                root = root.right;
            }
            else 
            {
                break;
            }
        }
        return successor;
    }
 }
