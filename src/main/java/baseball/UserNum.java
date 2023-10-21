package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNum {
    List<String> userNumList = new ArrayList<>(); // 사용자가 입력한 3자리 숫자

    public List<String> userNum() {
        String userNum = Console.readLine(); // readLine()으로 

        for (String number : userNum.split("")) {
            userNumList.add(number);
        }
        return  userNumList;
    }
}
