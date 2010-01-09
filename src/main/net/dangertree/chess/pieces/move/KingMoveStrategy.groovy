package net.dangertree.chess.pieces.move

class KingMoveStrategy extends ChessMoveStrategy {
    
    def getPossibleMoves(origin) {
        def moves = []
        (origin.x-1 .. origin.x+1).each { hor ->
            (origin.y-1 .. origin.y+1).each { ver ->
                def moveCell = board.getCell(hor, ver)
                if (!moveCell) return
                if (moveCell.piece == null || moveCell.piece.side != this.side) {
                    moves << moveCell
                }
            }
        }
        moves
    }
    
}