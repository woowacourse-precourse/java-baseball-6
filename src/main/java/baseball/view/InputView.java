package baseball.view;

import baseball.domain.RetryCommand;
import baseball.util.TypeConvertor;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public List<Integer> getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return TypeConvertor.stringToIntergerList(input);
    }

    public RetryCommand getCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(Console.readLine());
        return RetryCommand.convertTypeCommand(input);
    }
}
