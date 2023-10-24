package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    String input;
    List<Integer> inputList;

    public User() throws IllegalArgumentException {

        try {
            this.input = Console.readLine();
            validateLength(this.input);
            validateCharacter(this.input);
            inputList = new ArrayList<Integer>();
            validateDuplication(this.input, this.inputList);
        } catch (IllegalArgumentException e) {
            throw e;
        }


    }

    private void validateLength(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCharacter(String input) throws IllegalArgumentException {
        for (int i = 0; i < 3; i++) {
            char character = input.charAt(i);
            if (!('1' <= character && character <= '9')) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplication(String input, List<Integer> inputList) throws IllegalArgumentException {
        for (int i = 0; i < 3; i++) {
            int number = (int) (input.charAt(i) - '0');
            if (inputList.contains(number)) {
                throw new IllegalArgumentException();
            }
            inputList.add(number);
        }
    }

}
