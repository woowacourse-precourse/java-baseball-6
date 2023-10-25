package baseball;

import java.util.HashSet;

public class User {
    private String userSelectNum;

    public void userSelect() {
        System.out.println("숫자를 입력해주세요");
        userSelectNum = camp.nextstep.edu.missionutils.Console.readLine();
        userInputVaildationCheck(userSelectNum);
    }
    
    public void userInputVaildationCheck(String userSelectNum) {
        HashSet<Character> hashUserSelectNum = new HashSet<>();
        if (userSelectNum.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        for (char num : userSelectNum.toCharArray()) {
            if (!Character.isDigit(num) || !hashUserSelectNum.add(num)) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }

    public String getUserSelectNum() {
        return userSelectNum;
    }
}
