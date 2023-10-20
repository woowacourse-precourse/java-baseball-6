package baseball;

public class GameManager {

    public void run() {

        doGameAndGetGameResult();

        if (InputUtils.askReplayGame()) {
            run();
        }

    }

    private void doGameAndGetGameResult() {

        printGameStartMessage();

        doGame(new Computer());
    }

    private void doGame(Computer computer) {

        while (true) {

            int userInput = InputUtils.userInputReceive();

            printGameResult(computer, userInput);

            if (computer.isPlayerWin(userInput)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private void printGameResult(Computer computer, int userInput) {

        if (computer.isNothing(userInput)) {
            System.out.println("낫싱");
            return;
        }

        int ballCount = computer.getBallCount(userInput);
        int strikeCount = computer.getStrikeCount(userInput);

        printBallResult(ballCount, strikeCount);
        printStrikeCount(strikeCount);
        System.out.println();
    }

    private void printStrikeCount(int strikeCount) {

        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }
    }

    private void printBallResult(int ballCount, int strikeCount) {

        if (ballCount != 0) {
            if (strikeCount != 0) {
                System.out.print(ballCount + "볼 ");
                return;
            }
            System.out.print(ballCount + "볼");
        }
    }

    private void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
