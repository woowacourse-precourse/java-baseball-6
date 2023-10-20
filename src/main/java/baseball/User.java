package baseball;

import java.util.HashSet;

public class User {
    protected String userSelectNum;

    public void userSelect() {
        System.out.println("숫자를 입력해주세요");
        userSelectNum = camp.nextstep.edu.missionutils.Console.readLine();
        userInputVaildationCheck(userSelectNum);
    }

    // 조건문을 하나로 합치면 안되는건가? 확인해보자
    public void userInputVaildationCheck(String userSelectNum) {
        HashSet<Character> hashUserSelectNum = new HashSet<>();
        if (userSelectNum.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        for (char num : userSelectNum.toCharArray()) {
            if (!hashUserSelectNum.add(num) && !Character.isDigit(num)) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }

    public String getUserSelectNum() {
        return userSelectNum;
    }

}
