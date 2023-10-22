package baseball.View;

import static baseball.Util.StringToArrayList.StringToArrayList;

import baseball.Exception.PlayerInputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class FirstGamePlayerInputView {
    private List<Integer> playerNumbers = new ArrayList<>();
    private PlayerInputException playerInputException = new PlayerInputException();

    public List<Integer> setPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numberCasesOfString = Console.readLine();
        playerInputException.checkValidOfPlayerInput(numberCasesOfString);
        playerNumbers = StringToArrayList(numberCasesOfString);
        return playerNumbers;
    }
}

