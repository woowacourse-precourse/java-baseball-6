package baseball.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final List<Integer> userInputList = new ArrayList<>();
    private static String inputStr;

    public List<Integer> inputNum() {
        inputStr = Console.readLine();
        for(int i = 0; i < inputStr.length(); i++) {
            validInput(inputStr.charAt(i) - '0');
        }

        return userInputList;
    }

    public void initPlayer() {
        userInputList.clear();
    }

    private void validInput(int iNum) {

        if((iNum < 1 || iNum > 9) || userInputList.contains(iNum) || inputStr.length() > 3) {
            throw new IllegalArgumentException();
        }

        userInputList.add(iNum);
    }
}
