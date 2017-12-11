package parkinglot;

public abstract class Vehicle {
	private VehicleSize size;
	private String licensePlate;

	public Vehicle(VehicleSize size, String licensePlate) {
		super();
		this.size = size;
		this.licensePlate = licensePlate;
	}

	public VehicleSize getSize() {
		return size;
	}

	public void setSize(VehicleSize size) {
		this.size = size;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

}
