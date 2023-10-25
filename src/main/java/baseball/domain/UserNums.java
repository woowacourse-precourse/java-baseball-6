package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserNums {
    private List<Integer> userNums;

    public UserNums() {
        List<String> user_str_list = List.of(Console.readLine().split(""));
        if (user_str_list.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        int num = 0;
        List<Integer> user_int_list = new ArrayList<>();
        for (String str : user_str_list) {
            if (str.equals("0")) {
                throw new IllegalArgumentException("1 ~ 9 값을 입력해주세요");
            }
            try {
                num = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
            if (user_int_list.contains(num)) {
                throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력해주세요.");
            } else {
                user_int_list.add(num);
            }
        }
        this.userNums = user_int_list;
    }

    public boolean contains(int num) {
        return userNums.contains(num);
    }

    public int get(int i) {
        return userNums.get(i);
    }
}
