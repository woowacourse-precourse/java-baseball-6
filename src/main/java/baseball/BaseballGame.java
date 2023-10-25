package baseball;

public class BaseballGame {
    private GameOperator operator;

    public BaseballGame(GameOperator operator) {
        this.operator = operator;
    }

    public void gameStart() {
        GameMessagesPrinter.startGameMessage();
        operator.playGameLoop();
    }
}

