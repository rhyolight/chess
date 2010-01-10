package net.dangertree.chess

import net.dangertree.chess.pieces.*

class PawnMovementTests extends MovementTestCase {
    
    void testPawnGetPossibleMoves() {
        def pawn = new Pawn()
        board.addPiece('A2', pawn)
        def moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('A3')
        assertTrue descriptors.contains('A4')
        pawn.cell.descriptor = 'B2'
        moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        descriptors = moves*.descriptor
        assertTrue descriptors.contains('B3')
        assertTrue descriptors.contains('B4')
    }
    
    void testPawnCantMoveTwoSpacesAfterFirstMove() {
        def pawn = new Pawn()
        board.addPiece('A3', pawn)
        def moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 1, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('A4')
    }
    
    void testBlackPawnMovesDownBoard() {
        def pawn = new Pawn(side:'black')
        board.addPiece('A7', pawn)
        def moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('A5')        
        assertTrue descriptors.contains('A6')
        pawn.cell.descriptor = 'B7'
        moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        descriptors = moves*.descriptor
        assertTrue descriptors.contains('B6')        
        assertTrue descriptors.contains('B5')
    }
    
    void testWhitePawn_CanMoveAheadDaigonally_ToKillBlackPiece() {
        def attacker = new Pawn()
        board.addPiece('D4', attacker)
        def prey = new Pawn(side:'black')
        board.addPiece('C5', prey)
        
        def moves = attacker.possibleMoves
        assertEquals 2, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('D5')        
        assertTrue descriptors.contains('C5')
    }
    
    void testWhitePawn_CannotMoveAheadDaigonally_ToKillWhitePiece() {
        def attacker = new Pawn()
        board.addPiece('D4', attacker)
        def prey = new Pawn()
        board.addPiece('C5', prey)
        
        def moves = attacker.possibleMoves
        assertEquals 1, moves.size()
        assertTrue moves*.descriptor.contains('D5')        
    }
    
    void testBlackPawn_CanMoveAheadDaigonally_ToKillWhitePiece() {
        def attacker = new Pawn(side:'black')
        board.addPiece('D4', attacker)
        def prey = new Pawn()
        board.addPiece('E3', prey)
        
        def moves = attacker.possibleMoves
        assertEquals 2, moves.size()
        def descriptors = moves*.descriptor
        assertTrue descriptors.contains('D3')        
        assertTrue descriptors.contains('E3')
    }
    
    void testBlackPawn_CannotMoveAheadDaigonally_ToKillBlackPiece() {
        def attacker = new Pawn(side:'black')
        board.addPiece('D4', attacker)
        def prey = new Pawn(side:'black')
        board.addPiece('E3', prey)
        
        def moves = attacker.possibleMoves
        assertEquals 1, moves.size()
        assertTrue moves*.descriptor.contains('D3')        
    }
    
    void testPawnCannotKillHeadOn() {
        fail('not implemented')
    }
    
}