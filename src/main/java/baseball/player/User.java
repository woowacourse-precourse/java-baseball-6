package baseball.player;

import java.util.List;

public class User extends BasePlayer {
    @Override
    public void setNumbers(List<Integer> numbers){
        this.numbers = numbers;
    }
}
