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
        return readLine();
    }

}
