/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.tree.treeview;

import java.util.HashMap;
import java.util.Map;
import algos.model.Node;

/**
 *
 * @author anand
 */
public class BottomView
{
    class TempNode
    {
        Node node;
        int level;
        
        public TempNode(Node node, int level)
        {
            this.node = node;
            this.level = level;
        }

        @Override
        public String toString()
        {
            return "" + node.value;
        }
    }      
    void bottomView(Node root, int lineIndex, int level, Map <Integer, TempNode> resultMap)
    {
        if (root == null)
        {
            return;
        }

        TempNode temp = new TempNode(root, level);

        if (!resultMap.containsKey(lineIndex)) 
        {
            resultMap.put(lineIndex, temp);
        }
        if (resultMap.containsKey(lineIndex) && resultMap.get(lineIndex).level < level)
        {
            resultMap.put(lineIndex, temp);
        } 

        bottomView(root.left, lineIndex -1, level+1, resultMap);
        bottomView(root.right, lineIndex +1, level+1, resultMap);

    }
    
    public void topView(Node root, int lineIndex, int level, Map <Integer, TempNode> resultMap)
    {
        if (root == null)
        {
            return;
        }
        TempNode temp = new TempNode(root, level);
        if (!resultMap.containsKey(lineIndex))
        {
            resultMap.put(lineIndex, temp);
        }
        if (resultMap.containsKey(lineIndex) && resultMap.get(lineIndex).level > level)
        {
            resultMap.put(lineIndex, temp);
        }
        topView(root.left, lineIndex - 1, level+1, resultMap);
        topView(root.right, lineIndex + 1, level+1, resultMap);
    }
    
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        Map <Integer, TempNode> resultMap = new HashMap<>();
        new BottomView().topView(root, 0, 0, resultMap);
        System.out.println(resultMap);
    }
}
