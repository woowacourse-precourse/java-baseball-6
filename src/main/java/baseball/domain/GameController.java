package baseball.domain;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class GameController {
    public static final int NUMBER_LENGTH = 3;

    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";

    public static void printGameStartNotice() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static int setValueZero() {
        int value = 0;
        return value;
    }

    public static int checkForStrike(ArrayList<Integer> userNumArray, ArrayList<Integer> computerNumArray, int strike) {
        for (int i = 0; i < userNumArray.size(); i++) {
            if (userNumArray.get(i) == computerNumArray.get(i)) {
                userNumArray.set(i, 0);
                strike++;
            }
        }
        return strike;
    }

    public static int checkForBall(ArrayList<Integer> userNumArray, ArrayList<Integer> computerNumArray, int ball) {
        for (int i : userNumArray) {
            if (computerNumArray.contains(i)) {
                ball++;
            }
        }
        return ball;
    }

    public static String addBallToOutput(String output, int ball) {
        if (ball > 0) {
            output += String.format("%d%s", ball, BALL);
        }
        return output;
    }

    public static String addStrikeToOutput(String output, int strike, int ball) {
        if (strike > 0) {
            if (ball > 0) {
                output += " ";
            }
            output += String.format("%d%s", strike, STRIKE);
        }
        return output;
    }

    public String addNothingToOutput(String output, int strike, int ball) {
        if ((ball == 0) && (strike == 0)) {
            output += String.format("%s", NOTHING);
        }
        return output;
    }

    public void printOutput(String output) {
        System.out.println(output);
    }

    public void printGameSuccess() {
        System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", NUMBER_LENGTH));
    }

    public void printNewGameNotice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public Integer inputIsNewGame() {
        Integer exit = Integer.parseInt(Console.readLine());
        return exit;
    }
}