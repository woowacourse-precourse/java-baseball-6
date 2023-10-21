package baseball;

public class BaseballGame {
    Boolean isDone;

    public BaseballGame() {
        isDone = false;
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
        while (!isDone) {
            Ball userBall = new Ball(Display.requestUserBall());
            Validator.validateBall(userBall);

            // todo: 컴퓨터 랜덤 볼 선택
            // todo: 사용자 입력
            // todo: 정답 여부
        }
    }

    // 게임 종료 후 재시작 묻기
    public boolean isRestart() {
        //todo: 사용자에게 재시작 여부 묻고 재시작일 경우 true
        return false;
    }
}
