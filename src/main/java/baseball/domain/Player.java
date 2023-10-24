package baseball.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.global.enums.GuideMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    private List<Integer> num;

    public Player() {
        num = new ArrayList<>();
    }

    public void inputNum() {
        System.out.print(GuideMessage.INPUT_COMMAND.message);
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

            if (order == 0) {
                throw new IllegalArgumentException("0은 숫자에 포함할 수 없습니다.");
            }

            num.add(order);

            if (num.contains(order)) {
                throw new IllegalArgumentException("서로 다른 세 자리 수를 입력하세요.");
            }
        }
    }

}
