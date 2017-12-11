package parkinglot;

public class LargeVehicleFareStrategy implements FareCalculationStartegy {
	private int hourlyRate = 100;

	public LargeVehicleFareStrategy(int hourlyRate) {
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
