package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Parser {
    // 외부에서 메서드를 바로 사용하는 클래스이므로 외부에서 사용할 메서드를 스태틱으로 선언한다.
    public static int parseNumber() {
        // 문자열에서 숫자로 정상 변경이 되는지 확인
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력하세요.");
        }
    }
}
