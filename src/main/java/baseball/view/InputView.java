package baseball.view;

import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Numbers readUserNumbers() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        return new Numbers(input);
    }
}
