package baseball.View;

import static baseball.Controller.BaseballController.CLOSE_GAME;
import static baseball.Controller.BaseballController.RESTART_GAME;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
    public void printRequestUserNum() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
    }

    public void printNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printBallAndStrike(int ball, int strike) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }
        if (strike != 0) {
            System.out.println(strike + "스트라이크 ");
            return;
        }
        if (ball != 0) {
            System.out.println(ball + "볼");
        }
    }

    public String getUserNum() {
        String userNum = Console.readLine();
        handleInputException(userNum);
        return userNum;
    }

    public String getReplayNum() {
        String replayNum = Console.readLine();
        handleReplayException(replayNum);
        return replayNum;
    }

    public void handleReplayException(String replayChoose) {
        if (!replayChoose.equals(RESTART_GAME) && !replayChoose.equals(CLOSE_GAME)) {
            throw new IllegalArgumentException();
        }
    }

    public void handleInputException(String userNum) {
        if (userNum.length() != 3) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(userNum);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        } finally {
            isDuplicated(userNum);
        }
    }

    private void isDuplicated(String userNum) {
        char userNumChar0 = userNum.charAt(0);
        char userNumChar1 = userNum.charAt(1);
        char userNumChar2 = userNum.charAt(2);

        if (userNumChar0 == userNumChar1) {
            throw new IllegalArgumentException();
        }
        if (userNumChar0 == userNumChar2) {
            throw new IllegalArgumentException();
        }
        if (userNumChar1 == userNumChar2) {
            throw new IllegalArgumentException();
        }
    }
}
