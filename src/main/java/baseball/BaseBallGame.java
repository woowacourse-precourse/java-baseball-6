package baseball;

public class BaseBallGame {

    private final GameInput input;
    private final GameService service;

    public BaseBallGame() {
        input = new GameInput();
        service = new GameService();
    }

    public void startGameProcess() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean reGame = true; // start Game
        while (reGame) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            reGame = input.userInputReGameSelection();
        }
    }

    private void playGame() {
        boolean gameProcess = true;
        UserGuessNumber userGuessNumber = null;
        RandomNumber randomNumber = new RandomNumber();

        while (gameProcess) {
            System.out.printf("숫자를 입력해주세요 : ");
            int[] ballAndStrike = guessNumber(userGuessNumber, randomNumber);
            printResult(ballAndStrike);
            if (ballAndStrike[1] == 3) {
                gameProcess = false;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private int[] guessNumber(UserGuessNumber userGuessNumber, RandomNumber randomNumber) {
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
