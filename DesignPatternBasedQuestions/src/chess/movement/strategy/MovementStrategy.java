package chess.movement.strategy;

import java.util.List;

import chess.ChessBoard;
import chess.SquareSpot;
import chess.movement.MoveType;
import chess.pieces.Piece;

//defines various algorithms for movement based on Piece type
//https://codereview.stackexchange.com/questions/53875/generating-possible-chess-moves
//Move types should also be captured in move method
public interface MovementStrategy {
	public List<SquareSpot> getPossibleMoves(ChessBoard board, Piece p);
	//return whether it is a normal move for the piece or illegal or some special move(en passant for pawn, castling or double-step)
	public MoveType validateMove(ChessBoard board, Piece p, int destx, int desty);
	//should return what type of move was made..so that same can be reversed on undoing
    public MoveType move(ChessBoard board, Piece p, int destx, int desty);
}
