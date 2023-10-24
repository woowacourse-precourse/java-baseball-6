package baseball;

import interfaces.Game;

public class NumberBaseball implements Game {
    @Override
    public void init() {

    }

    @Override
    public String processTurn(String input) throws IllegalArgumentException {
        return null;
    }

    @Override
    public String toStringResult() {
        return null;
    }

    @Override
    public boolean isValidInput() {
        return false;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public String getStartPrompt() {
        return null;
    }

    @Override
    public String getFinishPrompt() {
        return null;
    }

    @Override
    public String getPlayTurnPrompt() {
        return null;
    }
}
