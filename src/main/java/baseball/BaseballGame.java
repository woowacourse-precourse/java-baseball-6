package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final int NUMBER_LENGTH = 3;
    List<Integer> baseballNumber;

    public BaseballGame() {
        this.baseballNumber = generateBaseballNumber();
    }

    public void play() throws IllegalArgumentException {
        String userInput;
        while (true) {
            userInput = ConsoleHandler.requestInput("숫자를 입력해주세요 : ");

            if (!UserInputValidator.checkValidBaseballNumber(userInput)) {
                throw new IllegalArgumentException("잘못된 입력값 입니다.");
            }

            int strikeCount = countStrike(userInput);
            int ballCount = countBall(userInput);

            ConsoleHandler.displayGameResult(strikeCount, ballCount);

            if (strikeCount == NUMBER_LENGTH) {
                ConsoleHandler.showMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    private List<Integer> generateBaseballNumber() {
        List<Integer> baseballNumber = new ArrayList<>();
        while (baseballNumber.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumber.contains(randomNumber)) {
                baseballNumber.add(randomNumber);
            }
        }
        return baseballNumber;
    }

    private int countStrike(String userInput) {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (baseballNumber.get(i) == Character.getNumericValue(userInput.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(String userInput) {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int num = Character.getNumericValue(userInput.charAt(i));
            if (baseballNumber.contains(num) && baseballNumber.indexOf(num) != i) {
                count++;
            }
        }

        return count;
    }
}
