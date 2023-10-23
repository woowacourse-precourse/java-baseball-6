package baseball.model;

import java.util.List;

public class UserModel {
    private final List<Integer> splitDigitsFromUserInput;

    public UserModel(List<Integer> splitDigitsFromUserInput) {
        this.splitDigitsFromUserInput = splitDigitsFromUserInput;
    }


    public List<Integer> getSplitDigitsFromUserInput() {
        return splitDigitsFromUserInput;
    }

}
