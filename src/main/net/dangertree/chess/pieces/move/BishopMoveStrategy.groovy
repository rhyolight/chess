package net.dangertree.chess.pieces.move

class BishopMoveStrategy extends ChessMoveStrategy {
    
    def getPossibleMoves(origin) {
        stripUnreachableCells(board.getDiagonalX(origin) - this.cell)
    }
    
    def stripUnreachableCells(cells) {
        def reachableCells = cells
        def occupiedCells = cells.findAll { it.piece }
        occupiedCells.each { occupied ->
            // remove same side piece cells (can't kill your own team)
            if (occupied.piece.side == this.side) {
                reachableCells -= occupied
            }
            
            // look right
            if (occupied.x > cell.x) {
                // look up
                if (occupied.y > cell.y) {
                    def outOfReach = reachableCells.findAll { 
                        it.x > occupied.x && it.y > occupied.y
                    }
                    reachableCells -= outOfReach
                }
                // down
                else {
                    def outOfReach = reachableCells.findAll { 
                        it.x > occupied.x && it.y < occupied.y
                    }
                    reachableCells -= outOfReach
                }
            } 
            // look left
            else {
                // look up
                if (occupied.y < cell.y) {
                    def outOfReach = reachableCells.findAll { 
                        it.x < occupied.x && it.y > occupied.y
                    }
                    reachableCells -= outOfReach
                }
                // down
                else {
                    def outOfReach = reachableCells.findAll { 
                        it.x > occupied.x && it.y > occupied.y
                    }
                    reachableCells -= outOfReach
                }
            }
        }
        reachableCells
    }
    
}