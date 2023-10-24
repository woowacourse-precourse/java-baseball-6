package baseball.entity;

import java.util.*;

public class GameLogic {
    private Map<String, Integer> compareResult = new HashMap<>();
    private List<Integer> playerGuessNumbers = new ArrayList<>();

    public List<Integer> validateAndReturnBaseBallNumber(String playerGuess) {
        if (playerGuess.length() != 3) {
            throw new IllegalArgumentException();
        }

        char[] charArr = playerGuess.toCharArray();

        for (char c: charArr) {
            if (Character.isDigit(c)) {
                int number = Character.getNumericValue(c);

                if (number >= 0 && !playerGuessNumbers.contains(number)) {
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
            for (int j = 0; j < computerNumbers.size(); j++) {
                if (Objects.equals(playerNumbers.get(i), computerNumbers.get(j)) && i == j) {
                    compareResult.put("strike", compareResult.get("strike") + 1);
                } else if (Objects.equals(playerNumbers.get(i), computerNumbers.get(j)) && i != j) {
                    compareResult.put("balls", compareResult.get("balls") + 1);
                }
            }
        }

        return compareResult;
    }
}
