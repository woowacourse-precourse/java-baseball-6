package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public List<Integer> getNumbers(){
        String input = Console.readLine();

        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            Integer number = Character.getNumericValue(input.charAt(i));
            numbers.add(number);
        }

        Exception.validateNumbers(numbers);
        return numbers;
    }

    public boolean continueGame(){
        String input = Console.readLine();

        Exception.validateOption(input);

        if(input.equals("1")){
            return true;
        }
        return false;
    }
}
