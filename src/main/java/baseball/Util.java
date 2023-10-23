package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static String getArgument() {
        String str = Console.readLine().trim();

        if (str.equals("1") || str.equals("2")) {
            return str;
        }
        throw new IllegalArgumentException("1 혹은 2만 입력하세요!");
    }

    public static List<Integer> getNumber() {
        String str = Console.readLine().trim();
        List<Integer> list = new ArrayList<>();

        boolean[] check = new boolean[10];

        if (str.length() != 3) {
            throw new IllegalArgumentException("3자리만 입력하세요!");
        }
        for (char c : str.toCharArray()) {
            if (c > '9' || c < '1') {
                throw new IllegalArgumentException("1~9사이 숫자만 입력하세요!");
            }
            if (check[c - '0']) {
                throw new IllegalArgumentException("서로 다른 숫자만 입력하세요!");
            }
            check[c - '0'] = true;
            list.add(c - '0');
        }

        return list;
    }
}
