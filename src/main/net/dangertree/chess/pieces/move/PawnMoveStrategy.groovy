package net.dangertree.chess.pieces.move

import net.dangertree.chess.Cell

class PawnMoveStrategy extends ChessMoveStrategy {
    
    def getPossibleMoves(origin) {
        def action = isWhite() ? 'plus' : 'minus'
        def moves = []
        if (isNotAtEndOfBoard()) {
            moves << new Cell(x: origin.x, y:origin.y."$action"(1))
            moves += attackMoves
        }
        if (isFirstMove()) moves << new Cell(x: origin.x, y:origin.y."$action"(2))
        moves
    }
    
    private def isFirstMove() {
        (side.equals('white') && cell.descriptor.endsWith('2')
        || side.equals('black') && cell.descriptor.endsWith('7'))
    }
    
    private def isNotAtEndOfBoard() {
        !((side.equals('white') && cell.descriptor.endsWith('8')
        || side.equals('black') && cell.descriptor.endsWith('1')))
    }
    
    private def getAttackMoves() {
        def attackRow = isWhite() ? cell.y + 1 : cell.y - 1
        if (attackRow > 8 || attackRow < 0) return []
        def attackCells = []
        (attackRowRange).each { attackCol ->
            def prey = board.getPiece(attackCol, attackRow)
            if (prey && prey.side != this.side) {
                attackCells << board.getCell(attackCol, attackRow)
            }
        }
        attackCells
    }
    
    private def getAttackRowRange() {
        (Math.max(cell.x-1, 0))..(Math.min(cell.x+1, 7))
    }
    
}