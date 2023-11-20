package baseball.Domain.Validation;

import static baseball.Domain.ConvertErrorMessage.NOT_1_OR_2;

public class OtherInteger {
    public void isOneOrTwo(int coin) {
        if(coin != 1 && coin != 2){
            throw new IllegalArgumentException(NOT_1_OR_2.getMessage());
        }
    }
}
