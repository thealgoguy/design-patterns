package parkinglot;

public class FareCalculationHelper {
   private FareCalculationStartegy smallVehicleFareStrategy;
   private FareCalculationStartegy mediumVehicleFareStrategy;
   private FareCalculationStartegy largeVehicleFareStrategy;
   
   public FareCalculationHelper(
		FareCalculationStartegy smallVehicleFareStrategy,
		FareCalculationStartegy mediumVehicleFareStrategy,
		FareCalculationStartegy largeVehicleFareStrategy) {
	super();
	this.smallVehicleFareStrategy = smallVehicleFareStrategy;
	this.mediumVehicleFareStrategy = mediumVehicleFareStrategy;
	this.largeVehicleFareStrategy = largeVehicleFareStrategy;
}

   //fare based on vehicle size and length of parking duration
public int calculateFare(ParkingTicket ticket) {
	   VehicleSize vehicleSize = ticket.getParkingSpot().getVehicle().getSize();
	   long timeInMinutes = (ticket.getCheckOutTime()-ticket.getCheckInTime())/60;
	   int fare = 0;
	   switch(vehicleSize) {
	   case SMALL :
		   fare = smallVehicleFareStrategy.calculateFare(timeInMinutes);
		   break;
	   case MEDIUM :
		   fare = mediumVehicleFareStrategy.calculateFare(timeInMinutes);
		   break;
	   case LARGE :
		   fare = largeVehicleFareStrategy.calculateFare(timeInMinutes);
		   break;
	   }
	   return fare;
   }
   
}
