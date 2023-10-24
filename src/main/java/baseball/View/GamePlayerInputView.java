package baseball.View;

import baseball.Exception.PlayerInputException;
import baseball.Exception.ReplayOrQuitGameException;
import baseball.Util.StringToArrayList;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GamePlayerInputView {
    private List<Integer> playerNumbers = new ArrayList<>();
    private PlayerInputException playerInputException = new PlayerInputException();
    private ReplayOrQuitGameException replayOrQuitGameException = new ReplayOrQuitGameException();

    public List<Integer> setPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numberCasesOfString = Console.readLine();
        playerInputException.checkValidOfPlayerInput(numberCasesOfString);
        playerNumbers = StringToArrayList.StringToArrayList(numberCasesOfString);
        return playerNumbers;
    }

    public int nextGameSetup() {
        String numberAfterGameEnd = Console.readLine();
        replayOrQuitGameException.selectReplayOrQuitGameException(numberAfterGameEnd);
        return Integer.parseInt(numberAfterGameEnd);
    }
}

