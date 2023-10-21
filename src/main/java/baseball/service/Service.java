package baseball.service;

import baseball.entity.Computer;
import baseball.view.Log;
import camp.nextstep.edu.missionutils.Console;

public class Service {

    private final Computer computer = Computer.getInstance();

    public void startGame() {
        while (true) {
            Log.info("숫자를 입력해주세요 : ");
            int userNumber = Integer.parseInt(Console.readLine());
            computer.resultNumber(userNumber);
        }
    }
}
