package net.dangertree.chess

import net.dangertree.chess.pieces.*

class BishopMovementTests extends MovementTestCase {
    
    void testBishopGetPossibleMoves_EmptyBoard_FromBottomLeft() {
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
    
    void testBishopGetPossibleMoves_EmptyBoard_FromTopLeft() {
        def bish = new Bishop()
        board.addPiece('A8', bish)
        def moves = bish.possibleMoves
        assertNotNull moves
        assertEquals 7, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('B7')
        assertTrue descriptors.contains('C6')
        assertTrue descriptors.contains('D5')
        assertTrue descriptors.contains('E4')
        assertTrue descriptors.contains('F3')
        assertTrue descriptors.contains('G2')
        assertTrue descriptors.contains('H1')
    }
    
    void testBishopGetPossibleMoves_EmptyBoard_FromTopRight() {
        def bish = new Bishop()
        board.addPiece('H8', bish)
        def moves = bish.possibleMoves
        assertNotNull moves
        assertEquals 7, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('A1')
        assertTrue descriptors.contains('B2')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('D4')
        assertTrue descriptors.contains('E5')
        assertTrue descriptors.contains('F6')
        assertTrue descriptors.contains('G7')
    }
    
    void testBishopGetPossibleMoves_EmptyBoard_FromBottomRight() {
        def bish = new Bishop()
        board.addPiece('H1', bish)
        def moves = bish.possibleMoves
        assertNotNull moves
        assertEquals 7, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('G2')
        assertTrue descriptors.contains('F3')
        assertTrue descriptors.contains('E4')
        assertTrue descriptors.contains('D5')
        assertTrue descriptors.contains('C6')
        assertTrue descriptors.contains('B7')
        assertTrue descriptors.contains('A8')
    }
    
    void testBishopGetPossibleMoves_EmptyBoard_FromMiddle() {
        def bish = new Bishop()
        board.addPiece('E4', bish)
        def moves = bish.possibleMoves
        assertNotNull moves
        assertEquals 13, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('A8')
        assertTrue descriptors.contains('B1')
        assertTrue descriptors.contains('B7')
        assertTrue descriptors.contains('C2')
        assertTrue descriptors.contains('C6')
        assertTrue descriptors.contains('D3')
        assertTrue descriptors.contains('D5')
        assertTrue descriptors.contains('F3')
        assertTrue descriptors.contains('F5')
        assertTrue descriptors.contains('G2')
        assertTrue descriptors.contains('G6')
        assertTrue descriptors.contains('H1')
        assertTrue descriptors.contains('H7')
    }
    
    void test_WhiteBishop_GetPossibleMoves_with_WhiteBlocker() {
        def bish = new Bishop()
        board.addPiece('B4', bish)
        board.addPiece('D6', new Pawn())
        def moves = bish.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 6, moves.size()
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('C5')
        assertTrue descriptors.contains('D2')
        assertTrue descriptors.contains('E1')
    }
    
    void test_WhiteBishop_GetPossibleMoves_with_BlackBlocker() {
        def bish = new Bishop()
        board.addPiece('B4', bish)
        board.addPiece('D6', new Pawn(side:'black'))
        def moves = bish.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 7, moves.size()
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('C5')
        assertTrue descriptors.contains('D2')
        assertTrue descriptors.contains('D6')
        assertTrue descriptors.contains('E1')
    }
    
}