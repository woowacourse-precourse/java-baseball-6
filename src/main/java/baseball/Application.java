package baseball;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Prompt prompt = new Prompt();
        Validator validator = new Validator();
        BaseBallGameMapper baseBallGameMapper = new BaseBallGameMapper();

        BaseBallGame game = new BaseBallGame(randomNumberGenerator, prompt, validator, baseBallGameMapper);
        game.start();
    }
}
