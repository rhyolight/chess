package net.dangertree.chess.pieces

import net.dangertree.chess.pieces.move.*

class Queen extends Piece {
    
    Queen() {
        moveStrategies << new RookMoveStrategy(piece:this)
        moveStrategies << new BishopMoveStrategy(piece:this)
    }
}