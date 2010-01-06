package net.dangertree.chess

import net.dangertree.chess.pieces.*

class MovementTests extends MovementTestCase {
    
    void testWhitePieceCantMoveBeyondTopOfBoard() {
        def cell = new Cell(descriptor:'A8')
        def pawn = new Pawn()
        pawn.board = board
        cell.piece = pawn
        def moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 0, moves.size()
    }
    
    void testBlackPieceCantMoveBeyondBottomOfBoard() {
        def cell = new Cell(descriptor:'A1')
        def pawn = new Pawn(side:'black')
        pawn.board = board
        cell.piece = pawn
        def moves = pawn.possibleMoves
        assertNotNull moves
        assertEquals 0, moves.size()
    }
}