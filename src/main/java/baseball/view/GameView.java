package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    private static final GameView GAME_VIEW = new GameView();

    public static GameView getGameView() {
        return GAME_VIEW;
    }

    public String guessInputView() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String restartInputView() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public void gameStartView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void hintView(int ball, int strike) {
        StringBuilder resultStatement = new StringBuilder();

        if (ball > 0) {
            resultStatement.append(ball).append("볼");
        }

        if (strike > 0) {
            if (!resultStatement.isEmpty()) {
                resultStatement.append(" ");
            }
            resultStatement.append(strike).append("스트라이크");
        }

        if (resultStatement.isEmpty()) {
            resultStatement.append("낫싱");
        }

        System.out.println(resultStatement);
    }
}
