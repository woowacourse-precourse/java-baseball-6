package baseball.view;

import baseball.controller.Controller;
import baseball.domain.Score;
import camp.nextstep.edu.missionutils.Console;

public class View {

    private final Controller controller = new Controller();
    private boolean quitGame = false;

    public void mainView() {

        introView();
        inGameView();
        outroView();
    }

    private void introView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        controller.generateRandomValue();
    }

    private void inGameView() {
        boolean isSuccess = false;

        while (!isSuccess) {
            System.out.println("숫자를 입력해주세요: ");
            String input = Console.readLine();
            Score score = controller.getScore(input);
            isSuccess = printResult(score);
        }
    }

    private void outroView() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        if (restart.equals("1")) {
            controller.generateRandomValue();
            inGameView();
        } else if (restart.equals("2")) {
            quitGame = true;
        }
    }



    private boolean printResult(Score score) {

        switch (score.getResultState()) {
            case NOTHING:
                System.out.println("낫싱");
                break;
            case BALL:
                System.out.printf("%d볼\n", score.getBall());
                break;
            case STRIKE:
                System.out.printf("%d스트라이크\n", score.getStrike());
                break;
            case BALL_AND_STRIKE:
                System.out.printf("%d볼 %d스트라이크\n", score.getBall(), score.getStrike());
                break;
            case THREE_STRIKE :
                System.out.println("3스트라이크");
                return true;
        }
        return false;
    }

}
