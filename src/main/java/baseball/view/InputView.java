package baseball.view;

import baseball.dto.BaseBallNumbersByUserInputDto;
import baseball.dto.ShutDownOrReplayDto;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputViewValidator inputViewValidator;

    public InputView(InputViewValidator inputViewValidator) {
        this.inputViewValidator = inputViewValidator;
    }

    public BaseBallNumbersByUserInputDto inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String stringNums = Console.readLine();
        inputViewValidator.validateNum(stringNums);

        return new BaseBallNumbersByUserInputDto(stringNums);
    }

    public ShutDownOrReplayDto inputTerminateNum() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String stringNum = Console.readLine();
        inputViewValidator.validateNum(stringNum);

        return new ShutDownOrReplayDto(stringNum);
    }

}
