package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getUserInput() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public String getRestartInput() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
