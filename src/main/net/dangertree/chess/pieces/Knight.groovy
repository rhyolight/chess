package net.dangertree.chess.pieces

import net.dangertree.chess.pieces.move.KnightMoveStrategy

class Knight extends Piece {
    
    Knight() {
        moveStrategies << new KnightMoveStrategy(piece:this)
    }
    
}