package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class UserInput {

    public UserInput(){}

    public int getInput(){
        String inputs = Console.readLine();
        if (isValidInput(inputs)) {
            return Integer.parseInt(inputs);
        }
        return -1;
    }

    public boolean isValidInput(String inputs){
        return (inputs.length() == 3) && (isValidDigit(inputs));
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
        return set.size() == 3;
    }
}
