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
            throw new IllegalArgumentException("입력한 숫자는 3자리여야 합니다.");
        }
    }

    public void validateIsCharacter(int userChoiceNumber) {
        if (userChoiceNumber > 10 || userChoiceNumber < 0) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
    }
}
