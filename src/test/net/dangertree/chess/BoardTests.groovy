package net.dangertree.chess

import net.dangertree.chess.pieces.*

class BoardTests extends GroovyTestCase {

    def board
    
    void setUp() {
        board = new Board()
    }
    
    void testNewBoardPopulatesAllCells() {
        assertNotNull 'Board has null list of cells', board.cells
        assertEquals 'Board has wrong number of cells', 64, board.cells.size()
        board.cells.each { cell ->
            assertNotNull 'Board contains null cell', cell
            assertTrue 'Board cell is not really a Cell', cell instanceof Cell
        }
    }

    void testFullBoardCreation() {
        board = new Board(true)
        def pieceOrder = Board.PIECE_ORDER
        ('A'..'G').eachWithIndex { letter, i ->
            def whitePawn = board["${letter}2"].piece
            def whitePiece = board["${letter}1"].piece
            assertEquals Pawn.class, whitePawn.class
            assertSame board, whitePawn.board
            assertEquals pieceOrder[i], whitePiece.class
            assertEquals 'white', whitePiece.side
            
            def blackPawn = board["${letter}7"].piece
            def blackPiece = board["${letter}8"].piece
            assertEquals Pawn.class, blackPawn.class
            assertSame board, blackPiece.board
            assertEquals pieceOrder[i], blackPiece.class
            assertEquals 'black', blackPiece.side
        }
        println board.cells
    }
    
    void testAddPieceToBoard() {
        board.addPiece('A2', new Pawn())
        def pawn = board.getPiece('A2')
        assertSame 'Board cell and piece cell were different', board.getCell('A2'), pawn.cell
        assertNotNull 'Piece was not given reference to board', pawn.board
        assertSame 'Piece was not given reference to correct board', board, pawn.board
    }
    
    void testGetPiece() {
        assertNull board.getPiece(0, 0)
        board.addPiece('A1', new Pawn())
        assertNotNull board.getPiece(0, 0)
    }
    
    void testGetCell() {
        def cell = board.getCell(0,0)
        assertNotNull cell
        assertTrue cell instanceof Cell
        assertEquals 'A1', cell.descriptor
    }
    
    void testGetRowOfCell() {
        def cell = board.getCell(0,0)
        def wholeRow = board.getRow(cell)
        assertNotNull wholeRow
        assertEquals 8, wholeRow.size()
        def descriptors = wholeRow*.descriptor
        assertTrue descriptors.contains('A1')
        assertTrue descriptors.contains('B1')
        assertTrue descriptors.contains('C1')
        assertTrue descriptors.contains('D1')
        assertTrue descriptors.contains('E1')
        assertTrue descriptors.contains('F1')
        assertTrue descriptors.contains('G1')
        assertTrue descriptors.contains('H1')
    }
    
    void testGetColOfCell() {
        def cell = board.getCell(0,0)
        def wholeRow = board.getCol(cell)
        assertNotNull wholeRow
        assertEquals 8, wholeRow.size()
        def descriptors = wholeRow*.descriptor
        assertTrue descriptors.contains('A1')
        assertTrue descriptors.contains('A2')
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('A6')
        assertTrue descriptors.contains('A7')
        assertTrue descriptors.contains('A8')
    }
    
    void testGetDiagonalX() {
        def cell = board.getCell(0,0)
        def x = board.getDiagonalX(cell)
        assertNotNull x
        assertEquals 8, x.size()
        def descriptors = x*.descriptor
        assertTrue descriptors.contains('A1')
        assertTrue descriptors.contains('B2')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('D4')
        assertTrue descriptors.contains('E5')
        assertTrue descriptors.contains('F6')
        assertTrue descriptors.contains('G7')
        assertTrue descriptors.contains('H8')
    }
    
    void testGetCellByCoordinatesAndSourceCell() {
        def cell = board.getCell('D4')
        assertSame board.getCell('E4'), board.getCell(cell, 1, 0)
        assertSame board.getCell('E5'), board.getCell(cell, 1, 1)
        assertSame board.getCell('D5'), board.getCell(cell, 0, 1)
        assertSame board.getCell('C5'), board.getCell(cell, -1, 1)
        assertSame board.getCell('C4'), board.getCell(cell, -1, 0)
        assertSame board.getCell('C3'), board.getCell(cell, -1, -1)
        assertSame board.getCell('D3'), board.getCell(cell, 0, -1)
        assertSame board.getCell('E3'), board.getCell(cell, 1, -1)
        assertNull board.getCell(cell, -4, 0)
    }
    
    void testMovePiece() {
        board = new Board(true)
        board.move('A2', 'A4')
        assertNull board.getPiece('A2')
        assertNotNull board.getPiece('A4')
        assertTrue board.getPiece('A4') instanceof Pawn
        println board.cells
    }
    
    void testMovePiece_throwsException_onImpossibleMove() {
        board = new Board(true)
        def msg = shouldFail(Exception) {
            board.move('A2', 'B5')
        }
    }
}