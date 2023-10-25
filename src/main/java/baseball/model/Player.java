package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private List<Character> playerNumber;

    public Player(String input) {
        playerValidate(input);
        this.playerNumber = convertToCharList(input);
    }

    private void playerValidate(String input) {
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
        return playerNumber.stream()
                .map(String::valueOf)
                .reduce("", (s1, s2) -> s1 + s2);
    }
}
