package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGameEnd {

    private final String playerOrder;

    public BaseBallGameEnd() {
        output();
        this.playerOrder = input();
    }

    private void output() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private String input() {
        return Console.readLine();
    }

    public boolean orderCheck() {
        switch (this.playerOrder) {
            case "1":
                return false;
            case "2":
                return true;
            default:
                throw new IllegalArgumentException();

        }
    }
}

