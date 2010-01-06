package net.dangertree.chess

import net.dangertree.chess.pieces.*

class ChessTests extends GroovyTestCase {
    
    void testNewCellAndPiece() {
        def cell = new Cell(descriptor:'A2')
        assertEquals 'A2', cell.descriptor
        def pawn = new Pawn()
        assertEquals 'Default side should be white', 'white', pawn.side
        cell.piece = pawn
        assertSame 'Cell piece assignment should also assign cell to piece', cell, pawn.cell
    }
    
}