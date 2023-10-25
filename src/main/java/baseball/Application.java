package baseball;

import baseball.game.BaseballGame;

public class Application {
    public static void main(String[] args) {
        try{
            BaseballGame.play();
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}
