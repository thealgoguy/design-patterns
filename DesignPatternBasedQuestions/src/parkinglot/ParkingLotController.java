package parkinglot;

//https://discuss.leetcode.com/topic/94763/parking-lot-design-using-oo-design/4
//http://massivetechinterview.blogspot.in/2015/07/cc150v5-84-design-parking-lot.html
//Exercise : multiple levels, handicapped/normal....check for extensibility
//Handle concurrency
public class ParkingLotController {
	//private static final int levels = 3;
    private static final int totalSpots = 100;
    private static final int smallSpots = 50;
    private static final int mediumSpots = 30;
    private static final int largeSpots = 20;
    
    ParkingLot parkingLot;                //concerns with parking and unparking a vehicle
    FareCalculationHelper fareCalulator;  //concerns with fare calculation based on various strategies
    
    public void createParkingLot() {
    	System.out.println("initilaizing the parking lot");
    	parkingLot = new ParkingLot(100, 50, 30, 20);
    	fareCalulator = new FareCalculationHelper(new SmallVehicleFareStrategy(20), new MediumVehicleFareStrategy(40), new LargeVehicleFareStrategy(80));
    }
    
    //on parking a vehicle, system should generate a ticket for the driver
    public ParkingTicket parkVehicle(Vehicle v) {
    	ParkingSpot ps = parkingLot.getEmptySpot(v);
    	if(ps == null) {
    		System.out.println("Sorry !! No slot available for parking.");
    		return null;
    	}
    	else {
    		//generate ticket with entry time, license no and then park the vehicle
    		ParkingTicket ticket = new ParkingTicket(ps, v.getLicensePlate());
    		printTicket(ticket);
    		ps.parkVehicle(v);
    		return ticket;
    	}
    }
    
    //the driver will show the ticket and using this vehicle is to be unparked
    public ParkingTicket unparkVehicle(ParkingTicket ticket) {
    	ticket.setCheckOutTime((long) (System.currentTimeMillis()/1E3));
    	ParkingSpot ps = parkingLot.unparkVehicle(ticket);
    	long parkingFare = fareCalulator.calculateFare(ticket);
    	ticket.setParkingFare(parkingFare);
    	return ticket;
    }
    
    public void printTicket(ParkingTicket ticket) {
    	System.out.println("Ticket generated : "+ticket);
    }
}
