package baseball.domain;

import baseball.exception.InputNeitherRestartNorExit;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class Game implements Numbers {

    public void startGame() {
        OutputView.printStartMsg(); // 숫자 야구 게임을 시작합니다.
    }

    public void proceedGame() {
        ComputerNumbers computerNumbers = new ComputerNumbers();

        boolean ongoing = true;

        while(ongoing) {
            InputView.printInputMsg(); // 숫자를 입력해주세요 :

            ClientNumbers clientNumbers = InputView.makeClientNumbers();
            Info info = clientNumbers.compareWithComputerNumbers(computerNumbers); // error
            ongoing = info.printMsgByUsingInfo();
        }
    }

    public void restartOrExitGame() {
        boolean oneMore = true;

        while(oneMore) {
            OutputView.printRestartOrExitMsg(); // 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
            int inputInt = Integer.parseInt(Console.readLine());
            // validateInputNeitherRestartNorExit(inputInt);

            if(inputInt == 1) {
                proceedGame();
            } else {
                oneMore = false;
            }
        }
    }

    // 우테코에서 제공한 테스트에는 성공하지 못함
    public static void validateInputNeitherRestartNorExit(int inputInt) {
        if (inputInt != 1 || inputInt != 2) {
            throw new InputNeitherRestartNorExit();
        }
    }
}
