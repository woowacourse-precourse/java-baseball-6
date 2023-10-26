package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public List<Integer> getGameInput() {
        String input = Console.readLine();
        if (!checkGameInputValid(input)) {
            throw new IllegalArgumentException();
        }
        if (!checkGameInputNoDuplication(input)) {
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

    private Boolean checkGameInputValid(String input) {
        return input.length() == Constants.gameInputLength && input.matches("^[1-9]+$");
    }

    private Boolean checkGameInputNoDuplication(String input) {
        return input.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size() == input.length();
    }

    private Boolean checkRestartInputValid(String input) {
        return input.equals(Constants.gameRestartState) || input.equals(Constants.gameEndState);
    }

    private List<Integer> changeStringInputToList(String input) {
        List<Integer> result = new ArrayList<>();
        for (char num : input.toCharArray()) {
            result.add(Character.getNumericValue(num));
        }
        return result;
    }

}
