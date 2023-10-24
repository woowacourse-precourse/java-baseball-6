package baseball;

import interfaces.Game;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseball implements Game {
    private final int ANSWER_LENGTH = 3;
    private List<Integer> answer;

    @Override
    public void init() {
        this.answer = Randoms.pickUniqueNumbersInRange(1, 9, ANSWER_LENGTH);
    }

    @Override
    public String processTurn(String input) {
        validateGameInput(input);
        return null;
    }

    @Override
    public String toStringResult() {
        return null;
    }

    @Override
    public void validateGameInput(String input) throws IllegalArgumentException {
        String gameInputRegex = "^[1-9]{3}$";
        if (input.matches(gameInputRegex)) {
            return;
        }
        throw new IllegalArgumentException("Invalid game input");
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
