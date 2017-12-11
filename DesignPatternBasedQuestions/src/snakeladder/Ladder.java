package snakeladder;

public class Ladder {
	private Square top;
	private Square bottom;

	public Ladder(Square top, Square bottom) {
		super();
		this.top = top;
		this.bottom = bottom;
	}
	
	public void climbLadder(Player p) {
		p.moveToSquare(this.top);
	}

	public Square getTop() {
		return top;
	}

	public void setTop(Square top) {
		this.top = top;
	}

	public Square getBottom() {
		return bottom;
	}

	public void setBottom(Square bottom) {
		this.bottom = bottom;
	}

}
