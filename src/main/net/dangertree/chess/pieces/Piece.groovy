package net.dangertree.chess.pieces

abstract class Piece {
    def board
    def cell
    def side = 'white'
    
    abstract getPossibleMoves()
    
    def isWhite() { side.equals('white') }
    
    String toString() {
        "${side} ${this.class.name}"
    }
}