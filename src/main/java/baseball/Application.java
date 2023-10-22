package baseball;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();

        do {
            new Output().print("숫자 야구 게임을 시작합니다.");
            game.start();
            new Output().print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } while (game.restart());
    }
}
