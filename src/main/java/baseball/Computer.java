package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final Count answer;

    public Computer(Count answer) {
        this.answer = answer;
    }

    public Computer() {
        this.answer = Count.provideCount(generateRandomCount());
    }

    private String generateRandomCount() {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < 3; i++) {
            int deleteIndex = Randoms.pickNumberInRange(0, numbers.size() - 1);
            sb.append(numbers.remove(deleteIndex));
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
