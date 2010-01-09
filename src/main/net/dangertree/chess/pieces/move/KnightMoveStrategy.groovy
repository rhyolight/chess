package net.dangertree.chess.pieces.move

class KnightMoveStrategy extends ChessMoveStrategy {
    
    def getPossibleMoves(cell) {
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