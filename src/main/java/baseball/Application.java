package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            GameController game =
                    new GameController(RandomTargetNumber.generate(), new InputAdapter(new Validator()));
            boolean repeat = game.gameLoop();
            if (!repeat) {
                break;
            }
        }
    }
}
