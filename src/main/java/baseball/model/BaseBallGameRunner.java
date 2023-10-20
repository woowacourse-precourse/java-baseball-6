package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGameRunner {
    private Computer computer;

    public BaseBallGameRunner() {
        this.computer = new Computer();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String inputString = getPlayerInput();
    }

    private String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
