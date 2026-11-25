package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String readRestartChoice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();

        if (!choice.equals("1") && !choice.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }

        return choice;
    }
}
