package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    public static final String STRING_GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String STRING_GAME_CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String STRING_GAME_EXIT = "게임을 종료합니다.";
    public static final String STRING_GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INPUT_RESTART_NUMBER = "1";
    public static final String INPUT_EXIT_NUMBER = "2";
    public static final String STRING_STRIKE = "스트라이크";
    public static final String STRING_BALL = "볼";
    public static final String STRING_NOTHING = "낫싱";
    User user = new User();
    String EXCEPTION_MESSAGE = user.EXCEPTION_MESSAGE;

    Computer computer = new Computer();
    private boolean isPlaying = true;
    int strike;
    int ball;
    int userNum;
    List<Integer> computerNum;

    public void gamePlay() {
        System.out.println(STRING_GAME_START);
        computer.setComputerNum();
        while (isPlaying) {
            user.setUserNum();
            isStrikeOrBall();
        }
    }

    //사용자의 숫자를 기준으로 스트라이크, 볼, 낫싱 판단
    void isStrikeOrBall() {
        computerNum = computer.getComputerNum();
        userNum = user.getUserNum();
        strike = 0;
        ball = 0;
        String userNumString = Integer.toString(userNum);
        for (int i = 0; i < computerNum.size(); i++) {
            int userDigit = Integer.parseInt(userNumString.charAt(i) + "");
            if (computerNum.contains(userDigit)) {
                if (computerNum.get(i) == userDigit) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        call();
    }

    void call() {
        if (strike == 0 && ball == 0) {
            System.out.println(STRING_NOTHING);
        } else if (strike == 3) {
            isPlaying = false;
            System.out.println(strike + STRING_STRIKE);
            System.out.println(STRING_GAME_CLEAR);
            gameRestart();
        } else if (strike == 0) {
            System.out.println(ball + STRING_BALL);
        } else if (ball == 0) {
            System.out.println(strike + STRING_STRIKE);
        } else {
            System.out.println(ball + STRING_BALL + " " + strike + STRING_STRIKE);
        }
    }

    void gameRestart() {
        System.out.println(STRING_GAME_RESTART);
        String input = Console.readLine();
        if (input.equals(INPUT_RESTART_NUMBER)) {
            isPlaying = true;
            gamePlay();
        } else if (input.equals(INPUT_EXIT_NUMBER)) {
            isPlaying = false;
            System.out.println(STRING_GAME_EXIT);
        } else {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}