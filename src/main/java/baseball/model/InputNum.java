package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class InputNum {
    private static final int Input_Lenght = 3;
    private static final String Input_Content= "^[1-9]+$";
    private List<Integer> inputArr;
    public InputNum() {
        this.inputArr = new ArrayList<>();
    }

    public List<Integer> convertInputToArr(String InputNum) {
        if (!isValidInput(InputNum)) {
            throw new IllegalArgumentException();
        }
        for (char digit : InputNum.toCharArray()) {
            inputArr.add(Character.getNumericValue(digit));
        }
        System.out.println(inputArr);
        return inputArr;
    }

    public boolean isValidInput(String InputNum) {
        return InputNum.length() == Input_Lenght && InputNum.matches(Input_Content);
    }

}
