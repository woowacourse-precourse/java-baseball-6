package baseball.view;

import baseball.validate.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    InvalidInputException numberInvalidInputException = new InvalidInputException();

    public List<Integer> playerNumberInput() {
        List<Integer> playernum = new ArrayList<>();
        String snum = Console.readLine();

        numberInvalidInputException.checkInputForGame(snum); // 숫자 검증

        for (String s : snum.split("")) {
            playernum.add(Integer.parseInt(s));
        }

        return playernum;
    }

    public int endOrRestartInput() {
        String inputNum = Console.readLine();

        numberInvalidInputException.checkRestartChoice(inputNum); // 숫자 검증

        return Integer.parseInt(inputNum);
    }

}
