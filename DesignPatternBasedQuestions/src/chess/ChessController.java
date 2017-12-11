package chess;

import chess.command.MoveCommand;
import chess.command.MoveCommandImpl;
import chess.pieces.PieceColour;
import chess.player.ComputerPlayer;
import chess.player.HumanPlayer;
import chess.player.Player;
//https://inst.eecs.berkeley.edu/~cs162/sp05/Nachos/chess.shtml
public class ChessController {
	private Player computer, human;
    private ChessBoard chessBoard;
    private boolean turn = true; //true = human starts first, false = computer starts
    private boolean gameOver = false;
    
    public void setupGame() {
    	computer = new ComputerPlayer("Computer", PieceColour.BLACK);
    	human = new HumanPlayer("Human", PieceColour.WHITE);
    	chessBoard = new ChessBoard();
    }
    
    public void startGame() {
    	setupGame();
    	while(true) {
            processTurn(human);
            if(this.chessBoard.isGameOver()) {
                System.out.println("You win !!");
                break;
            }
            processTurn(computer);
            if(this.chessBoard.isGameOver()) {
                System.out.println("You lose !!");
                break;
            }
        }
    }
    public boolean processTurn(Player p) {
 	   do{  
 		   //get input move from this player, validate the move and pass to the board
            MoveCommand cmd = new MoveCommandImpl(input);
            p.addCommand(cmd);
        }while(!chessBoard.executeMove(p));
   }
}
