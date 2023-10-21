package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private static final List<Integer> splitDigitsFromUserInput = new ArrayList<>();
    public void initUserInputBySplitDigits(String stringUserInput) {
        splitDigitsFromUserInput.clear();

        for (int i = 0; i < stringUserInput.length(); i++) {
            int number = Character.getNumericValue(stringUserInput.charAt(i));
            if (!splitDigitsFromUserInput.contains(number)) {
                splitDigitsFromUserInput.add(number);
            }
        }
    }

    public List<Integer> getSplitDigitsFromUserInput(){
        return splitDigitsFromUserInput;
    }

}
