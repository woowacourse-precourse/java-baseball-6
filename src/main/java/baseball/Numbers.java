package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Numbers {

    public static final int MAX_DIGIT = 3;
    private final List<Integer> list;

    public Numbers() {
        this.list = new ArrayList<>();
        while (list.size() < MAX_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
    }

    public Numbers(String input) {
        validateInput(input);
        this.list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    private void validateInput(String input) {
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
        }

        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2)
            || input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        }
    }

    public List<Integer> getList() {
        return List.copyOf(list);
    }
}
