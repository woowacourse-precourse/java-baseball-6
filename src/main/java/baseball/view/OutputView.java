package baseball.view;

import java.util.List;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String THREE_STRIKE_AND_END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String START_NEW_GAME_OR_END_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printGameStart() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printInputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
    }

    public void printGameResult(final List<Integer> result) {
        int strike = result.get(0);
        int ball = result.get(1);

        if (strike == 3) {
            System.out.println(THREE_STRIKE_AND_END_GAME_MESSAGE);
            return;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱\n");
            return;
        }

        if (strike > 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }

        if (strike == 0 && ball > 0) {
            System.out.printf("%d볼\n", ball);
            return;
        }

        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }

    public void printStartNewGameOrEndGame() {
        System.out.println(START_NEW_GAME_OR_END_GAME_MESSAGE);
    }
}
