package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserNum {
    List<String> userNumList = new ArrayList<>(); // 사용자가 입력한 3자리 숫자

    public void getUserNum(List<String> userNumList) {
        String userNum = Console.readLine(); // readLine()으로 3자리 숫자 입력받기

        UserNum user = new UserNum();
        userNumList = user.splitUserNum(userNum);
    }

    public List<String> splitUserNum(String userNum) {
        userNumList.addAll(Arrays.asList(userNum.split("")));
        // split으로 한 글자씩 자른 숫자를 userNumList에 저장

        return userNumList;
    }
}