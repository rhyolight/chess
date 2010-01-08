package net.dangertree.chess.pieces

import net.dangertree.chess.Cell

class Knight extends Piece {
    
    def getPossibleMoves() {
        def moves = []
        moves << board.getCell(cell, 2, 1)
        moves << board.getCell(cell, 2, -1)
        moves << board.getCell(cell, 1, 2)
        moves << board.getCell(cell, -1, 2)
        moves << board.getCell(cell, -2, 1)
        moves << board.getCell(cell, -2, -1)
        moves << board.getCell(cell, 1, -2)
        moves << board.getCell(cell, -1, -2)
        moves.findAll { it }
    }
    
}