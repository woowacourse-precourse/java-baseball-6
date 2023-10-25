package baseball.view;

import baseball.controller.Controller;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.Console;

public class View {

    private final Controller controller = new Controller();

    public void mainView() {
        introView();
    }

    private void introView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameplayView();
    }

    private void gameplayView() {
        boolean isGameSuccess = false;

        while (!isGameSuccess) {
            System.out.println("숫자를 입력해주세요: ");
            String input = Console.readLine();

            Result result = controller.calculateGameResult(input);
            isGameSuccess = displayGameResult(result);
        }
        outroView();
    }

    private void outroView() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        boolean isRestart = controller.isRestart(input);
        if (isRestart) {
            gameplayView();
        }
    }

    private boolean displayGameResult(Result result) {

        switch (result.getResultState()) {
            case NOTHING ->
                System.out.println("낫싱");
            case BALL ->
                System.out.printf("%d볼\n", result.getBall());
            case STRIKE ->
                System.out.printf("%d스트라이크\n", result.getStrike());
            case BALL_AND_STRIKE ->
                System.out.printf("%d볼 %d스트라이크\n", result.getBall(), result.getStrike());
            case THREE_STRIKE -> {
                System.out.println("3스트라이크");
                return true;
            }
        }
        return false;
    }

}
