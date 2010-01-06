package net.dangertree.chess

import net.dangertree.chess.pieces.*

class BishopMovementTests extends MovementTestCase {
    
    void testBishopGetPossibleMoves_EmptyBoard() {
        def bish = new Bishop()
        board.addPiece('A1', bish)
        def moves = bish.possibleMoves
        assertNotNull moves
        assertEquals 7, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('B2')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('D4')
        assertTrue descriptors.contains('E5')
        assertTrue descriptors.contains('F6')
        assertTrue descriptors.contains('G7')
        assertTrue descriptors.contains('H8')
    }
    
}