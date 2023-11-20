package baseball.Domain.Validation;

import static baseball.Domain.ConvertErrorMessage.NOT_3_INTEGER;

public class ThreeInteger {
    public void isThreeInteger(int enterNumbers) {
        if(enterNumbers / 100 <= 0 || enterNumbers / 100 > 9){
            throw new IllegalArgumentException(NOT_3_INTEGER.getMessage());
        }
    }
}
