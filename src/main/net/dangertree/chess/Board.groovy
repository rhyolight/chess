package net.dangertree.chess

class Board {
    
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