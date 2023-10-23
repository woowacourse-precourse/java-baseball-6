package baseball;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        // 게임 종료를 원하지 않늗다면 게임 재시작
        while(!game.getTerminate()) game.playGame();
    }
}
