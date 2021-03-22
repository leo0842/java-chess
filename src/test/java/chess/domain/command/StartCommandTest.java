package chess.domain.command;

import chess.domain.game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StartCommandTest {
    private StartCommand startCommand;
    private ChessGame game;

    @BeforeEach
    void setUp() {
        game = new ChessGame(null);
        startCommand = new StartCommand(game);
    }

    @DisplayName("WhiteWin 상태일 때 execute 하면 예외")
    @Test
    void execute_whenChessGameStatusAreWhiteWin() {
        game.changeState(new WhiteWin(game));

        assertThatThrownBy(() -> startCommand.execute(null))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("BlackWin 상태일 때 execute 하면 예외")
    @Test
    void execute_whenChessGameStatusAreBlackWin() {
        game.changeState(new BlackWin(game));

        assertThatThrownBy(() -> startCommand.execute(null))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("End 상태일 때 execute 하면 예외")
    @Test
    void execute_whenChessGameStatusAreEnd() {
        game.changeState(new End(game));

        assertThatThrownBy(() -> startCommand.execute(null))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("BlackTurn 상태일 때 execute 하면 예외")
    @Test
    void execute_whenChessGameStatusAreBlackTurn() {
        game.changeState(new BlackTurn(game));

        assertThatThrownBy(() -> startCommand.execute(null))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("WhiteTurn 상태일 때 execute 하면 예외")
    @Test
    void execute_whenChessGameStatusAreWhiteTurn() {
        game.changeState(new WhiteTurn(game));

        assertThatThrownBy(() -> startCommand.execute(null))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("올바른 입력인지 확인한다.")
    @Test
    void isUsable() {
        boolean actualTrue = startCommand.isUsable("start");
        boolean actualFalse = startCommand.isUsable("start2");

        assertThat(actualTrue).isTrue();
        assertThat(actualFalse).isFalse();
    }

    @DisplayName("Status 인지 확인한다.")
    @Test
    void isStatus() {
        assertThat(startCommand.isStatus()).isFalse();
    }
}