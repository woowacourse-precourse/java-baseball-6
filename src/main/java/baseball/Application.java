package baseball;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        BaseballGame baseballGame = new BaseballGame(input, output);
        baseballGame.playBaseball();
    }
}
