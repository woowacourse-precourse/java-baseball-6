package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerNumber {
    private final String playerNumber;

    public PlayerNumber(String playerNumber) {
        isInteger(playerNumber);
        isLengthThree(playerNumber);
        isDifferentNum(playerNumber);
        this.playerNumber = playerNumber;

    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void isLengthThree(String number) throws IllegalArgumentException {
        if (number.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자가 아닙니다.");
        }
    }

    public void isInteger(String number) throws IllegalArgumentException {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다.");
            }
        }
    }

    public void isDifferentNum(String number) throws IllegalArgumentException {
        String[] strArr = number.split("");
        List<String> tmp = new ArrayList<>(Arrays.asList(strArr));
        if (tmp.size() != tmp.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
