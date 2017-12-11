package parkinglot;

public class Bike extends Vehicle{

	public Bike(VehicleSize size, String licensePlate) {
		super(size, licensePlate);
		this.setSize(VehicleSize.SMALL);
	}
 
}
