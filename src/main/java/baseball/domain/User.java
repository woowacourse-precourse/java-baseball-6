package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private List<Integer> userNumbers;

    private static final int THREE_NUMBER = 3;

    private static final int OVER_RANGE_NUMBER = 0;

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();

        userNumbers = new ArrayList<>();
        try {
            for (int i = 0; i < number.length(); i++) {
                userNumbers.add(Integer.parseInt(Character.toString(number.charAt(i))));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력하세요.");
        }
        validate(userNumbers);
    }

    public void validate(List<Integer> userNumbers) {
        checkDuplication(userNumbers);
        checkLength(userNumbers);
        checkRange(userNumbers);
    }

    public void checkDuplication(List<Integer> userNumbers) {
        Set<Integer> check = new HashSet<>(userNumbers);
        if (userNumbers.size() != check.size()) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력하세요.");
        }
    }

    public void checkLength(List<Integer> userNumbers) {
        if (userNumbers.size() != THREE_NUMBER) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력하세요.");
        }
    }

    public void checkRange(List<Integer> userNumbers) {
        if (userNumbers.contains(OVER_RANGE_NUMBER)) {
            throw new IllegalArgumentException("1부터 9까지의 숫자를 입력하세요.");
        }
    }

}
