package baseball;

import java.util.List;

public class Application {

    private static final int NUMBER_SIZE = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View.gameStartMessage();

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
            int strike = View.strike(randomNumber, userNumber);
            int ball = View.ball(randomNumber, userNumber);
            View.printScore(strike, ball);
            if(strike == NUMBER_SIZE){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }
}
