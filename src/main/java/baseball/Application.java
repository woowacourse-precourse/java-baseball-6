package baseball;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        HintScore hintScore = new HintScore();
        BaseballGame baseballGame = new BaseballGame(computer, hintScore);
        baseballGame.run();
    }
}
