package baseball;

import java.util.List;


public class Player {
    private static final Integer USER_NUMBER_SIZE = 3;
    private final List<Integer> userNumberList;
    public Player(List<Integer> userNumberList) {
        this.userNumberList = userNumberList;
    }
}
