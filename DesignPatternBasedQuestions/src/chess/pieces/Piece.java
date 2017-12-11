package chess.pieces;

import java.util.List;

import chess.ChessBoard;
import chess.SquareSpot;
import chess.movement.MoveType;
import chess.movement.strategy.MovementStrategy;


//A Piece can be : Bishop, Elephant, Horse, King, Queen, Pawn  (3 animals + 3 humans)
//Colour : Black or White
//APIs : occupy a spot, attack opponent piece
public abstract class Piece {
	public PieceColour colour;
	public PieceType type;
	public int xCoordinate, yCoordinate;
	//movement strategy for the piece, concrete strategy to be passed by ChessBoard at run time
	protected MovementStrategy movementStartegy;
	protected List<SquareSpot> possibleMoves;
	public boolean isOpponent;

	public Piece() {
		super();
	}
	
	public Piece (PieceColour colour) {
		this.colour = colour;
	}
	public boolean isOpponent(Piece p) {
		return this.colour != p.colour;
	}
	
	//on clicking on a piece, the possible moves will be highlighted on the board
	public  List<SquareSpot> getPossibleMoves(ChessBoard board) {
		return movementStartegy.getPossibleMoves(board, this);
	}
	//validate against the rules the chosen move for the piece : ILLEGAL, NORMAL, CASTLE, DOUBLESTEP, ENPASSANT 
	public MoveType validateMove(ChessBoard board, int destX, int destY) {
		return movementStartegy.validateMove(board, this, destX, destY);
	}
    //move to the destination spot on the board
	public MoveType move(ChessBoard board, int destX, int destY) {
		return movementStartegy.move(board, this, destX, destX);
	}

	public void setMovementStartegy(MovementStrategy movementStartegy) {
		this.movementStartegy = movementStartegy;
	}

	public PieceColour getColour() {
		return colour;
	}

	public PieceType getType() {
		return type;
	} 

}
