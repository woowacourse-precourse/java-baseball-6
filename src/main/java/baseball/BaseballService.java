package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

// 숫자야구게임의 진행을 담당하는 클래스
public class BaseballService {
    public BaseballService() {
        BaseballPrint.printStartMessage();
    }

    public void startBaseballGame() {
        //static을 활용해서 숫자를 받아오는 것과 클래스를 생성한뒤 불러오는 방법중 더 나은 것은?
        BaseballNumber computerNumber = BaseballNumber.initializeComputerNumber();
        System.out.println(computerNumber);
        while (true) {
            BaseballNumber userNumber = BaseballNumber.initializeUserNumber();
            BaseballScore resultScore = compareBaseballNumber(computerNumber, userNumber);
            if (resultScore.isAllCorrect()) {
                BaseballPrint.printEndMessage();
                break;
            }
        }
        if (isContinueGame()) {
            startBaseballGame();
        }
    }

    private boolean isContinueGame() {
        BaseballPrint.printRestartMessage();
        String restartResult = Console.readLine();
        if (!restartResult.equals("1")&& !restartResult.equals("2")) {
            throw new IllegalArgumentException("1, 2 중 하나를 입력해주세요");
        }
        return restartResult.equals("1");
    }

    public BaseballScore compareBaseballNumber(BaseballNumber computerNumber, BaseballNumber userNumber) {
        BaseballScore baseballScore = computerNumber.compareNumber(userNumber);
        baseballScore.printBaseballScore();
        return baseballScore;
    }

}
