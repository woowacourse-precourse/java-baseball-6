package baseball;

public class Application {
    private final GameControl gameControl = new GameControl();
    private final GamePlay gamePlay = new GamePlay(gameControl);

    public static void main(String[] args) {
        Application app = new Application(); // Application 객체 생성
        app.run(); // Application 객체를 통해 run 메서드 실행
    }

    public void run() {
        do {
            gamePlay.start();
            gamePlay.process();
        } while (gameControl.isContinuing());
        System.out.println("게임 종료");
    }
}
