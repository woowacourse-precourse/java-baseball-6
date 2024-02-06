package baseball.service;

import baseball.model.BaseballGameResult;
import baseball.model.UserNumber;

import java.util.List;

public class BaseballGameService {

    public BaseballGameResult getGameResult(String input, List<Integer> computerNumber) {
        List<Integer> userNumber = new UserNumber(input).getNumber();
        return new BaseballGameResult(userNumber, computerNumber);
    }

    public boolean wantRestart(String input) {
        if (input.equals("1")) return true;
        if (input.equals("2")) return false;
        throw new IllegalArgumentException();
    }


}
