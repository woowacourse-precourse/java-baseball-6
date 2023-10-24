package baseball;

import java.security.PublicKey;
import java.util.List;

public class Player {
    private List<Integer> Numbers;

    public void setNumbers(List<Integer> Number) {
        this.Numbers = Number;
    }
    public List<Integer> getNumbers() {
        return Numbers;
    }
}
