package player;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseballPlayer {
    protected List<Integer> baseballNumber = new ArrayList<>();

    public abstract void inputBaseballNumber();
    public List<Integer> getBaseballNumber() {
        return this.baseballNumber;
    }
}
