package baseball.view;

import baseball.vaildation.InputVaild;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return InputVaild.inputVaildation(Console.readLine());
    }

    public String getRestartInput() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
