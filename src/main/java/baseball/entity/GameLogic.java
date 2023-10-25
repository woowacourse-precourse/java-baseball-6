package baseball.entity;

import java.util.*;

public class GameLogic {
    private Map<String, Integer> compareResult = new HashMap<>();

    public List<Integer> validateAndReturnBaseBallNumber(String playerGuess) {
        List<Integer> playerGuessNumbers = new ArrayList<>();
        if (playerGuess.length() != 3) {
            throw new IllegalArgumentException();
        }

        char[] charArr = playerGuess.toCharArray();

        for (char c: charArr) {
            if (Character.isDigit(c)) {
                int number = Character.getNumericValue(c);
                if (number > 0 && !playerGuessNumbers.contains(number)) {
                    playerGuessNumbers.add(number);
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        return playerGuessNumbers;
    }

    public Map compareNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        compareResult.put("strike", 0);
        compareResult.put("balls", 0);

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (Objects.equals(playerNumbers.get(i), computerNumbers.get(i))) {
                compareResult.put("strike", compareResult.get("strike") + 1);
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                compareResult.put("balls", compareResult.get("balls") + 1);
            }
        }

        return compareResult;
    }
}
