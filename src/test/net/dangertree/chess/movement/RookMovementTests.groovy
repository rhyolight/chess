package net.dangertree.chess

import net.dangertree.chess.pieces.*

class RookMovementTests extends MovementTestCase {
    
    void testRookGetPossibleMoves_EmptyBoard() {
        def rook = new Rook()
        board.addPiece('A1', rook)
        def moves = rook.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 14, moves.size()
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
    }
    
}