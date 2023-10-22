package baseball.model;

import baseball.view.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Player {
    private final List<Character> playerNumber;

    public Player() {
        String input = Input.userNumber();
        validate(input);
        this.playerNumber = convertToCharList(input);
    }

    private void validate(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리의 숫자를 입력해주세요.");
        }

        Set<Character> uniqueDigits = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
            }

            uniqueDigits.add(ch);
        }

        if (uniqueDigits.size() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    private List<Character> convertToCharList(String input) {
        List<Character> list = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            list.add(ch);
        }
        return list;
    }

    public String getPlayerNumber() {
        StringBuilder sb = new StringBuilder();
        for (char ch : playerNumber) {
            sb.append(ch);
        }
        return sb.toString();
    }
}