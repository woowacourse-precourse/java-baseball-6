package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UI {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String insertNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public void gameResult(int ball, int strike) {
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println("\n");
    }

    public void winGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String selectGameProgress() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readLine();
    }

}
