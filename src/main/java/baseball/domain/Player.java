package baseball.domain;

import static baseball.global.enums.GuideMessage.INPUT_COMMAND;
import static baseball.global.util.GameInput.validateNum;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.global.enums.GuideMessage;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> num;
    private int status;  // 게임 진행 상태(1: 진행중, 2: 정상입력)

    public Player() {
        num = new ArrayList<>();
        status = 1;
    }

    public List<Integer> start() {
        status = 1;

        while (status == 1) {
            System.out.print(INPUT_COMMAND.message);

            try {
                inputNum();
                status = 2;
            } catch (IllegalArgumentException e) {   // 입력값에 관한 에러 한번에 잡기
                System.out.println(e.getMessage());
            }
        }

        return num;
    }

    private void inputNum() {
        num.clear();  // 예외상황을 대비하여 리스트 초기화
        String s = readLine();
        validateNum(s);

        for (int i = 0; i < 3; i++) {
            int order = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (num.contains(order)) {
                throw new IllegalArgumentException("서로 다른 세 자리 수를 입력하세요.");
            }

            num.add(order);
        }

    }

}
