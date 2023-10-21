package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInput implements Input {

    @Override
    public String getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    @Override
    public String getRestartCode() {
        String input = readLine();
        if (input.equals("1") || input.equals("2")) {
            return input;
        }
        throw new IllegalArgumentException("잘못된 코드를 입력하셨습니다.");
    }

}
