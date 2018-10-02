/*
* Given a string, find the palindrome that can be made by inserting the fewest number 
* of characters as possible anywhere in the word. If there is more than one palindrome 
* of minimum length that can be made, return the lexicographically earliest one 
* (the first one alphabetically).
*/
package algos.dynamic;

/**
 *
 * @author anand
 */
public class MinAppendPalindrome
{
    //Find insertions non dynamic programming approach
    public static boolean isPalindrome(char[] arr, int startLength, int endLength)
    {
        if (startLength == endLength)
        {
            return true;
        }
        
        while (startLength < endLength)
        {
            if (arr[startLength] != arr[endLength])
            {
                return false;
            }
            
            startLength++;
            endLength--;
        }
        
        return true;
    }
    
    public static int getRequiredInsertions(String s, int startLength, int endLength)
    {
        if (isPalindrome(s.toCharArray(), startLength, endLength))
        {
            return 0;
        }
        startLength++;
        
        return 1 + getRequiredInsertions(s, startLength, endLength);
    }
    
    public static void main(String[] args)
    {
        String s = "abb";
        System.out.println(getRequiredInsertions(s, 0, s.length()-1));
    }
}
