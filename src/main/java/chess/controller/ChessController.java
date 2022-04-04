package chess.controller;

import chess.dto.BoardDto;
import chess.dto.ResponseDto;
import chess.dto.ScoreDto;
import chess.model.Board;

public class ChessController {

    private final Board board;

    public ChessController() {
        this.board = new Board();
    }

    public BoardDto startGame() {
        board.startGame();
        return BoardDto.of(board);
    }

    public BoardDto getBoard() {
        return BoardDto.of(board);
    }

    public ResponseDto move(String source, String target) {
        try {
            board.move(source, target);
        } catch (IllegalArgumentException e) {
            return ResponseDto.of(400, e.getMessage());
        }
        return ResponseDto.of(200, null);
    }

    public ScoreDto score() {
        return ScoreDto.of(board.calculateScore());
    }

    public boolean isEnd() {
        return board.isEnd();
    }

    public void finishGame() {
        board.finishGame();
    }
}
