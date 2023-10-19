package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    private String answer;

    BaseballGame() {
        setAnswer(generateNumber());
    }

    private String generateNumber() {
        StringBuilder number = new StringBuilder();
        while (number.length() < 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!number.toString().contains(randomNumber)) {
                number.append(randomNumber);
            }
        }
        return number.toString();
    }

    private void setAnswer(String number) {
        this.answer = number;
    }

    public int getBallCount(String userInput) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && userInput.charAt(j) == this.answer.charAt(i)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    public int getStrikeCount(String userInput) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) == this.answer.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
