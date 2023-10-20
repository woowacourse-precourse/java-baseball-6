package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CalculateScore {

    private static boolean contains(List<Integer> numbers, int value) {
        return numbers.stream()
                .anyMatch(number -> number.equals(value));
    }

    private static int correct(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            return 1;
        }
        return 0;
    }

    private static int countContains(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return Optional.of(userNumbers.stream()
                .filter(userNumber -> contains(computerNumbers, userNumber))
                .count()).orElse(0L).intValue();
    }

    private static int countStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int count = 0;
        for (int i=0;i<computerNumbers.size();i++) {
            count += correct(computerNumbers.get(i), userNumbers.get(i));
        }
        return count;
    }

    private static int countBall(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return countContains(computerNumbers, userNumbers) - countStrike(computerNumbers, userNumbers);
    }

    public static Map<String, Integer> gameScore(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int countBall = countBall(computerNumbers, userNumbers);
        int countStrike = countStrike(computerNumbers, userNumbers);
        Map<String, Integer> score = new HashMap<>();
        score.put("ball", countBall);
        score.put("strike", countStrike);
        return score;
    }
}
