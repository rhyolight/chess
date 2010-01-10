package net.dangertree.chess

class Cell {
    def piece
    def x, y
    
    void setPiece(piece) {
        this.piece = piece
        if (piece) piece.cell = this
    }
    
    def getDescriptor() {
        ('A'..'H')[x] + (y + 1)
    }
    
    void setDescriptor(descriptor) {
        def letterX = descriptor[0]
        x = ('A'..'H').indexOf(letterX)
        y = descriptor[1].toInteger() - 1
    }
    
    String toString() {
        "Cell ${descriptor} [${x},${y}] (${piece})"
    }
}