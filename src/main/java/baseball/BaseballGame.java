package baseball;

public class BaseballGame {
    Boolean isDone;
    Computer computer;
    private static final int GAME_END_STRIKE_COUNT = 3;

    public BaseballGame() {
        isDone = false;
        this.computer = new Computer();
    }

    // 게임 시작
    public void start() throws IllegalArgumentException {
        // 시작 문구 출력
        Display.printStartMessage();

        run();
        while (isRestart()) {
            run();
        }
    }

    private void run() throws IllegalArgumentException {
        computer.drawBall();
        while (!isDone) {
            String userInputBall = Display.requestUserBall();
            Validator.validateUserInputBall(userInputBall);
            Ball userBall = new Ball(userInputBall);
            MatchResult result = computer.matchBall(userBall);
            Display.printMatchResult(result);
            checkGameOver(result);
        }
        Display.printGameOver();
    }

    // 게임 종료 후 재시작 묻기
    public boolean isRestart() {
        //todo: 사용자에게 재시작 여부 묻고 재시작일 경우 true
        return false;
    }

    private void checkGameOver(MatchResult result) {
        if (result.strikeCount == GAME_END_STRIKE_COUNT) {
            isDone = true;
        }
    }
}
