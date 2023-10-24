package baseball.game.turn;

public interface TurnBasedGameService {
    void init();

    TurnResult playTurn(TurnInput turnInput);
}
