package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = Game.startNewGame();
        System.out.println("숫자 야구 게임을 시작합니다.");
        game.gameLoop();
    }
}
