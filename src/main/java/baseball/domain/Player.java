package baseball.domain;

import static baseball.constant.GameMessage.INPUT_ERROR_MESSAGE;
import static baseball.constant.GameMessage.INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Player {
    private List<Integer> numbers;

    public Player() {
        this.numbers = new ArrayList<>();
    }

    // 사용자로부터 서로 다른 3개의 수를 입력받음
    public void inputNumbers() throws IllegalArgumentException {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();

        // 1. 입력된 문자열이 정확히 3자리인지 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        // 2. 입력된 문자열이 1에서 9까지의 숫자로만 구성되어 있는지 확인
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        // 3. 입력된 문자열이 중복된 숫자를 포함하고 있는지 확인
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (uniqueChars.contains(c)) {
                throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
            }
            uniqueChars.add(c);
        }

        // 입력된 문자열을 숫자 리스트로 변환
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
    }

    public int getNumberOf(int index) {
        return numbers.get(index);
    }
}
