/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anand
 */
public class CalculateSteakHouses
{
    double findDistance(List  <Integer> coordinates)
    {
        int x = coordinates.get(0);
        int y = coordinates.get(1);
        return Math.sqrt((x*x + y*y));
    }
    List <List<Integer>> nearestXsteakHouses(int totalSteakHouses, 
                                             List <List<Integer>> allLocations, 
                                             int numSteakhouses)
    { 
        Map <Double, List<List <Integer>>> resultMap = new HashMap<>();
        double[] distanceArray = new double[totalSteakHouses];
        int i=0;
        for (List <Integer> coordinates : allLocations)
        {
            double distance = findDistance(coordinates);
            distanceArray[i++] = distance;
            if (resultMap.containsKey(distance)) 
            {
                resultMap.get(distance).add(coordinates);
            }
            else
            {
                List<List <Integer>>coordinatesList = new LinkedList<>();
                coordinatesList.add(coordinates);
                resultMap.put(distance, coordinatesList);
            }
        }
        Arrays.sort(distanceArray);
        List <List<Integer>> resultList = new LinkedList<>();
        
        for (int steakHouse = 0; steakHouse < numSteakhouses; steakHouse++)
        {
            resultList.add(resultMap.get(distanceArray[steakHouse]).get(0));
        }
        return resultList;
    }
    
    public static void main(String[] args)
    {
        List <List<Integer>> allLocations = new LinkedList<>();
        allLocations.add(createList(1, 2));
        allLocations.add(createList(3, 4));
        allLocations.add(createList(1, -1));
        System.out.println(new CalculateSteakHouses().nearestXsteakHouses(allLocations.size(), allLocations, 2));
    }
    
    static List<Integer> createList(int x, int y)
    {
        List<Integer> location = new LinkedList<>();
        location.add(x);
        location.add(y);
        return location;
    }
}
