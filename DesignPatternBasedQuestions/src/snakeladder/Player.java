package snakeladder;

public class Player {
	private String name;
	private Square currentPosition;
	private GameBoard board;

	public Player(String name, GameBoard board) {
		super();
		this.name = name;
		this.board = board;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Square getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Square currentPosition) {
		this.currentPosition = currentPosition;
	}

	public GameBoard getBoard() {
		return board;
	}

	public void setBoard(GameBoard board) {
		this.board = board;
	}
	
	public void moveToSquare(Square s) {
		this.currentPosition = s;
		//set this player to this square
	}

}
