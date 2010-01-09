package net.dangertree.chess.pieces

import net.dangertree.chess.pieces.move.KingMoveStrategy

class King extends Piece {
    
    King() {
        moveStrategies << new KingMoveStrategy(piece:this)
    }
}