package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<Integer> getInputNumbers(String input) {
        return generateInputNumbers(input);
    }

    private static List<Integer> generateInputNumbers(String input) {
        List<Integer> inputNumber = new ArrayList<>();
        String[] splitInput = input.split("");
        for (String s : splitInput) {
            inputNumber.add(Integer.parseInt(s));
        }
        return inputNumber;
    }
}
