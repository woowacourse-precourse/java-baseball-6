package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private List<Integer> numbers;

    public void takeInput() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.println("숫자를 입력해주세요");
        String value = Console.readLine();
        for (int i = 0; i < 3; i++) {
            numbers.add(Character.getNumericValue(value.charAt(i)));
        }
    }
}
