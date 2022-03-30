package chess;

import chess.piece.Bishop;
import chess.piece.Color;
import chess.piece.Empty;
import chess.piece.King;
import chess.piece.Knight;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.piece.Queen;
import chess.piece.Rook;
import chess.square.File;
import chess.square.Rank;
import chess.square.Square;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Board {

    private final Map<Square, Piece> board;

    public Board() {
        this.board = new HashMap<>();
        final List<File> files = Arrays.asList(File.values());

        initChivalry(Color.WHITE, Rank.ONE, files);
        initChivalry(Color.BLACK, Rank.EIGHT, files);
        initPawns(Color.WHITE, Rank.TWO, files);
        initPawns(Color.BLACK, Rank.SEVEN, files);
        initEmpty();
    }

    private void initEmpty() {
        for (Rank rank : Rank.values()) {
            for (File file : File.values()) {
                Square square = Square.of(rank, file);
                if (!board.containsKey(square)) {
                    board.put(square, new Empty(Color.EMPTY));
                }
            }
        }
    }

    private void initPawns(Color color, Rank rank, List<File> files) {
        for (int i = 0; i < 8; i++) {
            board.put(Square.of(rank, files.get(i)), new Pawn(color));
        }
    }

    private void initChivalry(Color color, Rank rank, List<File> files) {
        List<Piece> chivalryLineup = chivalryLineup(color);
        for (int i = 0; i < chivalryLineup.size(); i++) {
            board.put(Square.of(rank, files.get(i)), chivalryLineup.get(i));
        }
    }

    private List<Piece> chivalryLineup(final Color color) {
        return List.of(
                new Rook(color),
                new Knight(color),
                new Bishop(color),
                new Queen(color),
                new King(color),
                new Bishop(color),
                new Knight(color),
                new Rook(color)
        );
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + board +
                '}';
    }

    public Piece get(Square square) {
        return board.get(square);
    }
}