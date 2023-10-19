package baseball;

public class BaseballGame {
    private boolean running = true;

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void run() {
        while (running) {
            System.out.println("It starts running.");
            exit();
        }
    }

    public void exit() {
        this.running = false;
        System.out.println("숫자 야구 게임을 종료합니다.");
    }
}
