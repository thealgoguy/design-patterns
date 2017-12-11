package parkinglot;

public class MediumParkingSpot extends ParkingSpot{
	ParkingStartegy startegy;     //concrete strategy to be provided by the ParkingLot class

	public MediumParkingSpot() {
		super();
	}

	@Override
	public void parkVehicle(Vehicle v) {
		this.setVehicle(v);
		this.setOccupied(true);
	}

	@Override
	public void unparkVehicle() {
		this.setVehicle(null);
		this.setOccupied(false);
	}
}
