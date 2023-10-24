package baseball;

public class Application {
    public static void main(String[] args) {
        RandomNumbers randomNumbers = new RandomNumbers();
        BaseballGame baseballGame = new BaseballGame(randomNumbers);
        baseballGame.run();

    }
}

