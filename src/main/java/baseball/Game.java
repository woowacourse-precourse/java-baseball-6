package baseball;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String BALL_STR = "볼";
    private static final String STRIKE_STR = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final int CNT_NUMBER = 3;

    private int[] player;
    private int[] computer;
    private boolean exit = false;

    private int strike = 0;
    private int ball = 0;

    public Game() {}

    public void startGame() {
        Number computerNumber = new Number();
        computerNumber.setRandomNumber();
        computer = computerNumber.getDigits();
        Number playerNumber = new Number();

        do {
            playerNumber.inputAnswer();
            player = playerNumber.getDigits();

            resetScore();
            calculateScore();
            printResult();

            if(strike == 3) {
                inputExit();
                computerNumber.setRandomNumber();
                computer = computerNumber.getDigits();
            }
        } while(!exit);
    }

    private void calculateScore() {
        for(int i=0;i<CNT_NUMBER;i++) {
            int score = isStrikeOrBall(player[i], i);
            if (score == 1) {
                ball++;
            } else if (score == 2) {
                strike++;
            }
        }
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void inputExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(!isRightAnswer(input)) {
            throw new IllegalArgumentException();
        }
        if("2".equals(input)) {
            exit = true;
        }
    }

    private boolean isRightAnswer(String input) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(input).matches();
    }

    private int isStrikeOrBall(int num, int index) {
        for (int i = 0; i < CNT_NUMBER; i++) {
            if (computer[i] == num && i == index) {
                return 2;
            }
            if (computer[i] == num) {
                return 1;
            }
        }
        return -1;
    }

    private void printResult() {
        System.out.println(getResultString());
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private String getResultString() {
        if(strike == 0 && ball == 0) {
            return NOTHING;
        }

        StringBuilder sb = new StringBuilder();
        if(ball > 0) {
            sb.append(ball).append(BALL_STR);
        }
        if(strike > 0) {
            sb.append(strike).append(STRIKE_STR);
        }
        return sb.toString();
    }
}