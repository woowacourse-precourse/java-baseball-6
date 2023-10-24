package baseball;

import interfaces.Game;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class NumberBaseball implements Game {
    private enum BaseballResultType {
        STRIKE, BALL, OUT
    }
    private HashMap<BaseballResultType, Integer> baseballResult;

    private final int ANSWER_LENGTH = 3;
    private String[] answer;
    private HashSet<String> answerSet;

    private boolean isFinished;

    @Override
    public void init() {
        isFinished = false;
        initializeAnswer();
        initializeTurnResult();
    }

    @Override
    public String playTurn(String input) {
        validateGameInput(input);

        initializeTurnResult();
        String[] userInput = input.split("");

        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if (userInput[i].equals(answer[i])) {
                baseballResult.put(BaseballResultType.STRIKE, baseballResult.get(BaseballResultType.STRIKE) + 1);
            } else if (answerSet.contains(userInput[i])) {
                baseballResult.put(BaseballResultType.BALL, baseballResult.get(BaseballResultType.BALL) + 1);
            } else {
                baseballResult.put(BaseballResultType.OUT, baseballResult.get(BaseballResultType.OUT) + 1);
            }
        }

        isFinished = baseballResult.get(BaseballResultType.STRIKE) == ANSWER_LENGTH;
        return this.gameResultToString();
    }

    @Override
    public String gameResultToString() {
        if (baseballResult.get(BaseballResultType.OUT) == ANSWER_LENGTH) {
            return "낫싱";
        }

        ArrayList<String> result = new ArrayList<>();
        if (baseballResult.get(BaseballResultType.BALL) > 0) {
            result.add(String.format("%d볼", baseballResult.get(BaseballResultType.BALL)));
        }
        if (baseballResult.get(BaseballResultType.STRIKE) > 0) {
            result.add(String.format("%d스트라이크", baseballResult.get(BaseballResultType.STRIKE)));
        }

        return String.join(" ", result);
    }

    @Override
    public void validateGameInput(String input) throws IllegalArgumentException {
        if (input == null || input.length() != ANSWER_LENGTH) {
            throw new IllegalArgumentException("Invalid game input length");
        }

        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9' || !set.add(c)) {
                throw new IllegalArgumentException("Invalid game input");
            }
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

    private void initializeAnswer() {
        answer =  new String[ANSWER_LENGTH];
        answerSet = new HashSet<>();

        while (answerSet.size() != ANSWER_LENGTH) {
            String randNumberString = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (answerSet.contains(randNumberString))
                continue;

            answerSet.add(randNumberString);
            answer[answerSet.size() - 1] = randNumberString;
        }
    }

    private void initializeTurnResult() {
        if (baseballResult == null) {
            baseballResult = new HashMap<>();
        }

        for (BaseballResultType type : BaseballResultType.values()) {
            baseballResult.put(type, 0);
        }
    }
}
