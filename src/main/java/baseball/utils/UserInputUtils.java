package baseball.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserInputUtils {
    static int size;

    public static void setSize(int size) {
        UserInputUtils.size = size;
    }

    public static void checkDuplication(String user) {
        HashSet<Character> hashSet = new HashSet<>();
        for (Character c : user.toCharArray()) {
            hashSet.add(c);
        }
        if (hashSet.size() != size) {
            throw new IllegalArgumentException("중복된 값이 있습니다. 프로그램을 종료합니다.");
        }
    }

    public static void checkSize(String user) {
        if (user.length() != size) {
            throw new IllegalArgumentException("컴퓨터와 유저의 숫자 사이즈가 다릅니다. 프로그램을 종료합니다.");
        }
    }

    public static void checkRangeAndDigit(String user) {
        for (char c : user.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("정수가 아닌 값을 입력하셨습니다. 프로그램을 종료합니다.");
            }
            if (c == '0') {
                throw new IllegalArgumentException("0을 입력했습니다. 가능한 값은 1~9 값중 입력해야합니다. 프로그램을 종료합니다.");
            }
        }
    }

    public static List<Integer> convertStringToInteger(String user) {
        List<Integer> list = new ArrayList<>();
        for (String s : user.split("")) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }
}
