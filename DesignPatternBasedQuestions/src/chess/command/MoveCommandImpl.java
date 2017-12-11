package chess.command;

import chess.movement.Move;
import chess.pieces.Piece;

public class MoveCommandImpl implements MoveCommand{
	private Piece piece;   //receiver object on which this concrete command operates
	private Move move;

	public MoveCommandImpl(Piece piece, int sx, int sy, int destx, int desty) {
		super();
		this.piece = piece;
		//save info in movement object
	}

	@Override
	public void execute() {
		this.piece.move();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
