package baseball;

import interfaces.Game;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class NumberBaseball implements Game {
    private enum ResultType {
        STRIKE, BALL, OUT
    }
    private HashMap<ResultType, Integer> baseballResult;

    private final int ANSWER_LENGTH = 3;
    private String[] answer;

    private boolean isFinishGame = false;

    @Override
    public void init() {
        this.answer = Randoms.pickUniqueNumbersInRange(1, 9, ANSWER_LENGTH).stream()
                .map(String::valueOf)
                .toArray(String[]::new);
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
        boolean isValid = true;

        if (input.length() != ANSWER_LENGTH) {
            isValid = false;
        } else {
            HashSet<String> set = new HashSet<>(List.of(input.split("")));
            if (set.size() != ANSWER_LENGTH) {
                isValid = false;
            }
        }

        if (!isValid) {
            throw new IllegalArgumentException("Invalid game input");
        }
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

    private void initializeBaseballResult() {
        if (this.baseballResult == null) {
            this.baseballResult = new HashMap<>();
        }

        for (ResultType type : ResultType.values()) {
            baseballResult.put(type, 0);
        }
    }
}
