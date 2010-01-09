package net.dangertree.chess

import net.dangertree.chess.pieces.*

class Board {
    
    static final PIECE_ORDER = 
        [   Rook.class, Knight.class, Bishop.class, Queen.class, 
            King.class, Bishop.class, Knight.class, Rook.class
        ]
        
    def cells
    
    Board() {
        this.@cells = []
        8.times { x ->
            def col = []
            8.times { y ->
                col << new Cell(x:x, y:y)
            }
            this.@cells << col
        }
    }
    
    Board(boolean loadBoard) {
        this()
        PEICE_ORDER.eachWithIndex { piece, i ->
            def whitePiece = piece.newInstance()
            getCell(i, 0).piece = whitePiece
            def blackPiece = piece.newInstance()
            blackPiece.side = 'black'
            getCell(i, 8).piece = blackPiece
        }
        8.times { i ->
            getCell(i, 1).piece = new Pawn()
            getCell(i, 7).piece = new Pawn(side:'black')
        }
    }
    
    def getCells() {
        cells.flatten()
    }
    
    def addPiece(descriptor, piece) {
        piece.board = this
        getCell(descriptor).piece = piece
    }
    
    def getPiece(descriptor) {
        getCell(descriptor).piece
    }
    
    def getPiece(x, y) {
        getCell(x, y).piece
    }
    
    def getCell(descriptor) {
        def (x, y) = translateDescriptor(descriptor)
        this.@cells[x][y]
    }
    
    def propertyMissing(String name) {
        getCell(name)
    }
    
    def getCell(x, y) {
        println "getCell($x, $y)"
        if (x > 7 || x < 0 || y > 7 || y < 0) return null
        this.@cells[x][y]
    }
    
    def getCell(cell, x, y) {
        getCell(cell.x + x, cell.y + y)
    }
    
    def getRow(cell) {
        this.@cells.collect { col ->
            col.find { it.y == cell.y }
        }
    }
    
    def getCol(cell) {
        this.@cells[cell.x]
    }
    
    def getDiagonalX(cell) {
        def xCells = []
        8.times { x ->
            8.times { y ->
                if (Math.abs(cell.x - x) == Math.abs(cell.y - y)) xCells << getCell(x, y)
            }
        }
        xCells
    }
    
    private def translateDescriptor(descriptor) {
        def x = ('A'..'H').indexOf(descriptor[0])
        def y = descriptor[1].toInteger() - 1
        [x,y]
    }
}