package baseball;

public class Application {

    public static void main(String[] args) {
        Play play = new Play();
        play.startGame();
        play.runGame();
        play.restartOrFinishGame();
    }
}
