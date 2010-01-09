package net.dangertree.chess.pieces

import net.dangertree.chess.pieces.move.RookMoveStrategy

class Rook extends Piece {
    
    Rook() {
        moveStrategies << new RookMoveStrategy(piece:this)
    }
    
}