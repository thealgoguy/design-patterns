package parkinglot;

public class Bus extends Vehicle{

	public Bus(VehicleSize size, String licensePlate) {
		super(size, licensePlate);
		this.setSize(VehicleSize.LARGE);
	}

}
