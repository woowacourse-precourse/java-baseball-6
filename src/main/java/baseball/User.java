package baseball;

import baseball.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> numberList = new ArrayList<>();
    private Validator validator = new Validator();

    /**
     *
     * @throws IllegalArgumentException
     */
    public List<Integer> init(String input) {
        numberList.clear();
        validator.userInput(input);

        for(int i = 0; i < 3; i++){
            int intValue = input.charAt(i) - '0';
            numberList.add(Integer.valueOf(intValue));
        }

        return numberList;
    }
}
