package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    private static final int ANSWER_SIZE = 3;
    private static final int ANSWER_MIN_NUM = 1;
    private static final int ANSWER_MAX_NUM = 9;
    private static final String GAME_SUCCESS = "03";

    public List<Integer> makeNewAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(ANSWER_MIN_NUM, ANSWER_MAX_NUM);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public String countBallAndStrike(List<Integer> computerAnswer, String userInput) {
        int ball = countBall(computerAnswer, userInput);
        int strike = countStrike(computerAnswer, userInput);
        return "" + ball + strike;
    }

    private int countBall(List<Integer> computerAnswer, String userInput) {
        int ballCount = 0;
        for (int i = 0; i < ANSWER_SIZE; i++) {
            char userNumChar = userInput.charAt(i);
            int userNumInt = Character.getNumericValue(userNumChar);
            if (!(computerAnswer.get(i).equals(userNumInt)) && computerAnswer.contains(userNumInt)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int countStrike(List<Integer> computerAnswer, String userInput) {
        int strikeCount = 0;
        for (int i = 0; i < ANSWER_SIZE; i++) {
            char userNumChar = userInput.charAt(i);
            int userNumInt = Character.getNumericValue(userNumChar);
            if (computerAnswer.get(i).equals(userNumInt)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public boolean ifSuccess(String gameResult) {
        if (gameResult.equals(GAME_SUCCESS)) {
            return true;
        }
        return false;
    }
}
