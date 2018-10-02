/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.others;

/**
 *
 * @author anand
 */
public class MaxCandies
{
    public static void getMaxCandies(int startingAmount, int newEvery)
    {
        if (startingAmount < newEvery) 
        {
            System.out.println(startingAmount);
        }
        int totalCandies = startingAmount;
        int candieCovers = startingAmount;
        while(candieCovers >= newEvery)
        {
            totalCandies += candieCovers/newEvery;
            candieCovers = (candieCovers/3)+(candieCovers%3);
        }
        System.out.println(totalCandies);
    }
    
    public static void main(String[] args)
    {
        getMaxCandies(135, 3);
    }
}
