package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {

    public BaseballGameView() {

    }

    public void startView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public int readUserInputView() {
        System.out.print("숫자를 입력해주세요 : ");
        return Integer.parseInt(Console.readLine());
    }


}
