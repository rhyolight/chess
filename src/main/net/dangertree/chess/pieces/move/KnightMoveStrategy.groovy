package net.dangertree.chess.pieces.move

class KnightMoveStrategy extends ChessMoveStrategy {
    
    def getPossibleMoves(origin) {
        def moves = []
        moves << board.getCell(origin, 2, 1)
        moves << board.getCell(origin, 2, -1)
        moves << board.getCell(origin, 1, 2)
        moves << board.getCell(origin, -1, 2)
        moves << board.getCell(origin, -2, 1)
        moves << board.getCell(origin, -2, -1)
        moves << board.getCell(origin, 1, -2)
        moves << board.getCell(origin, -1, -2)
        moves.findAll { it }
    }
    
}