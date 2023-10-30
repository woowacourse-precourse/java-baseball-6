package baseball.view;

import java.util.List;

public class OutputView {
    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String CORRECT_NUMBERS_END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public void printGameStart() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printGameResult(final List<Integer> result) {
        int strike = result.get(0);
        int ball = result.get(1);

        if (strike == 3) {
            System.out.println("3스트라이크\n"
                    + CORRECT_NUMBERS_END_GAME_MESSAGE);
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
}
