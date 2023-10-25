package baseball.view;

import baseball.domain.Hint;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public void postHint(Hint hint) {
        Integer strike = hint.getStrike();
        Integer ball = hint.getBall();

        if (checkThreeStrike(strike)) return;
        printHint(strike, ball);
    }

    public String startNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readLine();
    }

    public void endGame() {
        System.out.println("게임을 종료합니다.");
    }

    private static void printHint(Integer strike, Integer ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private static boolean checkThreeStrike(Integer strike) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
