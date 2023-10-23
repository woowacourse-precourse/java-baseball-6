package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballManager {
    private List<Integer> ballNumbersList;
    private final int NUMBER_SIZE = Constant.fixed_Number_Size;

    public BaseballManager(String numberString) {
        initializeBallNumbers(numberString);
    }

    public BaseballManager(List<Integer> ballNumbersList) {
        initializeBallNumbers(ballNumbersList);
    }

    private void initializeBallNumbers(String input) {
        try {
            validateSize(input);
            ballNumbersList = new ArrayList<>();
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (char charNum : input.toCharArray()) {
                int number = Character.getNumericValue(charNum);
                if (uniqueNumbers.contains(number)) {
                    throw new IllegalArgumentException(Constant.Number_Overlap_Exception);
                }
                uniqueNumbers.add(number);
                ballNumbersList.add(number);
            }
            if (ballNumbersList.size() != NUMBER_SIZE) {
                throw new IllegalArgumentException(Constant.Number_Size_Exception);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initializeBallNumbers(List<Integer> numbers) {
        try {
            validateSize(numbers);
            ballNumbersList = new ArrayList<>(numbers);
            validateDuplicateNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateSize(String input) {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(Constant.Number_Size_Exception);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(Constant.Number_Size_Exception);
        }
    }

    private void validateDuplicateNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>(ballNumbersList);
        if (uniqueNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(Constant.Number_Overlap_Exception);
        }
    }

    public int getStrike(BaseballManager otherManager) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (ballNumbersList.get(i).equals(otherManager.ballNumbersList.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBall(BaseballManager otherManager) {
        int ballCount = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int ballNumber = ballNumbersList.get(i);
            for (int j = 0; j < NUMBER_SIZE; j++) {
                if (i != j && ballNumber == otherManager.ballNumbersList.get(j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    public boolean isNothing(BaseballManager otherManager) {
        return ballNumbersList.stream().noneMatch(otherManager.ballNumbersList::contains);
    }
}
