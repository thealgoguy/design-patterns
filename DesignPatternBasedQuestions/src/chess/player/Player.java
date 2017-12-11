package chess.player;

import java.util.ArrayList;
import java.util.List;

import chess.command.MoveCommand;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.PieceColour;
import chess.pieces.Queen;
import chess.pieces.Rook;

public abstract class Player {
	protected String name;
	protected PieceColour colour;
	
	protected List<Piece> livePieces;  	//list of live piece reference it owns.
	protected List<MoveCommand> commands;   //list of commands history for undo/redoing moves

	public Player() {
		super();
		this.livePieces = new ArrayList<Piece>();
		this.commands = new ArrayList<MoveCommand>();
	}
	
	public void addCommand(MoveCommand cmd) {
		commands.add(cmd);
	}
    
	public void initilaPieces() {
		PieceColour colour = this.colour;
		
		if(colour == PieceColour.WHITE) {
			int row = 1;
			// draw pawns
			for(int i=0; i<8; i++){ 
				livePieces.add(new Pawn(row, i, colour));
	        }
			//draw other pieces
			row--;
			livePieces.add(new Rook(row, 0, colour));
			livePieces.add(new Rook(row, 7, colour));
			livePieces.add(new Knight(row, 1, colour));
			livePieces.add(new Knight(row, 6, colour));
			livePieces.add(new Bishop(row, 2, colour));
			livePieces.add(new Bishop(row, 5, colour));
			livePieces.add(new Queen(row, 3, colour));
			livePieces.add(new King(row, 4, colour));
		}
		else {
			int row = 62;
			// draw pawns
			for(int i=0; i<8; i++){ 
				livePieces.add(new Pawn(row, i, colour));
	        }
			//draw other pieces
			row++;
			livePieces.add(new Rook(row, 0, colour));
			livePieces.add(new Rook(row, 7, colour));
			livePieces.add(new Knight(row, 1, colour));
			livePieces.add(new Knight(row, 6, colour));
			livePieces.add(new Bishop(row, 2, colour));
			livePieces.add(new Bishop(row, 5, colour));
			livePieces.add(new Queen(row, 3, colour));
			livePieces.add(new King(row, 4, colour));
		}	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PieceColour getColour() {
		return colour;
	}

	public void setColour(PieceColour colour) {
		this.colour = colour;
	}

	public List<Piece> getLivePieces() {
		return livePieces;
	}

	public void setLivePieces(List<Piece> livePieces) {
		this.livePieces = livePieces;
	}

	

}
