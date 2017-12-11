package chess.movement.strategy;

import java.util.ArrayList;
import java.util.List;

import chess.ChessBoard;
import chess.SquareSpot;
import chess.movement.MoveType;
import chess.pieces.Piece;
import chess.pieces.PieceType;

public class KingMovementStrategy implements MovementStrategy{

	@Override
	public List<SquareSpot> getPossibleMoves(ChessBoard board, Piece p) {
		SquareSpot spots[][] = board.getSpot();
		List<SquareSpot> possibleMoves = new ArrayList<SquareSpot>();
		List<SquareSpot> moves = new ArrayList<SquareSpot>();
	    int[][] offsets = {
	        {1, 0},
	        {0, 1},
	        {-1, 0},
	        {0, -1},
	        {1, 1},
	        {-1, 1},
	        {-1, -1},
	        {1, -1}
	    };
	    for (int[] o : offsets) {
	    	SquareSpot square = spots[p.xCoordinate+o[0]][p.yCoordinate+o[1]];
	        if (square != null && (square.getPiece() == null || p.isOpponent(square.getPiece()))) {
	            moves.add(square);
	        }
	    }
	    possibleMoves.addAll(moves);
	    if (getSquare().isSelected()) {
	        Piece[] pieces = {
	            PieceType.PAWN.create(getPieceColor()),
	            PieceType.ROOK.create(getPieceColor()),
	            PieceType.BISHOP.create(getPieceColor()),
	            PieceType.KNIGHT.create(getPieceColor()),
	            PieceType.QUEEN.create(getPieceColor()),
	            PieceType.KING.create(getPieceColor())};
	        Piece oldKing = this;
	        getSquare().removePiece();
	        for (Square kingMove : moves) {
	            if (kingMove.isEmpty()) {
	                for (Piece piece : pieces) {
	                    piece.putPieceOnSquareFirstTime(kingMove);
	                    piece.generatePossibleMoves();
	                    for (Square enemy : piece.getPossibleMoves()) {
	                        if (!enemy.isEmpty() && enemy.getPiece().isOpponent(piece) && enemy.getPiece().getTypeNumber() == piece.getTypeNumber()) {
	                            enemy.setBackground(Color.BLUE);
	                            possibleMoves.remove(kingMove);
	                            break;
	                        }
	                    }
	                }
	                kingMove.removePiece();
	            } else if (isOpponent(kingMove.getPiece())) {
	                Piece oldPiece = kingMove.getPiece();
	                for (Piece piece : pieces) {
	                    kingMove.removePiece();
	                    piece.putPieceOnSquareFirstTime(kingMove);
	                    piece.generatePossibleMoves();
	                    for (Square square1 : piece.getPossibleMoves()) {
	                        if (!square1.isEmpty() && square1.getPiece().isOpponent(piece) && square1.getPiece().getTypeNumber() == piece.getTypeNumber()) {
	                            possibleMoves.remove(kingMove);
	                            break;
	                        }
	                    }
	                }
	                kingMove.removePiece();
	                oldPiece.putPieceOnSquareFirstTime(kingMove);
	            }
	        }
	        oldKing.putPieceOnSquareFirstTime(getSquare());
	    }
	    return possibleMoves;
	}

	@Override
	public MoveType validateMove(ChessBoard board, Piece p, int destx, int desty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MoveType move(ChessBoard board, Piece p, int destx, int desty) {
		// TODO Auto-generated method stub
		return null;
		
	}



}
