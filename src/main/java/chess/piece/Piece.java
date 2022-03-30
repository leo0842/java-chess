package chess.piece;

import chess.square.Square;

public abstract class Piece {

    protected final Color color;

    protected Piece(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                '}';
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }

    public abstract String name();

    public abstract boolean movable(Square source, Square target);
}