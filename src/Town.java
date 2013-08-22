import java.util.List;


public class Town
{
	String name;
	double latitude, longitude;
	int id;
	
	public Town(String data)
	{
		String array[] = data.split(",");
		id = Integer.parseInt(array[0]);
		name = array[1];
		latitude = Double.parseDouble(array[2]);
		longitude = Double.parseDouble(array[3]);
	}	
	public double calculateDistanceTo(Town anotherTown)
	{
		return DistanceCalculator.distance(latitude, longitude, anotherTown.latitude, anotherTown.longitude);
	}
	
	@Override
	public String toString()
	{
		return Integer.toString(id);
//		return name;
	}
	/**
	 * Takes whole list and returns the nearest town to particular town
	 */
	public Town findTheNearestTown(List<Town> unvisited)
	{
		double shortestDistance = Double.POSITIVE_INFINITY;
		Town nearestTown = null;
		
		for(Town town : unvisited) if (town != this)
		{			
			double distance = calculateDistanceTo(town);
			
			if(distance < shortestDistance)
			{
				shortestDistance = distance;
				nearestTown = town;
			}			
		}
		return nearestTown;
	}

}
