package baseball;

import interfaces.Game;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class NumberBaseball implements Game {
    private final int ballCount = 3;
    private final BaseballResult  baseballResult = new BaseballResult(ballCount);

    private String[] answer;
    private HashSet<String> answerSet;

    @Override
    public void init() {
        initializeAnswer();
    }

    @Override
    public String playTurn(String input) {
        validateGameInput(input);

        baseballResult.initializeBaseballResult();

        String[] userInput = input.split("");
        for (int i = 0; i < ballCount; i++) {
            if (userInput[i].equals(answer[i])) {
                baseballResult.strike();
            } else if (answerSet.contains(userInput[i])) {
                baseballResult.ball();
            } else {
                baseballResult.out();
            }
        }

        return baseballResult.toString();
    }

    @Override
    public void validateGameInput(String input) throws IllegalArgumentException {
        if (input == null || input.length() != ballCount) {
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
        return baseballResult.strikeCount() == ballCount;
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
        answer =  new String[ballCount];
        answerSet = new HashSet<>();

        while (answerSet.size() != ballCount) {
            String randNumberString = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (answerSet.contains(randNumberString))
                continue;

            answerSet.add(randNumberString);
            answer[answerSet.size() - 1] = randNumberString;
        }
    }
}
