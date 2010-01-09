package net.dangertree.chess.pieces

import net.dangertree.chess.pieces.move.ChessMoveStrategy

class Piece {
    def board
    def cell
    def side = 'white'
    def moveStrategies
    
    protected Piece() {
        moveStrategies = []
    }
    
    def getPossibleMoves() {
        Set moves = []
        moveStrategies.each {
            moves += it.getPossibleMoves(cell)
        }
        moves
    }
    
    def isWhite() { side.equals('white') }
    
    String toString() {
        "${side} ${this.class.name}"
    }
}