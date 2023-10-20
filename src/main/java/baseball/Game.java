package baseball;

import java.util.List;
import java.util.Objects;

public class Game {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_FOR_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_FOR_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE_MASSAGE = "스트라이크";
    private static final String BALL_MASSAGE = "볼";
    private static final String NOTHING_MASSAGE = "낫싱";
    private static final int MAX_STRIKES = 3;

    private boolean isGameEnded = false;
    private int strike = 0;
    private int ball = 0;

    private Number number = new Number();

    public void startGame() {

        System.out.println(START_MESSAGE);

        List<Integer> computerNumber = number.generateRandomNumber();
        // log
        System.out.println("컴퓨터: " + computerNumber);

        while (!isGameEnded) {
            System.out.print(ASK_FOR_NUMBER_MESSAGE);
            List<Integer> playerNumber = number.inputNumber();
            // log
            System.out.println("플레이어: " + playerNumber);

            resetScore();
            calculateScore(computerNumber, playerNumber);
        }
    }

    private void endGame() {
        System.out.println(END_MESSAGE);
        askForRestart();
    }

    private void askForRestart() {
        System.out.println(ASK_FOR_RESTART_MESSAGE);
        String endInput = number.inputEndNumber();

        if (endInput.equals("1")) {
            restartGame();
            startGame();
        } else if (endInput.equals("2")) {
            System.out.println("게임 종료");
        }
    }

    private void calculateScore(List<Integer> computerNumber, List<Integer> playerNumber) {

        for (int i = 0; i < computerNumber.size(); i++) {
            if (Objects.equals(computerNumber.get(i), playerNumber.get(i))) {
                strike++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                ball++;
            }
        }

        displayScore();
    }

    private void displayScore() {

        if (strike == MAX_STRIKES) {
            System.out.println(strike + STRIKE_MASSAGE);
            isGameEnded = true;
            endGame();
        } else if (strike == 0 && ball == 0) {
            System.out.println(NOTHING_MASSAGE);
        } else {
            System.out.print(ball + BALL_MASSAGE + " ");
            System.out.println(strike + STRIKE_MASSAGE);
        }
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void restartGame() {
        isGameEnded = false;
    }

}
