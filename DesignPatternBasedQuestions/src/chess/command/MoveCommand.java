package chess.command;

public interface MoveCommand {
     
	public void execute(ChessBoard board, Piece p, int sx, int sy, int destx, int desty);;
	
	public void undo();
	
	public void redo ();
}
