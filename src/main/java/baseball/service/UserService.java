package baseball.service;

import baseball.util.validation.InputNumbersValidation;
import java.util.ArrayList;

public class UserService {

    public ArrayList<Integer> getInputNumbers(String input) {
        return generateInputNumbers(input);
    }

    private static ArrayList<Integer> generateInputNumbers(String input) {
        ArrayList<Integer> inputNumber = new ArrayList<>();
        String[] splitInput = input.split("");
        for (String s : splitInput) {
            inputNumber.add(Integer.parseInt(s));
        }
        InputNumbersValidation.validateAll(inputNumber);

        return inputNumber;
    }
}
