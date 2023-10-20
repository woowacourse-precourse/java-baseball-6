package baseball.logic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Compare {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public String getGameResult(List<Integer> computerInput, String userInput) {
        validateUserInput(userInput);

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < computerInput.size(); i++) {
            if (isStrike(computerInput.get(i), userInput.charAt(i))) {
                strikeCount++;
            } else if (isBall(computerInput.get(i), userInput)) {
                ballCount++;
            }
        }

        return generateResultMessage(strikeCount, ballCount);
    }

    private void validateUserInput(String userInput) {
        if (!isThreeDigitNumber(userInput)) {
            throw new IllegalArgumentException("3자리의 양의 정수를 입력해야 됩니다. 사용자의 입력 : " + userInput);
        }

        if (!hasDistinctDigits(userInput)) {
            throw new IllegalArgumentException("서로 다른 양의 정수 3자리가 입력되어야 합니다. 사용자의 입력 : " + userInput);
        }
    }

    // 스트라이크 확인
    private boolean isStrike(int computerDigit, char userDigit) {
        return computerDigit == Character.getNumericValue(userDigit);
    }

    // 볼 확인
    private boolean isBall(int computerDigit, String userDigits) {
        return userDigits.contains(String.valueOf(computerDigit));
    }

    // 사용자의 입력값 스트라이크, 볼, 낫싱 판정
    private String generateResultMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING;
        }
        if (strikeCount == 0) {
            return ballCount + BALL;
        }
        if (ballCount == 0) {
            return strikeCount + STRIKE;
        }
        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    // 3자리의 정수인지 확인
    private boolean isThreeDigitNumber(String userInput) {
        return userInput.matches("\\d{3}");
    }

    // 서로 다른 숫자가 입력 되었는지 확인
    private boolean hasDistinctDigits(String userInput) {
        Set<Character> digits = new HashSet<>();

        for (char ch : userInput.toCharArray()) {
            digits.add(ch);
        }

        return digits.size() == userInput.length();
    }
}
