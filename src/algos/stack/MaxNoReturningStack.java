/*
 * Added functionality to stack to return maximum number in it
 */
package algos.stack;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anand
 */
public class MaxNoReturningStack
{
    List <Integer> stack = new LinkedList<>();
    List <Integer> maxNoStack = new LinkedList<>();
    public static final int STACK_MAX_SIZE = 5;
    public void insert(int number)
    {
        if (stack.size() == STACK_MAX_SIZE)
        {
            return;
        }
        
        stack.add(number);
        if (maxNoStack.isEmpty() || number > maxNoStack.get(maxNoStack.size() - 1))
        {
            maxNoStack.add(number);
        }
    }
    
    public static void main(String[] args)
    {
        int a[] = {3, 1, 2, 5};
        MaxNoReturningStack stack = new MaxNoReturningStack();
        for (int x : a)
        {
            stack.insert(x);
        }
        System.out.println(stack.maxNoStack.get(stack.maxNoStack.size() - 1));
    }
}
