package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameNumber {

    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 9;
    private static final String INPUT_REGEX = String.format("^[%d-%d]*$", RANDOM_MIN, RANDOM_MAX);

    public static final int SIZE = 3;
    private final List<Integer> numbers;

    public GameNumber() {
        numbers = new ArrayList<>();
        while (numbers.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public GameNumber(String input) {
        if (!input.matches(INPUT_REGEX)) {
            throw new IllegalArgumentException(RANDOM_MIN + "부터 " + RANDOM_MAX + "까지의 숫자만 입력해주세요.");
        }
        if (input.length() != SIZE) {
            throw new IllegalArgumentException(SIZE + "자리수로 입력해주세요.");
        }

        numbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            int randomNumber = Character.getNumericValue(input.charAt(i));
            if (numbers.contains(randomNumber)) {
                throw new IllegalArgumentException("입력에 중복되는 숫자가 있습니다.");
            }
            numbers.add(randomNumber);
        }
    }

    public static int strike(GameNumber computer, GameNumber player) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (computer.numbers.get(i) == player.numbers.get(i)) {
                count++;
            }
        }
        return count;
    }

    public static int ball(GameNumber computer, GameNumber player) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            int number = computer.numbers.get(i);
            if (player.numbers.get(i) != number && player.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
