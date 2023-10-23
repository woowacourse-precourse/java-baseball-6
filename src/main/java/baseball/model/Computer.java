package baseball.model;

import baseball.util.ArraysUtils;
import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> computerNumber;
    public static String restartOrFinishFlag; // 1 : restart, 2: finish

    public static void setComputerNumber() {
        computerNumber = createComputerNumberList();
    }

    public static void setRetryOrFinishFlag(String flag) {
        isValidFlag(flag);
        restartOrFinishFlag = flag;
    }

    private static boolean isValidFlag(String flag) {
        return InputValidator.checkComputerRetryOrFinishFlag(flag);
    }

    /**
     * Strike, 컴퓨터에서 제시한 값과
     * 플레이어가 제시한 값이 동일한 경우 : true
     * @param playerNumber
     * @return
     */
    public static boolean isStrike(List<Integer> playerNumber) {
        return ArraysUtils.isEquals(computerNumber, playerNumber);
    }


    /**
     * 숫자야구 정답 값 생성
     * @return
     */
    private static List<Integer> createComputerNumberList() {
        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

}
