import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.Finishings;

public class ShortestRoute
{	
   public static void main(String[] args)
   { 				    	
		//instantiate an instance of FileIO    
		FileIO reader = new FileIO();        
		//the code below shows how to load a file
		String[] contents = reader.load("C:\\towns.txt");     
		
		Town [] towns = new Town[contents.length]; //array of town objects
		for(int i = 0; i < contents.length; i++)
		{
			towns[i] = new Town(contents[i]);
		}
				
		Solution bestSolution = null;
		for(int i = 0; i < towns.length; i++)
		{
			Solution solution = sortTowns(towns, i); // Town array	
			if(bestSolution == null || solution.getTotalDistance() < bestSolution.getTotalDistance())
			{		
				bestSolution = solution;				
			}
			System.out.println(solution.getTotalDistance());
		}
		
		System.out.println("-------------------------------------------------------");
		bestSolution.printSolution();
		
		
		System.out.println(bestSolution.getTotalDistance());
   }  
   
   public static Solution sortTowns(Town [] towns, int firstTownID)
   {		
		/* List - interface
		 LinkedList implements List
		 */	
	   List <Town> solution = new LinkedList<Town>();	   
	   List<Town> unvisited = new LinkedList<Town>();
	   double distance = 0;
	   
	   for(Town town : towns)
	   {
		   unvisited.add(town);
	   }
	   
	   Town firstTown = unvisited.get(firstTownID);
	   Town currentTown = firstTown;
	  	  
	   while (unvisited.size() > 0)
	   {
		 unvisited.remove(currentTown);
		 solution.add(currentTown);
		 		 
		 Town nextTown = currentTown.findTheNearestTown(unvisited);
		 
		 if(nextTown != null) distance += currentTown.calculateDistanceTo(nextTown) ;
		 
		 else distance += currentTown.calculateDistanceTo(firstTown);
		 
		 currentTown = nextTown;
	   }
	   
	   
	   return new Solution(solution, distance);
   }   
   
}
