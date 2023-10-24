package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Computer {
    private final Count answer;

    public Computer(Count answer) {
        this.answer = answer;
    }

    public Computer() {
        this.answer = Count.provideCount(generateRandomCount());
    }

    private String generateRandomCount() {
        Set<Integer> threeDigits = new HashSet<>();

        final int upperDigitBound = 3;
        final int lowerBound = 1;
        final int upperBound = 9;

        while (threeDigits.size() < upperDigitBound) {

            threeDigits.add(Randoms.pickNumberInRange(lowerBound, upperBound));
        }

        StringBuilder sb = new StringBuilder();
        for (Integer digit : threeDigits) {
            sb.append(digit);
        }

        return sb.toString();
    }

    public String judgeGameResult(Count guess) {
        String guessNumber = guess.toString();
        String answerNumber = answer.toString();
        StringBuilder gameResult = new StringBuilder();

        String ballCount = isBall(guessNumber, answerNumber);
        String strikeCount = isStrike(guessNumber, answerNumber);

        gameResult.append(ballCount.isEmpty() ? "" : ballCount + " ");
        gameResult.append(strikeCount.isEmpty() ? "" : strikeCount + " ");

        return isNothing(gameResult.toString()).trim();
    }

    private String isStrike(String guessNumber, String answerNumber) {
        int count = 0;
        for (int i = 0; i < guessNumber.length(); i++) {
            if (guessNumber.charAt(i) == answerNumber.charAt(i)) {
                count++;
            }
        }
        return (count == 0) ? "" : count + "스트라이크";
    }

    private String isBall(String guessNumber, String answerNumber) {
        int count = 0;
        for (int i = 0; i < guessNumber.length(); i++) {
            count = isPresentOtherDigit(guessNumber, answerNumber, i) ? count + 1 : count;
        }
        return (count == 0) ? "" : count + "볼";
    }

    private String isNothing(String result) {
        return (result.isEmpty()) ? "낫싱" : result;
    }

    private static boolean isPresentOtherDigit(String guessNumber, String answerNumber, int i) {
        for (int j = 0; j < answerNumber.length(); j++) {
            if (i == j) {
                continue;
            }
            if (guessNumber.charAt(i) == answerNumber.charAt(j)) {
                return true;
            }
        }
        return false;
    }
}
