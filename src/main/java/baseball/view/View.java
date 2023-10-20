package baseball.view;

import baseball.controller.Controller;
import baseball.domain.Score;
import camp.nextstep.edu.missionutils.Console;

public class View {

    private final Controller controller = new Controller();
    private boolean quitGame = false;

    public void mainView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        controller.generateRandomValue();

        while (!quitGame) {
            System.out.println("숫자를 입력해주세요: ");
            String input = Console.readLine();
            Score score = controller.getScore(input);
            printResult(score);
        }
    }

    private void printResult(Score score) {
        int strike = score.getStrike();
        int ball = score.getBall();

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            handleGameCompletion();
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private void handleGameCompletion() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();

        if (restart.equals("1")) {
            controller.generateRandomValue();
        } else if (restart.equals("2")) {
            quitGame = true;
        }
    }
}
