package baseball;

import static baseball.constants.*;

import java.util.List;

public class GameStart {
    private final baseballGame baseballGame = new baseballGame();

    private List<Integer> randomNumber;

    public GameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static class Result {
        int ballCount;
        int strikeCount;

        public Result(int ballCount, int strikeCount) {
            this.ballCount = ballCount;
            this.strikeCount = strikeCount;
        }
    }

    public void start() {
        int gameControlNum = RESTART_NUMBER;
        randomNumber = baseballGame.getRandomNumber();

        while (gameControlNum == RESTART_NUMBER) {
            String userInput = baseballGame.getInputNumber();
            List<Integer> userInputNumber = baseballGame.validateInputNumber(userInput);
            System.out.println("숫자를 입력해주세요: " + userInput);

            Result result = calculateNumber(randomNumber, userInputNumber);
            int ball = result.ballCount;
            int strike = result.strikeCount;
            baseballGame.getPrintResult(ball, strike);

            gameControlNum = checkStrikeCount(strike);
        }
    }

    private Result calculateNumber(List<Integer> randomNumber, List<Integer> userInputNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int randomNum = randomNumber.get(i);
            int userInputNum = userInputNumber.get(i);

            if (randomNum == userInputNum) {
                strike++;
                continue;
            }

            if (randomNumber.contains(userInputNum)) {
                ball++;
            }
        }

        return new Result(ball, strike);
    }


    private int checkStrikeCount(int strike) {
        int gameControlNumber= RESTART_NUMBER;

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 " + RESTART_NUMBER + ", 종료하려면 " + END_NUMBER + "를 입력하세요.");
            gameControlNumber = Integer.parseInt(baseballGame.getInputNumber());
            System.out.println(gameControlNumber);
            if (gameControlNumber < RESTART_NUMBER || gameControlNumber > END_NUMBER) {
                throw new IllegalArgumentException("게임을 새로 시작하려면 " + RESTART_NUMBER + ", 게임을 종료하려면 " + END_NUMBER + "를 입력하세요.");
            }

            getRestartGame(gameControlNumber);
        }

        return gameControlNumber;
    }

    private void getRestartGame(int gameControlNumber) {
        if (gameControlNumber == RESTART_NUMBER) {
            randomNumber = baseballGame.getRandomNumber();
        }
    }
}
