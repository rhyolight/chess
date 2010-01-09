package net.dangertree.chess

import net.dangertree.chess.pieces.*

class KingMovementTests extends MovementTestCase {
    
    void testKingGetPossibleMoves_EmptyBoard_FromBottomLeft() {
        def king = new King()
        board.addPiece('A1', king)
        def moves = king.possibleMoves
        assertNotNull moves
        assertEquals 3, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('A2')
        assertTrue descriptors.contains('B1')
        assertTrue descriptors.contains('B2')
    }
    

    void testKingGetPossibleMoves_EmptyBoard_FromTopLeft() {
        def king = new King()
        board.addPiece('A8', king)
        def moves = king.possibleMoves
        assertNotNull moves
        assertEquals 3, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('A7')
        assertTrue descriptors.contains('B8')
        assertTrue descriptors.contains('B7')
    }
    
    void testKingGetPossibleMoves_EmptyBoard_FromTopRight() {
        def king = new King()
        board.addPiece('H8', king)
        def moves = king.possibleMoves
        assertNotNull moves
        assertEquals 3, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('G8')
        assertTrue descriptors.contains('G7')
        assertTrue descriptors.contains('H7')
    }

    void testKingGetPossibleMoves_EmptyBoard_FromBottomRight() {
        def king = new King()
        board.addPiece('H1', king)
        def moves = king.possibleMoves
        assertNotNull moves
        assertEquals 3, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('G1')
        assertTrue descriptors.contains('G2')
        assertTrue descriptors.contains('H2')
    }

    void testKingGetPossibleMoves_EmptyBoard_FromMiddle() {
        def king = new King()
        board.addPiece('E4', king)
        def moves = king.possibleMoves
        assertNotNull moves
        assertEquals 8, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('D3')
        assertTrue descriptors.contains('D4')
        assertTrue descriptors.contains('D5')
        assertTrue descriptors.contains('E3')
        assertTrue descriptors.contains('E5')
        assertTrue descriptors.contains('F3')
        assertTrue descriptors.contains('F4')
        assertTrue descriptors.contains('F5')
    }

    void test_WhiteKing_GetPossibleMoves_with_WhiteBlocker() {
        def king = new King()
        board.addPiece('B4', king)
        board.addPiece('C4', new Pawn())
        def moves = king.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 7, moves.size()
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('B3')
        assertTrue descriptors.contains('B5')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('C5')
    }
    
    void test_WhiteKing_GetPossibleMoves_with_BlackBlocker() {
        def king = new King()
        board.addPiece('B4', king)
        board.addPiece('C4', new Pawn(side:'black'))
        def moves = king.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 8, moves.size()
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        assertTrue descriptors.contains('A5')
        assertTrue descriptors.contains('B3')
        assertTrue descriptors.contains('B5')
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('C4')
        assertTrue descriptors.contains('C5')
    }
    
}