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
    private HashSet<String> answerSet;

    private boolean isFinished;

    @Override
    public void init() {
        isFinished = false;

        answer = Randoms.pickUniqueNumbersInRange(1, 9, ANSWER_LENGTH).stream()
                .map(String::valueOf)
                .toArray(String[]::new);
        answerSet = new HashSet<>(Arrays.asList(answer));

        initializeBaseballResult();
    }

    @Override
    public String processTurn(String input) {
        validateGameInput(input);

        initializeBaseballResult();
        String[] userInput = input.split("");

        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if (userInput[i].equals(answer[i])) {
                baseballResult.put(ResultType.STRIKE, baseballResult.get(ResultType.STRIKE) + 1);
            } else if (answerSet.contains(userInput[i])) {
                baseballResult.put(ResultType.BALL, baseballResult.get(ResultType.BALL) + 1);
            } else {
                baseballResult.put(ResultType.OUT, baseballResult.get(ResultType.OUT) + 1);
            }
        }

        isFinished = baseballResult.get(ResultType.STRIKE) == ANSWER_LENGTH;
        return this.gameResultToString();
    }

    @Override
    public String gameResultToString() {
        if (baseballResult.get(ResultType.OUT) == ANSWER_LENGTH) {
            return "낫싱";
        }

        ArrayList<String> result = new ArrayList<>();
        if (baseballResult.get(ResultType.BALL) > 0) {
            result.add(String.format("%d볼", baseballResult.get(ResultType.BALL)));
        }
        if (baseballResult.get(ResultType.STRIKE) > 0) {
            result.add(String.format("%d스트라이크", baseballResult.get(ResultType.STRIKE)));
        }

        return String.join(" ", result);
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
        return isFinished;
    }

    @Override
    public String getStartPrompt() {
        return "숫자 야구 게임을 시작합니다.";
    }

    @Override
    public String getFinishPrompt() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    @Override
    public String getPlayTurnPrompt() {
        return "숫자를 입력해주세요 : ";
    }

    private void initializeBaseballResult() {
        if (baseballResult == null) {
            baseballResult = new HashMap<>();
        }

        for (ResultType type : ResultType.values()) {
            baseballResult.put(type, 0);
        }
    }
}
