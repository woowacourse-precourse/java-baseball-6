package baseball.model;

import baseball.ConstantVO;
import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    public List<Integer> playerNumber(String inputNum) throws IllegalArgumentException {
        List<Integer> playerNum = new ArrayList<>();

        checkSize(inputNum);
 
        for (String number : inputNum.split("")) {
            if (playerNum.contains(Integer.parseInt(number))) {
                throw new IllegalArgumentException();
            }
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }

    private void checkSize(String input) throws IllegalArgumentException {
        if (input.length() != ConstantVO.SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
