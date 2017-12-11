package parkinglot;

public class Car extends Vehicle{

	public Car(VehicleSize size, String licensePlate) {
		super(size, licensePlate);
		this.setSize(VehicleSize.MEDIUM);
	}

}
