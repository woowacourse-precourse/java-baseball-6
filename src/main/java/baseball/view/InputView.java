package baseball.view;

import baseball.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void firstStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String startInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        InputValidation.verifyInputNum(inputNum);
        return inputNum;
    }

    public static String endInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
