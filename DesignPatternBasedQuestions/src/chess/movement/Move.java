package chess.movement;

import chess.pieces.Piece;

public class Move {
	MoveType moveType;  //undo operation will require the type of move
    int sourceX, sourceY;
    int destX, destY;
    Piece piece;  //at source 
    Piece killed; //at dest
    Move previous, next;
    
}
