package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class User {

    String number;

    public String getNumber() {
        return number;
    }

    public User() {
        String input = Console.readLine();

        // 입력값이 3자리 숫자인지 검사
        if (input.length() != 3 || !input.matches("\\d{3}")) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해야 합니다.");
        }

        // 중복된 숫자가 있는지 검사
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : input.toCharArray()) {
            uniqueChars.add(c);
        }
        if (uniqueChars.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }

        this.number = input;
    }

}
