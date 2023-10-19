package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void greetingMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static Integer inputGuideMsg() {
        System.out.println("숫자를 입력해주세요 : ");
    public Integer inputGuideMsg() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");

        return Integer.parseInt(Console.readLine());
    }

}
