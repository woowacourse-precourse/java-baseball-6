package baseball;

import static baseball.PlayGame.START_MESSAGE;

public class Application {
    public static void main(String[] args) {
        PlayGame play = new PlayGame();
        System.out.println(START_MESSAGE);
        play.playBaseball();
    }
}
