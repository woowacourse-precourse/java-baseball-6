package baseball.domain;

import static baseball.global.enums.Constant.NUM_LENGTH;
import static baseball.global.enums.ErrorMessage.DIFFERENT_THREE_DIGITS;
import static baseball.global.util.GameInput.validateNum;
import static baseball.global.util.GameOutput.inputCommand;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임을 진행하는 플레이어에 대한 클래스
 */
public class Player {

    private List<Integer> num;
    private int status;   // 게임 진행 상태(1: 진행중, 2: 정상입력)

    public Player() {
        num = new ArrayList<>();
        status = 1;
    }

    /**
     * 매 라운드가 진행될 때마다 플레이어는 해당 메서드를 호출해 세 자리 수를 입력한다
     *
     * @return
     */
    public List<Integer> start() {
        status = 1;
        while (status == 1) {
            inputCommand();
            inputNum();
            status = 2;
        }

        return num;
    }

    /**
     * 입력한 수에 대한 validation을 판단하기 위한 메서드
     */
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
