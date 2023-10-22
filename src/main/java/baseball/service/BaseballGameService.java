package baseball.service;

import baseball.model.BaseballGameResult;
import baseball.model.ComputerNumber;
import baseball.model.UserNumber;

import java.util.List;

public class BaseballGameService {

    private List<Integer> computerNumber;

    public void setComputerNumber() {
        this.computerNumber = new ComputerNumber().getNumber();
    }

    public BaseballGameResult getGameResult(String input) {
        List<Integer> userNumber = new UserNumber(input).getNumber();
        return new BaseballGameResult(userNumber, computerNumber);
    }

    public boolean wantRestart(String input) {
        if (input.equals("1")) return true;
        if (input.equals("2")) return false;
        throw new IllegalArgumentException();
    }


}
