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
        PIECE_ORDER.eachWithIndex { piece, i ->
            def whitePiece = piece.newInstance()
            whitePiece.board = this
            getCell(i, 0).piece = whitePiece
            def blackPiece = piece.newInstance()
            blackPiece.board = this
            blackPiece.side = 'black'
            getCell(i, 7).piece = blackPiece
        }
        8.times { i ->
            getCell(i, 1).piece = new Pawn(board: this)
            getCell(i, 6).piece = new Pawn(side:'black', board: this)
        }
    }
    
    def move(from, to) {
        def mover = getPiece(from)
        def toCell = getCell(to)
        def moves = mover.possibleMoves
        if (!moves*.descriptor.contains(to)) {
            throw new Exception("Piece cannot move there.")
        }
        mover.cell = toCell
        toCell.piece = mover
        getCell(from).piece = null
    }
    
    def getCells() {
        cells.flatten()
    }
    
    def getPieces() {
        def pieces = []
        this.@cells.each { row ->
            row.each {
                if (it.piece) pieces << it.piece
            }
        }
        pieces
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