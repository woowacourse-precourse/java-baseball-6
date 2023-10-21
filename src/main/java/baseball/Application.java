package baseball;

public class Application {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.startGame();    // 게임 시작

    }
}
