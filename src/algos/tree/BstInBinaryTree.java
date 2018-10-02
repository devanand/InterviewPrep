package algos.tree;

import algos.model.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anand
 */
class MinMax
{
    boolean isBst;
    int min;
    int max;
    int size;

    public MinMax() 
    {
        this.isBst = true;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
        this.size = 0;
    }
    
    public MinMax(boolean isBst, int min, int max, int size) {
        this.isBst = isBst;
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

public class BstInBinaryTree 
{
    public MinMax bstInBinaryTree(Node root)
    {
        if (root == null)
        {
            return new MinMax();
        }
        
        MinMax left = bstInBinaryTree(root.left);
        MinMax right = bstInBinaryTree(root.right);
        MinMax m = new MinMax();
        if (!left.isBst || !right.isBst || left.max >=root.value || right.max <=root.value)
        {
            m.isBst = false;
            m.size = Math.max(left.size, right.size);
            return m;
        }
        m.isBst = true;
        m.size = left.size + right.size;
        m.min = (root.left != null ? left.min : root.value);
        m.max = (root.right != null ? right.max : root.value);
        return m;
    }
}
