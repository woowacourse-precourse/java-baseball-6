package baseball.Domain;

import baseball.Domain.Validation.ThreeInteger;
import baseball.Dto.UserNumbers;

import java.util.List;

import static baseball.Domain.ConvertErrorMessage.NOT_INTEGER;
import static java.lang.Integer.parseInt;

public class ConvertNumber {
    public int convertNumber(String enterNumber) {
        try{
            return parseInt(enterNumber);
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }

    public void userNumbers(int enterNumbers) {
        validateNumbers(enterNumbers);
        String numberStr = String.valueOf(enterNumbers);

        List<Integer> enterUserNumbers = numberStr.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();

        saveUserNumbers(enterUserNumbers);
    }

    private void validateNumbers(int enterNumbers) {
        ThreeInteger threeInteger = new ThreeInteger();
        threeInteger.isThreeInteger(enterNumbers);
    }

    private void saveUserNumbers(List<Integer> enterUserNumbers) {
        UserNumbers userNumbers = UserNumbers.getInstance();
        userNumbers.createUserNumbers(enterUserNumbers);
    }
}
