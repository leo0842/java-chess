package chess.piece.type;

import chess.piece.type.movable.BishopMovable;
import chess.score.Score;
import chess.team.Team;

public class Bishop extends Piece {
    private static final char NAME = 'b';
    private static final int SCORE = 3;

    public Bishop(Team team) {
        super(NAME, new Score(SCORE), team, new BishopMovable());
    }
}
