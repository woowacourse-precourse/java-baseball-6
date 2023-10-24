package baseball.util;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 측에서 입력하는 유틸 클래스
 */
public class UserUtil {

    /**
     * 사용자로부터 값을 입력받는 메서드
     */
    public String getInputNumbers(){
        return Console.readLine();
    }
}
