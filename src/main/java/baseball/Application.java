package baseball;

import camp.nextstep.edu.missionutils.Console;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String numberStr = readLine();
        System.out.println(numberStr);

        boolean isThreeDifferentDigit = isThreeDifferentDigit(numberStr);
        if (isThreeDifferentDigit) {
            System.out.println(numberStr);
        } else {
            throw new IllegalArgumentException("서로 다른 3자리 숫자가 아닙니다.");
        }
    }

    public static boolean isThreeDifferentDigit(String numberStr) {
        // 숫자가 아닐 때
        try {
            Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        // 3자리가 아닐때
        if (numberStr.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }

        char digit1 = numberStr.charAt(0);
        char digit2 = numberStr.charAt(1);
        char digit3 = numberStr.charAt(2);
        return digit1 != digit2 && digit1 != digit3 && digit2 != digit3;
    }
}