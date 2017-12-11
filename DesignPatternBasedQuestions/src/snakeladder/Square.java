package snakeladder;

import java.util.ArrayList;
import java.util.List;

public class Square {
	private int number;
	List<Player> players;

	public Square(int num) {
		this.number = num;
		this.players = new ArrayList<Player>();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
