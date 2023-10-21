package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Player {
    private static final Integer USER_NUMBER_SIZE = 3;
    private final List<Integer> userNumberList;

    public Player(List<Integer> userNumberList) {
        this.userNumberList = userNumberList;
    }

    public List<Integer> loadListOf3Number() {
        return userNumberList;
    }

    public int input3Number() {
        return Integer.parseInt(readLine());
    }

}
