package baseball.util;

import baseball.constant.Number;
import baseball.domain.BaseballCount;
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
        int restartNum = Integer.parseInt(Console.readLine());
        if (restartNum == Number.RESTART_NUM) {
            return true;
        } else if (restartNum == Number.FINISH_NUM) {
            return false;
        } else {
            // TODO : 다른 수가 입력될 경우 예외처리
            return false;
        }
    }

    public static List<Integer> inputNumber() {
        MessageUtil.printInputMsg();
        String input = Console.readLine(); //길이, 서로 다른 세 숫자 예외처리 필요
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        List<Integer> userNum = new ArrayList<>();
        for (String s : input.split("")) {
            userNum.add(Integer.parseInt(s));
        }
        return userNum;
    }

    public static List<Integer> initRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
