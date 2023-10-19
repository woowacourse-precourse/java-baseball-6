package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class UserInput {
    private final int digits;

    public UserInput(int digits){
        this.digits = digits;
    }

    public int getInput(){
        String inputs = Console.readLine();
        if (isValidInput(inputs)) {
            return Integer.parseInt(inputs);
        }
        return -1;
    }

    public boolean isValidInput(String inputs){
        return (inputs.length() == digits) && (isValidDigit(inputs));
    }

    public boolean isValidDigit(String inputs){
        Set<Integer> set = new HashSet<>();
        for (int digit = 0; digit < inputs.length(); digit++){
            int InputDigit = Character.getNumericValue(inputs.charAt(digit));
            if (InputDigit < 1 || InputDigit > 9){
                return false;
            }
            set.add(InputDigit);
        }
        return set.size() == digits;
    }
}
