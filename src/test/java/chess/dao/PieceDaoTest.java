package chess.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import chess.model.Board;
import chess.model.piece.Color;
import chess.model.piece.Pawn;
import chess.model.piece.Piece;
import chess.model.square.File;
import chess.model.square.Rank;
import chess.model.square.Square;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PieceDaoTest {

    private final PieceDao dao = new PieceDao(new ConnectionManager());
    private final SquareDao squareDao = new SquareDao(new ConnectionManager());
    private final BoardDao boardDao = new BoardDao(new ConnectionManager());
    private int boardId;
    private int squareId;

    @BeforeEach
    void setup() {
        final Board board = boardDao.save(new Board("corinne"));
        this.boardId = board.getId();
        final Square square = squareDao.save(new Square(File.A, Rank.TWO, board.getId()));
        this.squareId = square.getId();
        dao.save(new Pawn(Color.WHITE), squareId);
    }

    @AfterEach
    void setDown() {
        boardDao.deleteAll();
    }

    @Test
    void saveTest() {
        final Piece piece = dao.save(new Pawn(Color.WHITE), squareId);

        assertAll(
                () -> assertThat(piece.name()).isEqualTo("p"),
                () -> assertThat(piece.color()).isEqualTo(Color.WHITE),
                () -> assertThat(piece.getSquareId()).isEqualTo(squareId)
        );
    }

    @Test
    void findBySquareId() {
        Piece piece = dao.findBySquareId(squareId);

        assertAll(
                () -> assertThat(piece.name()).isEqualTo("p"),
                () -> assertThat(piece.color()).isEqualTo(Color.WHITE)
        );
    }

    @Test
    void deletePieceBySquareId() {
        int affectedRows = dao.deletePieceBySquareId(squareId);

        assertThat(affectedRows).isEqualTo(1);
    }

    @Test
    void updatePieceSquareId() {
        final int originSquareId = squareId;
        final int newSquareId = squareDao.save(new Square(File.A, Rank.FOUR, boardId)).getId();
        int affectedRow = dao.updatePieceSquareId(originSquareId, newSquareId);

        assertThat(affectedRow).isEqualTo(1);
    }

    @Test
    void getAllPiecesByBoardId() {
        List<Piece> pieces = dao.getAllPiecesByBoardId(boardId);

        assertThat(pieces.size()).isEqualTo(1);
    }
}
