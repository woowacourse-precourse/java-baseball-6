package baseball.service;

import baseball.entity.Computer;
import baseball.entity.Result;
import baseball.view.Input;
import baseball.view.Log;
import camp.nextstep.edu.missionutils.Console;

public class Service {

    private final Computer computer = Computer.getInstance();

    public void startGame() {
        while (true) {
            Log.info("숫자를 입력해주세요 : ");
            int userNumber = Input.readNumber();
            Result result = computer.resultNumber(userNumber);
            Log.result(result.getBall(), result.getStrike());
            if (result.correctAnswer()) {
                Log.info("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                return;
            }
        }
    }
}
