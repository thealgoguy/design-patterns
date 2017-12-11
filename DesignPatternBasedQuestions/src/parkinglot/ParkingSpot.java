package parkinglot;


public abstract class ParkingSpot{
	private int level;
	private static int number;
	private int row, col;
	private boolean occupied = false;
	private Vehicle vehicle;
	private String type;   //handicapped or normal......can keep different strategy

	public ParkingSpot() {
		this.number++;
	}

	public abstract void parkVehicle(Vehicle v);

	public abstract void unparkVehicle();

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public static int getNumber() {
		return number;
	}

	public static void setNumber(int number) {
		ParkingSpot.number = number;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
