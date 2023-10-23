package baseball.service;

import java.util.ArrayList;
import java.util.List;

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
        return inputNumber;
    }
}
