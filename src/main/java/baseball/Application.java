package baseball;

import java.util.List;

public class Application {

    private static final int NUMBER_SIZE = 3;

    public static void main(String[] args) {
        Output.gameStartMessage();

        boolean gameOn = true;
        while (gameOn) {
            List<Integer> randomNumber = Input.getRandomNumber(NUMBER_SIZE);
            loopGame(randomNumber);
            gameOn = Input.restartOrNot();
        }
    }

    private static void loopGame(List<Integer> randomNumber) {
        while (true) {
            List<Integer> userNumber = Input.inputUserNumber(NUMBER_SIZE);

            int strike = strike(randomNumber, userNumber);
            int ball = ball(randomNumber, userNumber);

            Output.printScore(strike, ball);

            if (strike == NUMBER_SIZE) {
                Output.gameEndMessage();
                return;
            }
        }
    }

    private static int strike(List<Integer> randomNumber, List<Integer> userNumber) {
        int strike = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (randomNumber.get(i).equals(userNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private static int ball(List<Integer> randomNumber, List<Integer> userNumber) {
        int ball = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (randomNumber.contains(userNumber.get(i)) && !randomNumber.get(i).equals(userNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
