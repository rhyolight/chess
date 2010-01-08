package net.dangertree.chess.pieces

import net.dangertree.chess.Board

class RookTests extends GroovyTestCase {
    
    def board
    
    void setUp() {
        board = new Board()
    }
    
    void testStripUnreachableCells() {
        def rook = new Rook()
        board.addPiece('A1', rook)
        board.addPiece('C1', new Pawn())
        def cross = ((board.getRow(rook.cell) + board.getCol(rook.cell)) - rook.cell) as Set
        assertEquals 14, cross.size()
        def descriptors = cross*.descriptor
        assertTrue descriptors.contains('A2')
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('A6')
        assertTrue descriptors.contains('A7')
        assertTrue descriptors.contains('A8')
        assertTrue descriptors.contains('B1')
        assertTrue descriptors.contains('C1')
        assertTrue descriptors.contains('D1')
        assertTrue descriptors.contains('E1')
        assertTrue descriptors.contains('F1')
        assertTrue descriptors.contains('G1')
        assertTrue descriptors.contains('H1')
        
        def moves = rook.stripUnreachableCells(cross)
        assertEquals 8, moves.size()
        descriptors = cross*.descriptor
        assertTrue descriptors.contains('A2')
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('A6')
        assertTrue descriptors.contains('A7')
        assertTrue descriptors.contains('A8')
        assertTrue descriptors.contains('B1')
    }
    
}