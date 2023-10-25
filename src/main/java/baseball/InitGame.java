package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InitGame {
    public List<Integer> userNum() {
        System.out.println("숫자를 입력해주세요: ");
        List<Integer> userNum = new ArrayList<>();
        String input = Console.readLine();
        for (String num : input.split("")) {
            userNum.add(Integer.parseInt(num));
        }
        exception_length(input);
        return userNum;
    }

    private void exception_length(String str) {
        if (str.length() != 3) {
            throw new IllegalArgumentException("숫자는3개 입력해야 합니다.");
        }
    }
}