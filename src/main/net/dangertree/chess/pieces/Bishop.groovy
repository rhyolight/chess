package net.dangertree.chess.pieces

import net.dangertree.chess.pieces.move.BishopMoveStrategy

class Bishop extends Piece {
    
    Bishop() {
        moveStrategies << new BishopMoveStrategy(piece:this)
    }
}