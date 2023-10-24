package baseball;

import java.util.regex.Pattern;

public class GameExecutor {
    private BaseballGame game;
    private GameInputInterface in;
    private GameOutputInterface out;
    private GameRandom random;

    public GameExecutor(BaseballGame game, GameInputInterface consoleInput,
                        GameOutputInterface consoleLogger,
                        GameRandom random) {
        this.random = random;
        this.game = game;
        this.in = consoleInput;
        this.out = consoleLogger;
    }


    public void run() {
        game.sayHello(out);
        while (true) {
            game.run(in, out);
            out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            String input = in.getInput();
            checkInput(input);
            if ("2".equals(input)) {
                break;
            }
            game = new BaseballGame(random.sampleDistinctNumbers(1, 9, 3));
        }
    }

    private void checkInput(String input) {
        if (Pattern.matches("[12]", input)) {
            return;
        }
        throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
    }
}
