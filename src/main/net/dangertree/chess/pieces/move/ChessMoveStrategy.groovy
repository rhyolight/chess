package net.dangertree.chess.pieces.move

class ChessMoveStrategy {
    
    def piece
    
    def getBoard() {
        piece.board
    }
    
    def getCell() {
        piece.cell
    }
    
    def getSide() {
        piece.side
    }
    
    def isWhite() {
        piece.isWhite()
    }
    
}