package baseball.domain;

import baseball.validator.BaseballValidator;
import java.util.List;

public class User extends BaseballValidator {
    List<Integer> baseball;
    boolean playGame;

    public User(boolean playGame){
        this.playGame=playGame;
    }

    public void endGame() {
        this.playGame = false;
    }

    public void setBaseball(List<Integer> baseball) {
        if(validator(baseball)){
            this.baseball=baseball;
        }
    }

    public List<Integer> getBaseball() {
        return baseball;
    }

    public boolean retry() {
        return playGame;
    }
}
