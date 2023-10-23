package baseball.model;

import baseball.controller.Validation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecimalNumber {

    private static List<Integer> computer;
    private static List<Integer> user;

    public List<Integer> getComputer() {
        return computer;
    }

    public void setComputer(List<Integer> computer) {
        DecimalNumber.computer = computer;
    }

    public void setUser(String input) {
        Validation.validationGameNumber(input);
        DecimalNumber.user = getStringToList(input);
    }

    private List<Integer> getStringToList(String input) {
        String[] strArr = input.split("");
        Integer[] intArr = new Integer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(intArr));

        return list;
    }
}
