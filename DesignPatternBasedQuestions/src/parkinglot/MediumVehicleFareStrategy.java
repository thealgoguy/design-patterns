package parkinglot;

public class MediumVehicleFareStrategy implements FareCalculationStartegy {
	private int hourlyRate = 50;

	public MediumVehicleFareStrategy(int hourlyRate) {
		super();
		this.hourlyRate = hourlyRate;
	}

	@Override
	public int calculateFare(long minutes) {
		// considering fare strategy based on vehicle size and time only
		long hours = minutes / 60;
		return (int) (hourlyRate * hours);
	}
}
