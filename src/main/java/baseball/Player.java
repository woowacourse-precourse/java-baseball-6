package baseball;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> Numbers;

    public Player()
    {
        Numbers = new ArrayList<>();
    }
    public void setNumbers(List<Integer> Number) {
        this.Numbers = Number;
    }
    public List<Integer> getNumbers() {
        return Numbers;
    }
}
