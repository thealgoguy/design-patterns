package parkinglot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ParkingLot {
    private int total;
    private int small;
    private int medium;
    private int large;
    
    private PriorityQueue<ParkingSpot> smallSpots;
    private PriorityQueue<ParkingSpot> mediumSpots;
    private PriorityQueue<ParkingSpot> largeSpots;
    private Map<String, ParkingSpot> occupiedSpots; //for fast look-up of PS based on vehicle's license no.
    
  //strategy or policy for parking different types of vehicles....
  //concrete strategy to be passed by Controller
    private ParkingStartegy parkingStartegy;       
    public ParkingLot(int total, int small, int medium, int large) {
    	this.small = small;
    	this.medium = medium;
    	this.large = large;
    	this.total = total;
    	createSpots();
    }
    
    private class ParkingSpotComparator implements Comparator<ParkingSpot> {
        @Override
        public int compare(ParkingSpot ps1, ParkingSpot ps2) {
            if (ps1.getNumber() < ps2.getNumber())
                return -1;
            else if (ps1.getNumber() > ps2.getNumber()){
                return 1;
            }
            return 0;
        }        
    }
    
    private void createSpots() {
    	ParkingSpotComparator comparator = new ParkingSpotComparator();
    	this.smallSpots = new PriorityQueue<ParkingSpot>(this.small, comparator);
    	for(int i=0; i<small; i++) {
    		smallSpots.add(new SmallParkingSpot());
    	}
    	this.mediumSpots = new PriorityQueue<ParkingSpot>(this.medium, comparator);
    	for(int i=0; i<medium; i++) {
    		mediumSpots.add(new MediumParkingSpot());
    	}
    	this.largeSpots = new PriorityQueue<ParkingSpot>(this.large, comparator);
    	for(int i=0; i<large; i++) {
    		this.largeSpots.add(new LargeParkingSpot());
    	}
    	//empty map for looking-up occupied spots
    	this.occupiedSpots = new HashMap<String, ParkingSpot>();
    }
    
    //check if empty spot available, get it and mark occupied
    public ParkingSpot getEmptySpot(Vehicle v) {
    	ParkingSpot ps = null;
    	switch(v.getSize()) {
    	case SMALL :
    		ps = (smallSpots.size() == 0) ? null : smallSpots.poll();
    		break;
    	case MEDIUM :
    		ps = (mediumSpots.size() == 0) ? null : mediumSpots.poll();
    		break;
    	case LARGE :
    		ps = (largeSpots.size() == 0) ? null : largeSpots.poll();
    	}
    	occupiedSpots.put(v.getLicensePlate(), ps);
    	return ps;
    }
    
    //park the vehicle v at the spot ps
    public void parkVehicle(ParkingSpot ps, Vehicle v) {
    	ps.parkVehicle(v);
    }
    
    //search the spot and unpark the vehicle
    public ParkingSpot unparkVehicle(ParkingTicket ticket) {
        String licensePlate = ticket.getLicensePlate();
        ParkingSpot ps = occupiedSpots.get(licensePlate);
        ps.unparkVehicle();
        return ps;
    }
    
}
