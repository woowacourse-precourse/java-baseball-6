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

    public void gameResult(int[] ballAndStrike) {
        if (ballAndStrike[0] == 0 && ballAndStrike[1] == 0) {
            System.out.print("낫싱");
        }
        if (ballAndStrike[0] != 0) {
            System.out.print(ballAndStrike[0] + "볼 ");
        }
        if (ballAndStrike[1] != 0) {
            System.out.print(ballAndStrike[1] + "스트라이크");
        }
        System.out.println();
    }

    public void winGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String selectGameProgress() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readLine();
    }

}
