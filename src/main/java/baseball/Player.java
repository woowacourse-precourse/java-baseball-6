package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Integer> getGameInput() {
        String input = Console.readLine();
        if (!checkGameInputValid(input)) {
            throw new IllegalArgumentException();
        }
        return changeStringInputToList(input);
    }

    public String getRestartInput() {
        String input = Console.readLine();
        if (!checkRestartInputValid(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public Boolean checkGameInputValid(String input) {
        return input.length() == Constants.gameInputLength && input.matches("^[1-9]+$");
    }

    public Boolean checkRestartInputValid(String input) {
        return input.equals(Constants.gameRestartState) || input.equals(Constants.gameEndState);
    }

    public List<Integer> changeStringInputToList(String input) {
        List<Integer> result = new ArrayList<>();
        for (char num : input.toCharArray()) {
            result.add(Character.getNumericValue(num));
        }
        return result;
    }

}
