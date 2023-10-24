package baseball.util;

import baseball.constant.Number;
import baseball.domain.BaseballCount;
import baseball.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 게임 관리를 위한 메서드를 가지는 유틸 클래스
 */
public class GameUtil {
    public static BaseballCount compareBaseball(List<Integer> computer, List<Integer> userNum) {
        int ball = 0, strike = 0;
        for (int i = 0; i < Number.GAME_LENGTH; i++) {
            if (userNum.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(userNum.get(i))) {
                ball++;
            }
        }
        return new BaseballCount(ball, strike);
    }

    public static boolean isGameRestart() {
        MessageUtil.printFinishMsg();
        MessageUtil.printRestartMsg();
        String input = Console.readLine();
        InputValidator.validateRestartNum(input);
        return Integer.parseInt(input) == Number.RESTART_NUM;
    }

    public static List<Integer> inputNumber() {
        MessageUtil.printInputMsg();
        String input = Console.readLine();
        InputValidator.validateInputNum(input);
        return input.chars().map(Character::getNumericValue).boxed().toList();
    }

    public static List<Integer> initRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Number.GAME_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Number.RANGE_START, Number.RANGE_END);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean isUnitGameFinish(BaseballCount count) {
        return count.getStrike() == Number.GAME_LENGTH;
    }

}
