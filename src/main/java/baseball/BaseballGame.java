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
}
