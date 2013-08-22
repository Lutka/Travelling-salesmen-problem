
public class DistanceCalculator
{
	/**
	 * Method takes GPS coordinates of two town and calculate distance between them
	 * @return distance in km 
	 *  latitide1, longitude1, latitude2, longitude2
	 */
	public static double distance(double latit1, double longit1, double latit2, double longit2)
	{
		double latitude1 = Math.toRadians(latit1); //latitude of the first location
		double latitude2 = Math.toRadians(latit2);	//latitude of the second location
		
		double longitude1 = Math.toRadians(longit1); //longitude of the first location
		double longitude2 = Math.toRadians(longit2); //longitude of the second location
		
		double radiusOfEarth = 6371; //km
		double distance;
		
		double sinSquaredLatitude = Math.pow(Math.sin((latitude1-latitude2)/2),2);
		double cosCalculations = Math.cos(latitude1)*Math.cos(latitude2);
		double sinSquaredLongitude = Math.pow(Math.sin((longitude1-longitude2)/2),2);
		
		distance = 2*radiusOfEarth * Math.asin(Math.sqrt(sinSquaredLatitude + cosCalculations * sinSquaredLongitude));
		
		//distance = Math.round(distance);
		return distance;
		
		//System.out.println("Distance is: "+distance+"km");
	}
}