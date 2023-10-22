package baseball.utils;

public class Validation {
    public boolean validateIsNumberExist(int[] gameRandomNumber, int randomNumber) {
        for (int number : gameRandomNumber) {
            if (number == randomNumber) {
                return true;
            }
        }
        return false;
    }

    public void validateUserChoiceNumSize (String userChoiceNum) {
        if (userChoiceNum.length() != 3) {
            throw new IllegalArgumentException("옳지 못한 입력입니다");
        }
    }
}
