package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final static String START_ANNOUNCEMENT = "숫자 야구 게임을 시작합니다.";
    private final static String GAME_ANNOUNCEMENT = "숫자를 입력해주세요: ";
    private final static String NEWGAME_ANNOUNCEMENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static int strike;
    private static int ball;

    private static int[] computerAnswer;

    private static int[] playerAnswer;
    private static Answer answer = new Answer();

    private static boolean isGameInProgress;

    public Game() {
    }

    public void init() {

        playerAnswer = new int[3];
        isGameInProgress = true;
        strike = 0;
        ball = 0;
        System.out.println(START_ANNOUNCEMENT);

        while (isGameInProgress) {
            System.out.print(GAME_ANNOUNCEMENT);
            String input = Console.readLine();
            int num = convertStringToInteger(input);
            calculateScore(num);
            getGameResult();
            checkWin();
            resetBallAndStrikeCnt();

            if (!isGameInProgress) {
                newGameTry();
            }

        }

    }

    public void calculateScore(int num) {

        playerAnswer[0] = num / 100;
        playerAnswer[1] = (num / 10) % 10;
        playerAnswer[2] = num % 10;

        for (int i = 0; i < 3; i++) {
            if (playerAnswer[i] == computerAnswer[i]) {
                strike++;
            }
            if (playerAnswer[i] == computerAnswer[(i + 1) % 3]) {
                ball++;
            }
            if (playerAnswer[i] == computerAnswer[(i + 2) % 3]) {
                ball++;
            }
        }

    }

    public int convertStringToInteger(String answer) {
        int num;
        try {
            num = Integer.parseInt(answer);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (!checkValidNumber(num)) {
            throw new IllegalArgumentException();
        }

        return num;
    }

    public boolean checkValidNumber(int num) {

        if (num < 111 || 999 < num) {
            return false;
        }

        int secondDigit = (num / 10) % 10;
        int thirdDigit = num % 10;

        return secondDigit != 0 && thirdDigit != 0;

    }

    public void checkWin() {
        if (strike == 3) {
            isGameInProgress = false;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public void getGameResult() {

        String result;

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ball == 0) {
            result = "%s스트라이크";
            System.out.println(String.format(result, strike));
            return;
        }

        if (strike == 0) {
            result = "%s볼";
            System.out.println(String.format(result, ball));
            return;
        }

        result = "%s볼 %s스트라이크";
        System.out.println(String.format(result, ball, strike));

    }

    public void resetBallAndStrikeCnt() {
        ball = 0;
        strike = 0;
    }

    public void newGameTry() {
        System.out.println(NEWGAME_ANNOUNCEMENT);
        String answer = Console.readLine();
        int num;
        try {
            num = Integer.parseInt(answer);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (num == 1) {
            isGameInProgress = true;
            return;
        }

        if (num == 2) {
            return;
        }

        throw new IllegalArgumentException();

    }

    public void setComputerAnswer(int num) {
        computerAnswer = answer.generateAnswer(num);
    }

    public void generateRandomComputerAnser() {
        computerAnswer = answer.generateAnswer();
    }

    // 테스트를 위한 get, set 매소드
    public static int getStrike() {
        return strike;
    }

    public static int getBall() {
        return ball;
    }

    public static void setStrike(int strike) {
        Game.strike = strike;
    }

    public static void setBall(int ball) {
        Game.ball = ball;
    }

    public static void setPlayerAnswer(int[] playerAnswer) {
        Game.playerAnswer = playerAnswer;
    }

    public static int[] getComputerAnswer() {
        return computerAnswer;
    }
}
