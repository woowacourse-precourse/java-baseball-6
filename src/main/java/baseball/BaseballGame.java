package baseball;

public class BaseballGame {
    private int[] computerNumber;

    public BaseballGame() {
        computerNumber = ComputerPlayer.generateRandomNumber();
    }

    public void playGame() {
        UserInputValidator inputValidator = new UserInputValidator();
        int[] userGuess;
        int attempts = 0;

        do {
            attempts++;
            userGuess = inputValidator.getUserInput();
            GameResult result = calculateGameResult(userGuess);
            System.out.println(result.toString());
        } while (!isGameWon(userGuess));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 (시도 횟수: " + attempts + ")");
    }

    private GameResult calculateGameResult(int[] userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (userGuess[i] == computerNumber[i]) {
                strikes++;
            } else if (containsNumber(computerNumber, userGuess[i])) {
                balls++;
            }
        }

        return new GameResult(strikes, balls);
    }

    private boolean isGameWon(int[] userGuess) {
        return calculateGameResult(userGuess).isGameWon();
    }

    private boolean containsNumber(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }
}
