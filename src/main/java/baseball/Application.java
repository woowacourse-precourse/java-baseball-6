package baseball;

public class Application {
    GameController gameController = new GameController();

    /**
     * 게임을 최초 실행하는 메소드
     */
    void boot() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameController.startGame();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.boot();
    }
}
