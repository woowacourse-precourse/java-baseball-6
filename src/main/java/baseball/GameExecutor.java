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
            if (!game.shouldRetry(in, out)) {
                break;
            }
            game = BaseballGame.of(random.sampleDistinctNumbers(1, 9, 3));
        }
    }
}
