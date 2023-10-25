package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> UserPickedNumberList = new ArrayList<>(3);

    public User() {
    }

    public List userPickNumberStringToList(String userPickNumberString) {
        /** 사용자에게 입력받을 때 생기는 에외 */
        userPickNumStringCheck(userPickNumberString);
        for (int i = 0; i < userPickNumberString.length(); i++) {
            int userPickNum = (int) userPickNumberString.charAt(i) - 48;
            if (!UserPickedNumberList.contains(userPickNum) && userPickNum!=0) {
                UserPickedNumberList.add((int) userPickNumberString.charAt(i) - 48);
            }
        }
        return UserPickedNumberList;
    }

    private void userPickNumStringCheck(String userPickNumberString) {
        if (userPickNumberString.length()!=3) {
            throw new IllegalArgumentException("1~9까지의 서로 다른 3개의 수만 입력하세요.");
        }
    }
}