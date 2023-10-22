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
            System.out.print("올바른 입력이 아닙니다. 3자리 숫자를 다시 입력하세요: ");
            userNum = Console.readLine();
        }

        userNumList.addAll(Arrays.asList(userNum.split("")));
        return userNumList;
    }

    private boolean isValidInput(String input) {
        return input.matches("\\d{3}");
    }
}
