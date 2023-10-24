package baseball.target;

import camp.nextstep.edu.missionutils.Console;

/*
 * 사용자가 하는 일을 다루는 클래스
 */
public class User {
    /*
     * 사용자로부터 값을 입력받는 메서드
     */
    public String getInputNumber() {
        return Console.readLine();
    }
}
