package snakeladder;

import java.util.ArrayList;
import java.util.List;

//request mapping to start the game
public class SnakeLadderGameController {
    private GameBoard board;
    private static final int numberOfSquares = 25;
    private static final int numberOfPlayers = 2;
    private List<Player> players;
    
    public void setUpBoard() {
    	players = new ArrayList<Player>();
    	Player p1 = new Player("A", board);
    	Player p2 = new Player("B", board);
    	players.add(p1); players.add(p2);
    	board = new GameBoard(numberOfSquares, players);          
    }
    
    public void playGame() {
    	board.playGame();
    }
    
    public static void main(String args []) {
    	SnakeLadderGameController gc = new SnakeLadderGameController();
    	gc.setUpBoard();
    	gc.playGame();
    }
    
}
