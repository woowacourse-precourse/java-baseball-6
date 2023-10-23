package baseball.controller;

import baseball.view.Input;
import baseball.model.Target;

public class Game {
    Target target;
    String userString = "";

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        target = new Target();
        int[] targetNum = target.getTargetNum();

        while (!Hint.isAnswer) {
            userString = Input.inputUserNum();
            int[] userNum = Input.getIntegerArrayFromString(userString);

            Hint.doBaseball(userNum, targetNum);
        }
        Input.scannerClose();
    }
}
