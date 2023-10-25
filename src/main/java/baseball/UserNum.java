package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserNum {
    List<String> userNumList = new ArrayList<>();

    public List<String> getUserNum() {
        userNumList.clear(); // 리스트 초기화
        System.out.print("숫자를 입력해주세요 : ");
        String userNum = Console.readLine();

        while (!isValidInput(userNum)) {
            throw new IllegalArgumentException("Invalid argument: " + userNum);
        }

        userNumList.addAll(Arrays.asList(userNum.split("")));
        return userNumList;
    }

    private boolean isValidInput(String input) {
        return input.matches("\\d{3}");
    }
}
