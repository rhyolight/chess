package net.dangertree.chess

import net.dangertree.chess.pieces.*

class QueenMovementTests extends MovementTestCase {
    
    void testQueenGetPossibleMoves_EmptyBoard_FromBottomLeft() {
        def queen = new Queen()
        board.addPiece('A1', queen)
        def moves = queen.possibleMoves
        assertNotNull moves
        assertEquals 21, moves.size()
        def descriptors = moves*.descriptor
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
        assertTrue descriptors.contains('B2')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('D4')
        assertTrue descriptors.contains('E5')
        assertTrue descriptors.contains('F6')
        assertTrue descriptors.contains('G7')
        assertTrue descriptors.contains('H8')
    }
    
    void testQueenGetPossibleMoves_EmptyBoard_FromTopLeft() {
        def queen = new Queen()
        board.addPiece('A8', queen)
        def moves = queen.possibleMoves
        assertNotNull moves
        assertEquals 21, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('B7')
        assertTrue descriptors.contains('C6')
        assertTrue descriptors.contains('D5')
        assertTrue descriptors.contains('E4')
        assertTrue descriptors.contains('F3')
        assertTrue descriptors.contains('G2')
        assertTrue descriptors.contains('H1')
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
    
    void testQueenGetPossibleMoves_EmptyBoard_FromTopRight() {
        def queen = new Queen()
        board.addPiece('H8', queen)
        def moves = queen.possibleMoves
        assertNotNull moves
        assertEquals 21, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('A1')
        assertTrue descriptors.contains('B2')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('D4')
        assertTrue descriptors.contains('E5')
        assertTrue descriptors.contains('F6')
        assertTrue descriptors.contains('G7')
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
    
    void testQueenGetPossibleMoves_EmptyBoard_FromBottomRight() {
        def queen = new Queen()
        board.addPiece('H1', queen)
        def moves = queen.possibleMoves
        assertNotNull moves
        assertEquals 21, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('G2')
        assertTrue descriptors.contains('F3')
        assertTrue descriptors.contains('E4')
        assertTrue descriptors.contains('D5')
        assertTrue descriptors.contains('C6')
        assertTrue descriptors.contains('B7')
        assertTrue descriptors.contains('A8')
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
    
    void testQueenGetPossibleMoves_EmptyBoard_FromMiddle() {
        def queen = new Queen()
        board.addPiece('E4', queen)
        def moves = queen.possibleMoves
        assertNotNull moves
        assertEquals 27, moves.size()
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
    
    void test_WhiteQueen_GetPossibleMoves_with_WhiteBlocker() {
        def queen = new Queen()
        board.addPiece('B4', queen)
        board.addPiece('D6', new Pawn())
        board.addPiece('E4', new Pawn())
        def moves = queen.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 16, moves.size()
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('B1')
        assertTrue descriptors.contains('B2')
        assertTrue descriptors.contains('B3')
        assertTrue descriptors.contains('B5')
        assertTrue descriptors.contains('B6')
        assertTrue descriptors.contains('B7')
        assertTrue descriptors.contains('B8')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('C4')
        assertTrue descriptors.contains('C5')
        assertTrue descriptors.contains('D2')
        assertTrue descriptors.contains('D4')
        assertTrue descriptors.contains('E1')
    }
    
    void test_WhiteQueen_GetPossibleMoves_with_BlackBlocker() {
        def queen = new Queen()
        board.addPiece('B4', queen)
        board.addPiece('D6', new Pawn(side:'black'))
        board.addPiece('E4', new Pawn(side:'black'))
        def moves = queen.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 18, moves.size()
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('B1')
        assertTrue descriptors.contains('B2')
        assertTrue descriptors.contains('B3')
        assertTrue descriptors.contains('B5')
        assertTrue descriptors.contains('B6')
        assertTrue descriptors.contains('B7')
        assertTrue descriptors.contains('B8')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('C4')
        assertTrue descriptors.contains('C5')
        assertTrue descriptors.contains('D2')
        assertTrue descriptors.contains('D4')
        assertTrue descriptors.contains('D6')
        assertTrue descriptors.contains('E1')
        assertTrue descriptors.contains('E4')
    }
    
}