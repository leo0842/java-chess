package chess.domain.piece.condition;

import chess.domain.board.Board;
import chess.domain.piece.ChessPiece;
import chess.domain.piece.Position;

public abstract class MoveCondition {

    public abstract boolean isSatisfyBy(Board board, ChessPiece source, Position target);

    protected boolean isNotChessPieceOutOfBoard(Position target) {
        return 0 <= target.getRow() && target.getRow() < Board.getRow() &&
                0 <= target.getColumn() && target.getColumn() < Board.getColumn();
    }

}