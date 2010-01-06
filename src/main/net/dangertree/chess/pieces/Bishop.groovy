package net.dangertree.chess.pieces

import net.dangertree.chess.Cell

class Bishop extends Piece {
    
    def getPossibleMoves() {
        board.getDiagonalX(cell) - cell
    }
}