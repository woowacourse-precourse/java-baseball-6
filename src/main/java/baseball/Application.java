package baseball;

public class Application {

    public static void main(String[] args) {
        // 게임 매니저를 호출하여 게임 프로세스 시작
        GameManager gameManager = new BaseballGameManager();
        gameManager.startGameProcess();
    }
}
