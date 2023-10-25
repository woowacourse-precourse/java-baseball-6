package baseball.service;

import baseball.domain.BaseballGameResult;
import baseball.domain.Numbers;
import baseball.domain.Player;
import baseball.utils.InputUtil;
import baseball.utils.NumberUtil;
import baseball.utils.OutputUtil;

public interface BaseballGame {
    int COMPUTER_NUMBER_SIZE = 3;
    String START_MESSAGE = "숫자 야구 게임을 시작하겠습니다.";
    String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    String NUMBER_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    static void play() {
        Player computer = Player.of(Numbers.of(NumberUtil.numberGenerator(BaseballGame.COMPUTER_NUMBER_SIZE)));
        while (true) {
            viewNumberRequestMessage();
            BaseballGameResult baseballGameResult = checkNumbers(computer, Player.of(Numbers.of(NumberUtil.stringArrMapIntArr(InputUtil.stringInputToArr()))));
            if (baseballGameResult.isFinish(COMPUTER_NUMBER_SIZE)) {
                OutputUtil.printlnString(baseballGameResult.getResult());
                break;
            }
            OutputUtil.printlnString(baseballGameResult.getResult());
        }
    }

    static BaseballGameResult checkNumbers(Player computer, Player user) {
        return BaseballGameResult.from(checkStrikeCount(computer, user), checkBallCount(computer, user));
    }

    static int checkBallCount(Player computer, Player user) {
        return computer.getNumbers().containsCount(user.getNumbers());
    }

    static int checkStrikeCount(Player computer, Player user) {
        return computer.getNumbers().equalsCount(user.getNumbers());
    }

    static void viewNumberRequestMessage() {
        OutputUtil.printString(NUMBER_REQUEST_MESSAGE);
    }
}
