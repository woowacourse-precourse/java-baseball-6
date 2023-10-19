package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

// 숫자야구게임의 진행을 담당하는 클래스
public class BaseballService {
    public BaseballService() {
        System.out.println("숫자 야구 게임을 시작합니다.");

    }

    public void startBaseballGame() {
        //static을 활용해서 숫자를 받아오는 것과 클래스를 생성한뒤 불러오는 방법중 더 나은 것은?
        BaseballNumber computerNumber = BaseballNumber.initializeComputerNumber();
        while (true) {
            BaseballNumber userNumber = BaseballNumber.initializeUserNumber();
            BaseballScore resultScore = compareBaseballNumber(computerNumber, userNumber);
            if (resultScore.isAllCorrect()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        if (isContinueGame()) {
            startBaseballGame();
        }
    }

    private boolean isContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
