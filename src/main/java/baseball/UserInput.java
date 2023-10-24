package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInput {
    private final int digits;

    public UserInput(int digits){
        this.digits = digits;
    }

    public List<Integer> getInput(){
        String inputs = Console.readLine();
        if (isValidInput(inputs)) {
            List<String> input_list_string = List.of(inputs.split(""));
            List<Integer> input_list = new ArrayList<>();
            for (int i = 0; i < digits; i++){
                input_list.add(Integer.parseInt(input_list_string.get(i)));
            }
            return input_list;
        }
        throw new IllegalArgumentException();
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

    public String getRestart(){
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
