package baseball.model;

import baseball.constant.Rule;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNum;

    public Player() {}

    public List<Integer> inputPlayerNum() {
        playerNum = new ArrayList<>();
        String numData = Console.readLine();
        validateInput(numData);

        for(int i=0; i<numData.length(); i++) {
            playerNum.add(numData.charAt(i)-'0');
        }

        return playerNum;
    }

    public String inputRestartOrEnd() {
        String inputData = Console.readLine();
        checkRestartOrEnd(inputData);
        return inputData;
    }

    private void validateInput(String playerNum) {
        checkNaturalNum(playerNum);
        checkNumLength(playerNum);
        checkDuplicatedNum(playerNum);
    }

    private void checkNaturalNum(String playerNum) {
        if(!playerNum.matches("^[1-9]+$")) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumLength(String playerNum) {
        if(playerNum.length()> Rule.MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
    private void checkDuplicatedNum(String playerNum) {
        if (playerNum.length() != playerNum.chars().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRestartOrEnd(String restartOrEndNum) {
        if(!(restartOrEndNum.equals("1") || restartOrEndNum.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

}
