package baseball.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class GameLogic {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;

    private List<Integer> computerNumbers;

    public void startGame() {
        this.computerNumbers = generateRandomNumbers();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Set<Integer> usedNumbers = new HashSet<>();

        while (numbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (usedNumbers.add(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    public List<Integer> getPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> numbers = parseUserInput(input);
        validateInput(numbers);

        return numbers;
    }

    private List<Integer> parseUserInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.add(Character.getNumericValue(c));
            }
        }
        return numbers;
    }

    private void validateInput(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }

        for (int num : numbers) {
            if (num < MIN_NUMBER || num > MAX_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> computeResult(List<Integer> playerNumbers) {
        List<Integer> result = new ArrayList<>();
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikeCount++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                ballCount++;
            }
        }

        result.add(ballCount);
        result.add(strikeCount);
        return result;
    }

    public boolean checkMatch(List<Integer> playerNumbers) {
        return computerNumbers.equals(playerNumbers);
    }

    public String getUserInput() {
        return Console.readLine();
    }
}
