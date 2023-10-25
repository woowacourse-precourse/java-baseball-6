package baseball.player;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePlayer {

    protected List<Integer> numbers = new ArrayList<>();

    public void emptyList(){
        numbers.clear();
    }

    // list getter
    public List<Integer> getNumbers() {
        return numbers;
    }

    // list setter
    public abstract void setNumbers(List<Integer> numbers);

}
