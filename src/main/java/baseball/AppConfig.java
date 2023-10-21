package baseball;

public class AppConfig {
    public GameController gameController(){
        return new GameController(baseballGame());
    }

    public BaseballGame baseballGame() {
        return new BaseballGame(numberGenerator());
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
