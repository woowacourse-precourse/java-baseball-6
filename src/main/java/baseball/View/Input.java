package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();

        if (isValidUserNumber(userNumber)) {
            return userNumber;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 세 자리 서로 다른 숫자를 입력하세요.");
        }
    }

    public static String inputRetryNumber(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    private static boolean isValidUserNumber(String number) {
        if (number.length() != 3) {
            return false;
        }

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            if (number.indexOf(digit) != number.lastIndexOf(digit)) {
                return false;
            }
        }

        return true;
    }
}
