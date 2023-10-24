package baseball;

import camp.nextstep.edu.missionutils.Console;

/**
 * 나는 숫자야구게임이야. 게임를 실행시키고 게임의 룰을 관리해줄게
 */

public class Game {

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String BALL_STR = "볼";
    public static final String STRIKE_STR = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String EMPTY_STR = " ";
    public static final String WIN_STR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final int START_OPTION = 1;
    public static final int EXIT_OPTION = 2;
    public static int RESTART_GAME = 0;


    private Computer computer;
    private User user;
    private NumberCompare numberCompare;


    public void playGame() {
        inItGame();
        startGame();
        endGame();
    }

    public void inItGame() {
        computer = new Computer();
        user = new User();
        numberCompare = new NumberCompare();

    }

    public void startGame() {
        int strike;

        if (RESTART_GAME == 0) {
            PrintInsertMessage();
        }

        do {
            InputUserNumber();
            int[] compare = numberCompare.calculateBallAndStrike(user.getUserNumber(), computer.getComputerNumber());
            PrintHint(getHint(compare));
            strike = compare[1];
        } while (strike != 3);
    }

    public void endGame() {
        System.out.println(WIN_STR);
        System.out.println(EXIT_MESSAGE);

        int input = Integer.parseInt(Console.readLine());
        if (input == START_OPTION) {
            RESTART_GAME = 1;
            playGame();
        }

        if (input == EXIT_OPTION) {

        }
    }

    private void InputUserNumber() {
        user.setUserNumber();
    }


    public String setHint(int ball, int strike) {
        if (strike == 3) {
            return strike + STRIKE_STR;
        }
        if (ball == 0 && strike == 0) {
            return NOTHING;
        }
        if (ball == 0 && strike != 0) {
            return strike + STRIKE_STR;
        }
        if (ball != 0 && strike == 0) {
            return ball + BALL_STR;
        }
        return ball + BALL_STR + " " + strike + STRIKE_STR;
    }

    public String getHint(int[] result) {
        int ball = result[0];
        int strike = result[1];
        return setHint(ball, strike);
    }

    public void PrintHint(String hint) {
        System.out.println(hint);
    }

    public void PrintInsertMessage() {
        System.out.println(START_MESSAGE);
    }

}
