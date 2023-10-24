package baseball;

public class BaseballGame {
    Boolean isFinished;
    Boolean isRunning;
    Computer computer;
    private final int GAME_END_STRIKE_COUNT = 3;

    public BaseballGame() {
        isFinished = false;
        isRunning = false;
        this.computer = new Computer();
    }

    // 게임 시작
    public void start() throws IllegalArgumentException {
        Display.printStartMessage();
        while (!isFinished) {
            run();
        }
    }

    private void run() throws IllegalArgumentException {
        isRunning = true;
        computer.drawBall();
        //System.out.println(computer.ball.value);
        while (isRunning) {
            String userInputBall = Display.requestUserBall();
            Validator.validateUserInputBall(userInputBall);
            Ball userBall = new Ball(userInputBall);
            MatchResult result = computer.matchBall(userBall);
            Display.printMatchResult(result);
            checkRunningState(result);
        }
        Display.printGameOver();
        askToRestartGame();
    }

    private void askToRestartGame() throws IllegalArgumentException {
        String restartAnswer = Display.askToRestartGame();
        Validator.validateRestartInput(restartAnswer);
        checkTheFinishedGame(restartAnswer);
    }

    private void checkRunningState(MatchResult result) {
        if (result.strikeCount == GAME_END_STRIKE_COUNT) {
            isRunning = false;
        }
    }

    private void checkTheFinishedGame(String restartAnswer) {
        int answer = Integer.parseInt(restartAnswer);
        if (RestartType.EXIT.getValue() == answer) {
            isFinished = true;
        }
    }
}
