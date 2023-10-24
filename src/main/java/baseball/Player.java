package baseball;

import java.util.List;

public class Player {

    private final List<Integer> number;

    private Player(List<Integer> number) {
        this.number = number;
    }

    public static Player getInstanceByNumber(List<Integer> number) {
        return new Player(number);
    }

}
