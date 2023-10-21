package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserNum {
    List<String> userNumList = new ArrayList<>(); // 사용자가 입력한 3자리 숫자

    public List<String> userNum(String userNum) {
        // split으로 한 글자씩 자른 숫자를 userNumList에 저장
        userNumList.addAll(Arrays.asList(userNum.split("")));

        return userNumList;
    }

    public void getUserNum() {
        String userNum = Console.readLine(); // readLine()으로 3자리 숫자 입력받기

        UserNum user = new UserNum();
        userNumList = user.userNum(userNum);
    }
}