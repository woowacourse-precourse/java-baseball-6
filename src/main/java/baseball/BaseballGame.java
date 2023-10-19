package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    private String answer;
    public static final int BASEBALL_DIGIT = 3;

    private String generateNumber() {
        StringBuilder number = new StringBuilder();
        while (number.length() < BASEBALL_DIGIT) {
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

    public int getBallCount(String userInput) throws IllegalArgumentException{
        if(userInput.length() != BASEBALL_DIGIT) {
            throw new IllegalArgumentException(String.format("숫자는 %d자리입니다.", BASEBALL_DIGIT));
        }

        int ballCount = 0;
        for (int i = 0; i < BASEBALL_DIGIT; i++) {
            for (int j = 0; j < BASEBALL_DIGIT; j++) {
                if (i != j && userInput.charAt(j) == this.answer.charAt(i)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    public int getStrikeCount(String userInput) throws IllegalArgumentException {
        if (userInput.length() != BASEBALL_DIGIT) {
            throw new IllegalArgumentException(String.format("숫자는 %d자리입니다.", BASEBALL_DIGIT));
        }

        int strikeCount = 0;
        for (int i = 0; i < BASEBALL_DIGIT; i++) {
            if (userInput.charAt(i) == this.answer.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public void generate() {
        setAnswer(generateNumber());
    }
}
