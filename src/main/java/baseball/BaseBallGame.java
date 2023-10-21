package baseball;

import java.util.List;

public class BaseBallGame {

    GameInput input;
    GameService service;
    boolean gameProcess;

    public BaseBallGame() {
        input = new GameInput();
        service = new GameService();
        gameProcess = true;
    }

    public void playGame() {
        List<Integer> userGuessNumber = null;
        List<Integer> randomNumber = null;
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomNumber = service.makeRandomNumberList();
        while (gameProcess) {
            int[] ballAndStrike = guessNumber(userGuessNumber, randomNumber);
            printResult(ballAndStrike);
            if (ballAndStrike[1] == 3) {
                gameProcess = false;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private int[] guessNumber(List<Integer> userGuessNumber, List<Integer> randomNumber) {
        userGuessNumber = input.userInputGuessNumber();
        int[] ballAndStrike = service.compareGuessToRandom(userGuessNumber, randomNumber);
        return ballAndStrike;
    }

    private void printResult(int[] ballAndStrike) {
        if (ballAndStrike[0] == 0 && ballAndStrike[1] == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ballAndStrike[0] > 0) {
            System.out.printf("%s ", ballAndStrike[0] + "볼");
        }
        if (ballAndStrike[1] > 0) {
            System.out.printf("%s", ballAndStrike[1] + "스트라이크");
        }
        System.out.println();
    }
}
