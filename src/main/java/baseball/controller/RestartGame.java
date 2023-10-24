package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

public class RestartGame {

    public boolean shouldRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String startNum = Console.readLine();
        if (startNum.equals("1")) {
            return true;
        } else if (startNum.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
