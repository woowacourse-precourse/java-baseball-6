package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

import static baseball.constant.Constant.*;

public class Computer {
    private String numbers;

    public Computer() {
        generateNumber();
    }

    public void resetNumber() {
        numbers = "";
        generateNumber();
    }

    private void generateNumber() {
        numbers = "";
        Set<String> duplicateCheck = new HashSet<>();
        while (numbers.length() < NUMBER_LENGTH) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (duplicateCheck.add(randomNumber)) numbers += randomNumber;
        }
    }

    public String checkGuess(String guess) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (guess.charAt(i) == numbers.charAt(i)) strikeCount++;
            else if (numbers.indexOf(guess.charAt(i)) > -1) ballCount++;
        }
        return generateResultMessage(ballCount, strikeCount);
    }

    private String generateResultMessage(int ballCount, int strikeCount) {
        if (strikeCount == 0 && ballCount == 0) return NOTING;
        return (ballCount > 0 ? ballCount + BALL : "") + (strikeCount > 0 ? strikeCount + STRIKE : "");
    }
}