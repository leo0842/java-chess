package chess.state;

import chess.controller.ChessService;
import chess.model.GameCommand;
import java.util.List;


public final class Ready implements GameState {

    @Override
    public GameState changeStatus(GameCommand command) {
        if (command.isStart()) {
            return new Start();
        }
        if (command.isMove()) {
            return new Move();
        }
        if (command.isStatus()) {
            return new Status();
        }
        return new End();
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    public GameState execute(ChessService service, List<String> sqaures) {
        return this;
    }

    @Override
    public boolean isStatus() {
        return false;
    }
}