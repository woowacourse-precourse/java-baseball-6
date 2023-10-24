package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class UserNum {
    List<Integer> user = new ArrayList<>();

    public UserNum(String number) {
        LengthCheck(number);
        CharisNumberCheck(number);
        DuplicateCheck(number);
        for (int i = 0; i < 3; i++) {
            user.add(Integer.parseInt(Character.toString(number.charAt(i))));
        }

    }

    public void initUserNum() {
        user.clear();
    }

    public List<Integer> getUser() {
        return this.user;
    }

    public static void LengthCheck(String word) throws IllegalArgumentException {
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리수)");
        }
    }

    public static void CharisNumberCheck(String word) throws IllegalArgumentException {
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(word.charAt(i))) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(3자리 자연수가 아닙니다.)");
            }
        }

    }

    public static void DuplicateCheck(String word) throws IllegalArgumentException {
        // List<Integer> temp = new ArrayList<>();
        // for (int i = 0; i < 3; i++) {
        // int num = word.charAt(i);
        // if (temp.contains(num)) {
        // throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자)");
        // }
        // }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            char ch = word.charAt(i);
            set.add(ch);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자)");
        }
    }
}
