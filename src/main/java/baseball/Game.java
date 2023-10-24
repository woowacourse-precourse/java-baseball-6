package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final int CNT_NUMBER = 3;
    private static final int STRIKE_CODE = 2;
    private static final int BALL_CODE = 1;
    private static final String BALL_STR = "볼 ";
    private static final String STRIKE_STR = "스트라이크";
    private static final String NOTHING = "낫싱";

    private static final String EXIT_CODE = "2";
    private static final String ALL_STRIKE_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String EXIT_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String START_GAME_SENTENCE = "숫자 야구 게임을 시작합니다.";

    private int[] player;
    private int[] computer;
    private boolean exit = false;

    private int strike = 0;
    private int ball = 0;

    public Game() {
    }

    public void startGame() {
        System.out.println(START_GAME_SENTENCE);

        Number playerNumber = new Number();
        Number computerNumber = new Number();
        computerNumber.setRandomNumber();
        computer = computerNumber.getDigits();

        while (!exit) {
            playerNumber.inputAnswer();
            player = playerNumber.getDigits();

            resetScore();
            calculateScore();
            printResult();

            if (strike == CNT_NUMBER) {
                readyToExit(computerNumber);
            }
        }
    }

    private void calculateScore() {
        for (int i = 0; i < CNT_NUMBER; i++) {
            int score = isStrikeOrBall(player[i], i);

            if (score == STRIKE_CODE) {
                strike++;
            }
            else if (score == BALL_CODE) {
                ball++;
            } else if (score == 2) {
                continue;
            }

        }
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void readyToExit(Number computerNumber) {
        String input = inputExit();
        if (EXIT_CODE.equals(input)) {
            exit = true;
        } else {
            System.out.println(START_GAME_SENTENCE);
            computerNumber.setRandomNumber();
            computer = computerNumber.getDigits();
        }
    }

    private String inputExit() {
        System.out.println(EXIT_SENTENCE);
        String input = Console.readLine();
        if (!isRightAnswer(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private boolean isRightAnswer(String input) {
        return "1".equals(input) || EXIT_CODE.equals(input);
    }

    private int isStrikeOrBall(int num, int index) {
        for (int i = 0; i < CNT_NUMBER; i++) {
            if (computer[i] == num) {
                if (i == index) {
                    return STRIKE_CODE;
                } else {
                    return BALL_CODE;
                }
            }
        }
        return -1;
    }

    private void printResult() {
        System.out.println(getResultString());
        if (strike == CNT_NUMBER) {
            System.out.println(ALL_STRIKE_SENTENCE);
        }
    }

    private String getResultString() {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append(BALL_STR);
        }
        if (strike > 0) {
            sb.append(strike).append(STRIKE_STR);
        }
        return sb.toString();
    }
}
