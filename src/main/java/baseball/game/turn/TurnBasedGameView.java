package baseball.game.turn;

public interface TurnBasedGameView {

    void printStart();

    TurnInput requestTurnInput();

    void printClear();

    void printResult(TurnResult turnResult);
}
