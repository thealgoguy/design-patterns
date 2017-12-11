package snakeladder;

public class Snake {
	private Square head;
	private Square tail;

	public Snake(Square head, Square tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

	public void movePlayerToTail(Player p) {
		p.moveToSquare(this.tail);
	}

	public Square getHead() {
		return head;
	}

	public void setHead(Square head) {
		this.head = head;
	}

	public Square getTail() {
		return tail;
	}

	public void setTail(Square tail) {
		this.tail = tail;
	}

}
