package baseball;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Prompt prompt = new Prompt();
        BaseBallGame game = new BaseBallGame(randomNumberGenerator, prompt);

        game.start();
    }
}
