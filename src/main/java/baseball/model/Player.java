package baseball.model;

import baseball.utils.Util;
import baseball.validation.Validation;

import java.util.List;

public class Player {
    static final int NUMBER_OF_BALLS = 3;
    static final int MINIMUM_PLAYER_NUMBER = 1;
    static final int MAXIMUM_PLAYER_NUMBER = 9;
    private final List<Integer> playerIntegerList;

    public Player(String playerNumStr) {
        Validation.validateInteger(playerNumStr);
        playerIntegerList = Util.stringToIntegerList(playerNumStr);
        Validation.validateLength(playerIntegerList, NUMBER_OF_BALLS);
        Validation.validateRange(playerIntegerList, MINIMUM_PLAYER_NUMBER, MAXIMUM_PLAYER_NUMBER);
        Validation.validateUnique(playerIntegerList);
    }

    public List<Integer> getPlayerIntegerList() {
        return playerIntegerList;
    }
}
