package chess.model.piece;

import chess.Direction;
import chess.model.square.Square;
import java.util.List;

public class Empty extends Piece {

    public Empty() {
        super(Color.EMPTY);
    }

    @Override
    public String name() {
        return ".";
    }

    @Override
    public boolean movable(Square source, Square target) {
        return false;
    }

    @Override
    List<Direction> getDirection() {
        return null;
    }
}