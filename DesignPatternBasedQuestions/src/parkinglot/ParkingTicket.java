package parkinglot;

public class ParkingTicket {

	private int ticketNumber;
	ParkingSpot parkingSpot; // spot assigned to vehicle is assigned
	private String licensePlate; // will be mentioned on ticket
	private long checkInTime; // entry time in minutes
	private long checkOutTime;
	private long parkingFare;

	public ParkingTicket(ParkingSpot ps, String licensePlate) {
		super();
		this.ticketNumber++;
		this.parkingSpot = ps;
		this.licensePlate = licensePlate;
		this.checkInTime = (long) (System.currentTimeMillis() / 1E3);
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public long getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(long checkInTime) {
		this.checkInTime = checkInTime;
	}

	public long getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(long checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public long getParkingFare() {
		return parkingFare;
	}

	public void setParkingFare(long parkingFare) {
		this.parkingFare = parkingFare;
	}

	@Override
	public String toString() {
		return "ParkingTicket [ticketNumber=" + ticketNumber + ", parkingSpot="
				+ parkingSpot + ", licensePlate=" + licensePlate
				+ ", checkInTime=" + checkInTime + ", checkOutTime="
				+ checkOutTime + ", parkingFare=" + parkingFare + "]";
	}

}
