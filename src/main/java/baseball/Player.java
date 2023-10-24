package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private List<Integer> playerNumbers = new ArrayList<>();

    public Player(String inputString) {
        checkNumberLength(inputString);
        checkIsDigit(inputString);
        checkNumberDuplicate(inputString);

        for (int i = 0; i < inputString.length(); i++) {
            playerNumbers.add(Integer.valueOf(inputString.substring(i, i + 1)));
        }
    }

    public List<Integer> getDuplicatePlayerList() {
        return new ArrayList<>(playerNumbers);
    }

    private void checkNumberLength(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. (3자리 수만 가능)");
        }
    }

    private void checkIsDigit(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            int number = inputString.charAt(i);

            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. (1~9의 자연수만 가능)");
            }
        }
    }

    private void checkNumberDuplicate(String inputString) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            set.add(inputString.charAt(i));
        }

        if (set.size() != inputString.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. (중복된 숫자 불가능)");
        }
    }
}
