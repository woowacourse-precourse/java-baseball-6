package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userRandNum; // user가 입력한 수 저장 배열

    public void setUserRandNum(String randNum) {
        userRandNum = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userRandNum.add(Integer.parseInt(randNum.charAt(i) + ""));
        }
    }

    public List<Integer> getUserRandNum() {
        return userRandNum;
    }
}
