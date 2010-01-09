package net.dangertree.chess.pieces.move

class KingMoveStrategy extends ChessMoveStrategy {
    
    def getPossibleMoves(cell) {
        def moves = []
        (cell.x-1 .. cell.x+1).each { hor ->
            (cell.y-1 .. cell.y+1).each { ver ->
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