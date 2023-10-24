package baseball;

import baseball.game.BaseballGame;

public class Application {
    public static void main(String[] args) {

        BaseballGame baseballGame = new BaseballGame();

        boolean isPlaying = true;
        while(isPlaying){
            baseballGame.run();
            isPlaying = baseballGame.askReplay();
        }

    }
}
