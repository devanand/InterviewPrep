/*
 * Suppose an arithmetic expression is given as a binary tree. 
 * Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
 */
package algos.tree;

/**
 *
 * @author anand
 */
class TreeNode
{
    String val;
    TreeNode right, left;

    public TreeNode(String val)
    {
        this.val = val;
    }
}
public class TreeArithmetic
{
    
    public static int getResult(String operator, int num1, int num2)
    {
        switch(operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return -1;
    }
    
    public static int getTreeArithmetic(TreeNode root)
    {
        if (root.right == null && root.left == null)
        {
            return (Integer.parseInt(root.val));
        }
        
        int left = getTreeArithmetic(root.left);
        int right = getTreeArithmetic(root.right);
        
        return getResult((String)root.val, left, right);
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode("+");
        root.left = new TreeNode("*");
        root.left.left = new TreeNode("5");
        root.left.right = new TreeNode("4");
        
        root.right = new TreeNode("-");
        root.right.left = new TreeNode("100");
        root.right.right = new TreeNode("20");
        System.out.println(getTreeArithmetic(root));
    }
}
