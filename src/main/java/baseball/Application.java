package baseball;

public class Application {
    public static void main(String[] args) {
        Game baseball = new BaseballGame(new ComputerOpponent());
        baseball.play();
    }

}
