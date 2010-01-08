package net.dangertree.chess

import net.dangertree.chess.pieces.*

class KnightMovementTests extends MovementTestCase {
    
    void testKnightGetPossibleMoves_EmptyBoard_FromBottomLeft() {
        def knight = new Knight()
        board.addPiece('A1', knight)
        def moves = knight.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('B3')
        assertTrue descriptors.contains('C2')
    }
    

    void testKnightGetPossibleMoves_EmptyBoard_FromTopLeft() {
        def knight = new Knight()
        board.addPiece('A8', knight)
        def moves = knight.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('B6')
        assertTrue descriptors.contains('C7')
    }
    
    void testKnightGetPossibleMoves_EmptyBoard_FromTopRight() {
        def knight = new Knight()
        board.addPiece('H8', knight)
        def moves = knight.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('F7')
        assertTrue descriptors.contains('G6')
    }

    void testKnightGetPossibleMoves_EmptyBoard_FromBottomRight() {
        def knight = new Knight()
        board.addPiece('H1', knight)
        def moves = knight.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('F2')
        assertTrue descriptors.contains('G3')
    }

    void testKnightGetPossibleMoves_EmptyBoard_FromMiddle() {
        def knight = new Knight()
        board.addPiece('E4', knight)
        def moves = knight.possibleMoves
        assertNotNull moves
        assertEquals 8, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('C3')
        assertTrue descriptors.contains('C5')
        assertTrue descriptors.contains('D2')
        assertTrue descriptors.contains('D6')
        assertTrue descriptors.contains('F2')
        assertTrue descriptors.contains('F6')
        assertTrue descriptors.contains('G3')
        assertTrue descriptors.contains('G5')
    }

    void test_WhiteKnight_GetPossibleMoves_with_WhiteBlocker() {
        def knight = new Knight()
        board.addPiece('B4', knight)
        board.addPiece('D5', new Pawn())
        def moves = knight.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 6, moves.size()
        assertTrue descriptors.contains('A2')
        assertTrue descriptors.contains('A6')
        assertTrue descriptors.contains('C2')
        assertTrue descriptors.contains('C6')
        assertTrue descriptors.contains('D3')
    }
    
    void test_WhiteKnight_GetPossibleMoves_with_BlackBlocker() {
        def knight = new Knight()
        board.addPiece('B4', knight)
        board.addPiece('D5', new Pawn(side:'black'))
        def moves = knight.possibleMoves
        def descriptors = moves*.descriptor
        assertNotNull moves
        assertEquals 6, moves.size()
        assertTrue descriptors.contains('A2')
        assertTrue descriptors.contains('A6')
        assertTrue descriptors.contains('C2')
        assertTrue descriptors.contains('C6')
        assertTrue descriptors.contains('D3')
        assertTrue descriptors.contains('D5')
    }
    
}