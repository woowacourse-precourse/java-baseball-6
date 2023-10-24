package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    // 서로 다른 3자리의 수를 입력받아 반환한다.
    public String inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");

        // 서로 다른 3자리의 수
        String number = Console.readLine();

        // 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
        if (!isValid(number)) {
            throw new IllegalArgumentException("입력 받은 숫자가 유효하지 않습니다.");
        }

        return number;
    }

    // 입력 받은 숫자가 유효한 지 확인한다.
    private boolean isValid(String str) {
        // 잘못된 값 1 : 길이가 다를 경우
        if (str.length() != 3) {
            return false;
        }

        // 잘못된 값 2 : 서로 다른 숫자가 아닐 경우
        if (str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2)
                || str.charAt(0) == str.charAt(2)) {
            return false;
        }

        return true;
    }

}
