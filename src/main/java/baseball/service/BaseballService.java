package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballScore;
import baseball.util.Util;
import baseball.view.BaseballPrint;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// 숫자야구게임의 진행을 담당하는 클래스
public class BaseballService {
    public BaseballService() {
        BaseballPrint.printStartMessage();
    }

    public void playBaseballGame() {
        BaseballNumber computerNumber = initializeComputerNumber();
        while (true) {
            BaseballNumber userNumber = initializeUserNumber();
            BaseballScore resultScore = compareBaseballNumber(computerNumber, userNumber);
            if (resultScore.isStrikeThree()) {
                BaseballPrint.printEndMessage();
                break;
            }
        }
        if (isContinueGame()) {
            playBaseballGame();
        }
    }

    public BaseballNumber initializeComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new BaseballNumber(computer);
    }

    private boolean isContinueGame() {
        BaseballPrint.printRestartMessage();
        String restartResult = Console.readLine();
        Util.validateStringIsOneOrTwo(restartResult);
        return restartResult.equals("1");
    }

    public BaseballScore compareBaseballNumber(BaseballNumber computerNumber, BaseballNumber userNumber) {
        BaseballScore baseballScore = BaseballNumber.compareNumber(computerNumber, userNumber);
        baseballScore.printBaseballScore();
        return baseballScore;
    }

    public BaseballNumber initializeUserNumber() {
        BaseballPrint.printInputNumberMessage();
        return new BaseballNumber(Console.readLine());
    }
}
