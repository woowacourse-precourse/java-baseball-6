package baseball.phase;

import baseball.game.BaseballGame;

public interface Phase {
    void display();

    void validateInput(String input);

    PhaseID action(String input);

    void setGame(BaseballGame game);
}
