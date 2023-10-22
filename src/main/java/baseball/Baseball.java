package baseball;

import baseball.core.Core;
import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.NumberConstant.*;
import static baseball.constant.MessageConstant.*;

public class Baseball {
    private final Validator validator = new Validator();
    private final Core core = new Core();

    public void startBaseball() {
        List<Integer> computerNumber = getComputerNumber();
        //System.out.println(computerNumber);
        System.out.println(START_BASEBALL_MSG);
        boolean restartFlag = true;

        while(restartFlag) {
            System.out.print(PLEASE_INPUT_MSG);
            List<Integer> playerNumber = getPlayerNumber();
            int strikeCount = core.countStrike(computerNumber, playerNumber);
            int ballCount = core.countBall(computerNumber, playerNumber);
            core.printBaseballResult(strikeCount, ballCount);

            if(strikeCount == MAX_STRIKE) {
                System.out.println(END_BASEBALL_MSG);
                restartFlag = isRestartOrExit();
            }
        }

    }

    public List<Integer> getPlayerNumber() {
        String input = Console.readLine();
        List<Integer> player = validator.validateInputNumber(input);

        return player;
    }
    public List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANGE_NUMBER, MAXIMUM_RANGE_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}