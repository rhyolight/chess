package net.dangertree.chess.pieces

import net.dangertree.chess.Cell

class Rook extends Piece {
    
    def getPossibleMoves() {
        def horizontal = board.getRow(cell) - cell
        def vertical = board.getCol(cell) - cell
        horizontal + vertical
    }
}