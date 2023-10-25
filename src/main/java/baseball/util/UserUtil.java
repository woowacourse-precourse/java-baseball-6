package baseball.util;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 측에서 사용되는 유틸 클래스
 */
public class UserUtil {

    /**
     * 사용자로부터 값을 입력받는 메서드
     */
    public String getInputNumber() {
        return Console.readLine();
    }
}