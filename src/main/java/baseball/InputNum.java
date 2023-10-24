package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputNum {

    public List<Integer> getPlayerNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputList = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            inputList.add(input.charAt(i) - '0');
        }

        if (inputList.stream().distinct().toList().size() != inputList.size()) {
            throw new IllegalArgumentException();
        }
        return inputList;
    }

    public String getExitNum() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return Console.readLine();
    }
}
