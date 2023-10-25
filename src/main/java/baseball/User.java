package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String input;

    // 이름 반환 메서드
    public String getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
        return input;
    }

    // 사용자 입력값 배열에 저장
    public int[] saveUserInput(String input) {
        int[] numList = {input.charAt(0) - '0', input.charAt(1) - '0', input.charAt(2) - '0'};
        return numList;
    }
}
