package snakeladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard {
	private int noOfSquares;
	private List<Square> square;
	private Map<Integer, Integer> snake;
	private Map<Integer, Integer> ladder;
	private List<Player> players;
	private Dice dice;
	
	public GameBoard(int noOfSquares, List<Player> players) {
		super();
		this.noOfSquares = noOfSquares;
		this.players = players;
		makeSquares();
		makeSnakesAndLadders();
		placePlayersAtHome();
		displayBoard();
		dice = new Dice();
	}
	public void displayBoard() {
		int rows = (int) Math.sqrt(noOfSquares);
		for(int index=1;index<=noOfSquares; index++) {
			List<Player> players = square.get(index).getPlayers();
			if(players.size() > 0) {
				System.out.print("[");
				for(Player p : players) {
					System.out.print(p.getName()+",");
				}
				System.out.print("] ");
			}
			else {
				System.out.print(index+"       ");
			}
			if(index % rows == 0) System.out.println();
		}
	}
	
	public void playGame() {
		while(true) {
			for(Player p : players) {
				int diceValue = dice.getRandom();
				System.out.println("Player "+p.getName()+"'s turn  : "+diceValue);
				int target = p.getCurrentPosition().getNumber() + diceValue;
				System.out.println("target = "+target+" max = "+noOfSquares);
				if(target > noOfSquares) continue;
				else if(target == noOfSquares) {
					//game over for this player
					System.out.println("Player : "+p.getName()+" reached....");
					p.getCurrentPosition().players.remove(p);  //p leaves the game
					players.remove(p);
				}
				else {
					//go to target
					p.getCurrentPosition().players.remove(p); 
					p.setCurrentPosition(square.get(target));					
					//check for snakes or ladders					
					if(snake.containsKey(target)) {
						target = snake.get(target);
					}
					else if(ladder.containsKey(target)) {
						target = ladder.get(target);
					}
					Square targetSquare = square.get(target);
					p.setCurrentPosition(targetSquare);
					targetSquare.players.add(p);
				}
				//print board after each player's move
				displayBoard();
				System.out.println();
			}
		}
	}

	public void makeSquares() {
		square = new ArrayList<Square>();
		square.add(new Square(0));  //dummy node...actual count starts from 1
		for(int count=1; count<=noOfSquares;  count++) {
		    square.add(new Square(count));
		}
	}
	public void makeSnakesAndLadders() {
		snake = new HashMap<Integer, Integer>();
		ladder = new HashMap<Integer, Integer>();
		
		snake.put(25, 5);
		snake.put(40, 4);
		snake.put(95, 10);
		snake.put(90, 50);

		ladder.put(12, 30);
		ladder.put(36, 60);
		ladder.put(56, 75);
		ladder.put(80, 100);
	}
	//add each player to the first square and 
	//the first square as current pos of every player
	public void placePlayersAtHome() {
		for(Player p : players) {
			square.get(1).players.add(p);
			p.setCurrentPosition(square.get(1));
		}
	}

}
