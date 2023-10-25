package baseball.game;

import java.util.ArrayList;
import java.util.List;
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

        while (numbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    public List<Integer> getPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validate(input);

        List<Integer> numbers = new ArrayList<>();
        String[] splitInput = input.split("");
        for (String s : splitInput) {
            int num = Integer.parseInt(s);
            numbers.add(num);
        }

        return numbers;
    }

    private void validate(String input) {
        if (input.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }

        int[] count = new int[10];
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException();
            }
            count[ch - '0']++;
            if (count[ch - '0'] > 1) {
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
