package baseball;

import static baseball.BaseballGame.playGame;
import static baseball.BaseballGame.reset;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean play = true;
        while(play){
            playGame();
            play = reset();
        }
    }
}
