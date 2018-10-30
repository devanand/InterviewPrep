/*
 * Suppose you have a multiplication table that is N by N. 
 * That is, a 2D array where the value at the i-th row and 
 * j-th column is (i + 1) * (j + 1) (if 0-indexed) or i * j (if 1-indexed).
 * Given integers N and X, write a function that returns the number of times 
 * X appears as a value in an N by N multiplication table.
 * For example, given N = 6 and X = 12, you should return 4, 
 * since the multiplication table looks like this:
 */
package algos.array;

/**
 *
 * @author anand
 */
public class FindNumberInMatrix
{
    public static void findNumberInMatrix(int row, int column, int num)
    {
        int occurrence = 0;
        for (int i = 1; i <= row; i++)
        {
            if ((num%i == 0) && (num/i <= column))
            {
                occurrence++;
            }
        }
        System.out.println(occurrence);
    }
    
    public static void main(String[] args)
    {
        findNumberInMatrix(6, 6, 12);
    }
}
