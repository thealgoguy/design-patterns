package parkinglot;

public class SmallVehicleFareStrategy implements FareCalculationStartegy {
	private int hourlyRate = 20;

	public SmallVehicleFareStrategy(int hourlyRate) {
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
