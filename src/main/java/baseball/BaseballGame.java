package baseball;

public class BaseballGame {
    Boolean isDone;
    Boolean firstStart;

    public BaseballGame() {
        isDone = false;
        firstStart = true;
    }

    // 게임 시작
    public void start() {
        // 시작 문구 출력
        isDone = false;
    }

    // 게임 종료 후 재시작 묻기
    public void askRestart() {

    }
}
