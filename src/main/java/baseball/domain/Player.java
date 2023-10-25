package baseball.domain;

import static baseball.global.enums.Constant.NUM_LENGTH;
import static baseball.global.enums.ErrorMessage.DIFFERENT_THREE_DIGITS;
import static baseball.global.util.GameInput.validateNum;
import static baseball.global.util.GameOutput.errorMessage;
import static baseball.global.util.GameOutput.inputCommand;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> num;
    private int status;   // 게임 진행 상태(1: 진행중, 2: 정상입력)

    public Player() {
        num = new ArrayList<>();
        status = 1;
    }

    public List<Integer> start() {
        status = 1;

        while (status == 1) {
            inputCommand();

            inputNum();
            status = 2;
        }

        return num;
    }

    private void inputNum() {
        num.clear();  // 예외상황을 대비하여 리스트 초기화
        String s = readLine();
        validateNum(s);

        for (int i = 0; i < NUM_LENGTH; i++) {
            int digit = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (num.contains(digit)) {
                throw new IllegalArgumentException(DIFFERENT_THREE_DIGITS.message);
            }

            num.add(digit);
        }

    }

}
