package net.dangertree.chess.pieces.move

class RookMoveStrategy extends ChessMoveStrategy {
    
    def getPossibleMoves(cell) {
        def horizontal = stripUnreachableCells(board.getRow(cell) - cell)
        def vertical = stripUnreachableCells(board.getCol(cell) - cell)
        horizontal + vertical
    }
    
    def stripUnreachableCells(cells) {
        def reachableCells = cells
        def occupiedCells = cells.findAll { it.piece }
        occupiedCells.each { occupied ->
            // remove same side piece cells (can't kill your own team)
            if (occupied.piece.side == piece.side) {
                reachableCells -= occupied
            }
            // look to the right
            if (occupied.x > cell.x) {
                def outOfReach = reachableCells.findAll { it.x > occupied.x }
                reachableCells -= outOfReach
            }
            // look to the left
            if (occupied.x < cell.x) {
                def outOfReach = reachableCells.findAll { it.x < occupied.x }
                reachableCells -= outOfReach
            }
            // look up
            if (occupied.y > cell.y) {
                def outOfReach = reachableCells.findAll { it.y > occupied.y }
                reachableCells -= outOfReach
            }
            // look down
            if (occupied.y < cell.y) {
                def outOfReach = reachableCells.findAll { it.y < occupied.y }
                reachableCells -= outOfReach
            }
        }
        reachableCells
    }
    
}