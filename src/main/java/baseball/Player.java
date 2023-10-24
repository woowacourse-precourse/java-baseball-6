package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Player {

    private List<Integer> number;

    public Player() {
        this.number = new ArrayList<>();
    }

    public List<Integer> getNumber() {
        return this.number;
    }

    public void setNumber(String input) {
        // 배열 초기화
        this.number.clear();

        // 입력된 숫자 검증
        validate(input);

        for (char c : input.toCharArray()) {
            this.number.add(Character.getNumericValue(c));
        }
    }

    public void validate(String input) {
        HashSet<Character> set = new HashSet<>();

        // 아무것도 입력하지 않았을 경우
        if (input == null) {
            throw new IllegalArgumentException("아무것도 입력하지 않았을 경우");
        }

        // 입력한 숫자의 길이가 3이 아닌 경우
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자의 길이가 3이 아닌 경우");
        }

        for (char c : input.toCharArray()) {
            int value = c - '0';
            if (value <= 0 || value > 9) {
                throw new IllegalArgumentException("입력한 숫자가 1과 9사이의 값이 아닌 경우");
            }
        }

        for (char c : input.toCharArray()) {
            set.add(c);
        }

        if (set.size() != input.length()) {
            throw new IllegalArgumentException("입력한 숫자에 중복 값이 포함된 경우");
        }

    }
}
