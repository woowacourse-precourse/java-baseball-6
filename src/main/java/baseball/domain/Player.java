package baseball.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.global.enums.GuideMessage;
import java.util.ArrayList;
import java.util.Arrays;
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
            System.out.print(GuideMessage.INPUT_COMMAND.message);

            try {
                inputNum();
                status = 2;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return num;
    }

    private void inputNum() {
        num.clear();  // 예외상황을 대비하여 리스트 초기화
        String s = readLine();

        if (s.length() != 3) {
            throw new IllegalArgumentException("세 자리 수를 입력해야 합니다.");
        }

        for (int i = 0; i < s.length(); i++) {

            int order;

            try {
                order = Integer.parseInt(String.valueOf(s.charAt(i)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
            }

            validateNum(order);
            num.add(order);
        }
    }

    private void validateNum(int order) {
        if (order == 0) {
            throw new IllegalArgumentException("0은 숫자에 포함할 수 없습니다.");
        }

        if (num.contains(order)) {
            throw new IllegalArgumentException("서로 다른 세 자리 수를 입력하세요.");
        }
    }

}
