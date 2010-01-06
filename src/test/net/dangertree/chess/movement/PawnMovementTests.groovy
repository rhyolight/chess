package net.dangertree.chess

import net.dangertree.chess.pieces.*

class PawnMovementTests extends MovementTestCase {
    
    void testPawnGetPossibleMoves() {
        def pawn = new Pawn()
        board.addPiece('A2', pawn)
        def moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        assertEquals 'A3', moves[0].descriptor
        assertEquals 'A4', moves[1].descriptor
        pawn.cell.descriptor = 'B2'
        moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        assertEquals 'B3', moves[0].descriptor
        assertEquals 'B4', moves[1].descriptor
    }
    
    void testPawnCantMoveTwoSpacesAfterFirstMove() {
        def pawn = new Pawn()
        board.addPiece('A3', pawn)
        def moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 1, moves.size()
        assertEquals 'A4', moves[0].descriptor
    }
    
    void testBlackPawnMovesDownBoard() {
        def pawn = new Pawn(side:'black')
        board.addPiece('A7', pawn)
        def moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        assertEquals 'A6', moves[0].descriptor
        assertEquals 'A5', moves[1].descriptor
        pawn.cell.descriptor = 'B7'
        moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 2, moves.size()
        assertEquals 'B6', moves[0].descriptor
        assertEquals 'B5', moves[1].descriptor
    }
    
    void testWhitePawn_CanMoveAheadDaigonally_ToKillBlackPiece() {
        def attacker = new Pawn()
        board.addPiece('D4', attacker)
        def prey = new Pawn(side:'black')
        board.addPiece('C5', prey)
        
        def moves = attacker.possibleMoves
        assertEquals 2, moves.size()
        assertEquals 'D5', moves[0].descriptor
        assertEquals 'C5', moves[1].descriptor
    }
    
    void testWhitePawn_CannotMoveAheadDaigonally_ToKillWhitePiece() {
        def attacker = new Pawn()
        board.addPiece('D4', attacker)
        def prey = new Pawn()
        board.addPiece('C5', prey)
        
        def moves = attacker.possibleMoves
        assertEquals 1, moves.size()
        assertEquals 'D5', moves[0].descriptor
    }
    
    void testBlackPawn_CanMoveAheadDaigonally_ToKillWhitePiece() {
        def attacker = new Pawn(side:'black')
        board.addPiece('D4', attacker)
        def prey = new Pawn()
        board.addPiece('E3', prey)
        
        def moves = attacker.possibleMoves
        assertEquals 2, moves.size()
        assertEquals 'D3', moves[0].descriptor
        assertEquals 'E3', moves[1].descriptor
    }
    
    void testBlackPawn_CannotMoveAheadDaigonally_ToKillBlackPiece() {
        def attacker = new Pawn(side:'black')
        board.addPiece('D4', attacker)
        def prey = new Pawn(side:'black')
        board.addPiece('E3', prey)
        
        def moves = attacker.possibleMoves
        assertEquals 1, moves.size()
        assertEquals 'D3', moves[0].descriptor
    }
    
}