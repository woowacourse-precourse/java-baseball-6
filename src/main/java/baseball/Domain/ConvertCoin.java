package baseball.Domain;

import baseball.Domain.Validation.OtherInteger;

import static baseball.Domain.ConvertErrorMessage.NOT_INTEGER;
import static java.lang.Integer.parseInt;

public class ConvertCoin {
    public Boolean convertCoin(String coin) {
        try{
            return reGame(parseInt(coin));
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }

    private Boolean reGame(int coin) {
        OtherInteger otherInteger = new OtherInteger();
        otherInteger.isOneOrTwo(coin);
        return coin == 1;
    }
}
