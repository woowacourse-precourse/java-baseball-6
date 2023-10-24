package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String number;

    public User() {
    }

    public String getNumber() {
        return number;
    }

    public void validateNumber(String number) {
        if (number.length() != 3 || !number.matches("\\d{3}")) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해야 합니다.");
        }

        Set<Character> uniqueChars = new HashSet<>();
        for (char c : number.toCharArray()) {
            uniqueChars.add(c);
        }
        if (uniqueChars.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }

        this.number = number;
    }
}


