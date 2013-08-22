import java.util.List;
/**
 * 
 * This class store total distance and the order in which the towns were visited
 *
 */

public class Solution
{
	List <Town> orderedTowns;
	private double totalDistance;
	
	public Solution(List <Town> orderedTowns, double totalDistance)
	{
		this.orderedTowns = orderedTowns; 
		this.totalDistance = totalDistance;
	}
	
	public double getTotalDistance() //sie napisalo samo
	{
		return totalDistance;
	}
	
	public void printSolution()
	{		
		for(Town town : orderedTowns)
		{
			System.out.print(town+".");
		}
		System.out.println();
	}	
	
}
