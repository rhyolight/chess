package net.dangertree.chess.pieces

import net.dangertree.chess.pieces.move.PawnMoveStrategy

class Pawn extends Piece {
    
    Pawn() {
        moveStrategies << new PawnMoveStrategy(piece:this)
    }
}