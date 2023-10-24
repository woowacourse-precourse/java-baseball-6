package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputNum {
    private static final int Input_Lenght = 3;
    private static final String Input_Content= "^[1-9]+$";
    private List<Integer> inputArr;
    public InputNum() {
        this.inputArr = new ArrayList<>();
    }

    public List<Integer> convertInputToArr(String InputNum) {
        this.inputArr = new ArrayList<>();
        if (!isValidInput(InputNum)) {
            throw new IllegalArgumentException();
        }
        for (char digit : InputNum.toCharArray()) {
            inputArr.add(Character.getNumericValue(digit));
        }
        return inputArr;
    }

    public boolean isValidInput(String InputNum) {
        HashSet<Object> InputDouble = new HashSet<>();
        for (char digit : InputNum.toCharArray()){
            InputDouble.add(digit);
        }
        if (InputDouble.size() < 3){
            throw new IllegalArgumentException();
        }
        return InputNum.length() == Input_Lenght && InputNum.matches(Input_Content);
    }

}
