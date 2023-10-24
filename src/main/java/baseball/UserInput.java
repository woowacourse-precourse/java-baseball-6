package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInput {
    private final int digits;

    public UserInput(int digits) {
        this.digits = digits;
    }

    public List<Integer> getInput() {
        String inputs = Console.readLine();
        if (isValidInput(inputs)) {
            List<String> inputListString = List.of(inputs.split(""));
            List<Integer> inputList = new ArrayList<>();
            for (int digit = 0; digit < digits; digit++) {
                inputList.add(Integer.parseInt(inputListString.get(digit)));
            }
            return inputList;
        }
        throw new IllegalArgumentException();
    }

    public boolean isValidInput(String inputs) {
        return (inputs.length() == digits) && (isValidDigit(inputs));
    }

    public boolean isValidDigit(String inputs) {
        Set<Integer> inputSet = new HashSet<>();
        for (int digit = 0; digit < inputs.length(); digit++) {
            int inputDigit = Character.getNumericValue(inputs.charAt(digit));
            if (inputDigit < 1 || inputDigit > 9) {
                return false;
            }
            inputSet.add(inputDigit);
        }
        return inputSet.size() == digits;
    }

    public String getRestart() {
        String restart = Console.readLine();
        if (isValidRestart(restart)) {
            return restart;
        }
        throw new IllegalArgumentException();
    }

    public boolean isValidRestart(String restart) {
        return restart.equals("1") || restart.equals("2");
    }
}
