package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameNumber {

    private static final int start = 1;
    private static final int end = 9;

    public static final int size = 3;
    private final List<Integer> numbers;

    public GameNumber() {
        numbers = new ArrayList<>();
        while (numbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

//        System.out.println("numbers = " + numbers);
    }

    public GameNumber(String inputNumbers) {
        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException("입력이 3자리수가 아닙니다.");
        }

        numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            int randomNumber = Character.getNumericValue(inputNumbers.charAt(i));

            if (randomNumber < start || randomNumber > end) {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해야 합니다.");
            } else if (numbers.contains(randomNumber)) {
                throw new IllegalArgumentException("입력에 중복되는 숫자가 있습니다.");
            }

            numbers.add(randomNumber);
        }
    }

    public static int strike(GameNumber computer, GameNumber player) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (computer.numbers.get(i) == player.numbers.get(i)) {
                count++;
            }
        }
        return count;
    }

    public static int ball(GameNumber computer, GameNumber player) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            int number = computer.numbers.get(i);
            if (player.numbers.get(i) != number && player.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
