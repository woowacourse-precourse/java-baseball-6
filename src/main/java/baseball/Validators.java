package baseball;

import java.util.List;

public class Validators {
    private static final int ANSWER_LENGTH = 3;
    boolean isLengthValid;
//    public boolean validatePlayerInput() {
//
//    }

    private boolean validateLength(List<Integer> playerInput) {
        if (playerInput.size() == ANSWER_LENGTH) {
            isLengthValid = true;
        }
        return isLengthValid;
    }

//    private boolean validateRange() {
//
//    }
}
