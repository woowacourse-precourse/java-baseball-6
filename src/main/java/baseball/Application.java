package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGameConsole baseballGameConsole = new BaseballGameConsole(new Game(new RandomAnswerFactory(), new ResultFactory()), new InputConsole(), new OutputConsole());
        baseballGameConsole.start();
    }
}
