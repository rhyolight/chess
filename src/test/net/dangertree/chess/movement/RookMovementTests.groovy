package net.dangertree.chess

import net.dangertree.chess.pieces.*

class RookMovementTests extends MovementTestCase {
    
    void testRook_GetPossibleMoves_EmptyBoard_FromBottomLeft() {
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
    
    void testRook_GetPossibleMoves_EmptyBoard_FromTopLeft() {
        def rook = new Rook()
        board.addPiece('A8', rook)
        def moves = rook.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 14, moves.size()
        assertTrue descriptors.contains('A1')
        assertTrue descriptors.contains('A2')
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('A6')
        assertTrue descriptors.contains('A7')
        assertTrue descriptors.contains('B8')
        assertTrue descriptors.contains('C8')
        assertTrue descriptors.contains('D8')
        assertTrue descriptors.contains('E8')
        assertTrue descriptors.contains('F8')
        assertTrue descriptors.contains('G8')
        assertTrue descriptors.contains('H8')
    }

    void testRook_GetPossibleMoves_EmptyBoard_FromTopRight() {
        def rook = new Rook()
        board.addPiece('H8', rook)
        def moves = rook.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 14, moves.size()
        assertTrue descriptors.contains('H1')
        assertTrue descriptors.contains('H2')
        assertTrue descriptors.contains('H3')
        assertTrue descriptors.contains('H4')
        assertTrue descriptors.contains('H5')
        assertTrue descriptors.contains('H6')
        assertTrue descriptors.contains('H7')
        assertTrue descriptors.contains('A8')
        assertTrue descriptors.contains('B8')
        assertTrue descriptors.contains('C8')
        assertTrue descriptors.contains('D8')
        assertTrue descriptors.contains('E8')
        assertTrue descriptors.contains('F8')
        assertTrue descriptors.contains('G8')
    }
    
    void testRook_GetPossibleMoves_EmptyBoard_FromBottomRight() {
        def rook = new Rook()
        board.addPiece('H1', rook)
        def moves = rook.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 14, moves.size()
        assertTrue descriptors.contains('H2')
        assertTrue descriptors.contains('H3')
        assertTrue descriptors.contains('H4')
        assertTrue descriptors.contains('H5')
        assertTrue descriptors.contains('H6')
        assertTrue descriptors.contains('H7')
        assertTrue descriptors.contains('H8')
        assertTrue descriptors.contains('A1')
        assertTrue descriptors.contains('B1')
        assertTrue descriptors.contains('C1')
        assertTrue descriptors.contains('D1')
        assertTrue descriptors.contains('E1')
        assertTrue descriptors.contains('F1')
        assertTrue descriptors.contains('G1')
    }
    
    void testRook_GetPossibleMoves_EmptyBoard_FromMiddle() {
        def rook = new Rook()
        board.addPiece('E4', rook)
        def moves = rook.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 14, moves.size()
        assertTrue descriptors.contains('E1')
        assertTrue descriptors.contains('E2')
        assertTrue descriptors.contains('E3')
        assertTrue descriptors.contains('E5')
        assertTrue descriptors.contains('E6')
        assertTrue descriptors.contains('E7')
        assertTrue descriptors.contains('E8')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('B4')
        assertTrue descriptors.contains('C4')
        assertTrue descriptors.contains('D4')
        assertTrue descriptors.contains('F4')
        assertTrue descriptors.contains('G4')
        assertTrue descriptors.contains('H4')
    }
    
    void test_WhiteRook_GetPossibleMoves_with_WhiteBlocker() {
        def rook = new Rook()
        board.addPiece('A1', rook)
        board.addPiece('C1', new Pawn())
        def moves = rook.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 8, moves.size()
        assertTrue descriptors.contains('A2')
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('A6')
        assertTrue descriptors.contains('A7')
        assertTrue descriptors.contains('A8')
        assertTrue descriptors.contains('B1')
    }
    
    void test_WhiteRook_GetPossibleMoves_with_BlackBlocker() {
        def rook = new Rook()
        board.addPiece('A1', rook)
        board.addPiece('C1', new Pawn(side:'black'))
        def moves = rook.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 9, moves.size()
        assertTrue descriptors.contains('A2')
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('A6')
        assertTrue descriptors.contains('A7')
        assertTrue descriptors.contains('A8')
        assertTrue descriptors.contains('B1')
        assertTrue descriptors.contains('C1')
    }
    
}