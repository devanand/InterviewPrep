/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.array;

/**
 *
 * @author anand
 */
public class RotateMatrix
{
    public static void rotateClockwise(int a[][])
    {
        int iMin = 0;
        int i = a.length - 1;
        int jMin = 0;
        int j = a[0].length - 1;
        
        while (iMin < j) 
        {
            int numRotations = j - iMin;
            for (int r = 0; r < numRotations; r++)
            {
                int k = j - 1;
                int temp = a[iMin][j];
                //right to left;
                while (k >= iMin) 
                {
                    int temp1 = a[iMin][k];
                    a[iMin][k] = temp;
                    temp = temp1;
                    k--;
                }

                //top to bottom
                k = iMin+1;
                while (k <= i) 
                {
                    int temp1 = a[k][jMin];
                    a[k][jMin] = temp;
                    temp = temp1;
                    k++;
                }

                //left to right
                k = jMin + 1;
                while (k <= j) 
                {
                    int temp1 = a[i][k];
                    a[i][k] = temp;
                    temp = temp1;
                    k++;
                }

                //bottom to top
                k = i - 1;
                while (k >= iMin)
                {
                    int temp1 = a[k][j];
                    a[k][j] = temp;
                    temp = temp1;
                    k--;
                } 
            }
            
            iMin++;
            jMin++;
            i--;
            j--;
        }
        print(a);
    }
    
    public static void print(int a[][]) {
        for (int i=0;i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]  + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        int a[][] = {{1, 2, 3, 4},
                     {5, 6, 7, 8},
                     {9, 10, 11, 12},
                     {13, 14, 15, 16}};
        print(a);
        System.out.println();
        rotateClockwise(a);
    }
}
