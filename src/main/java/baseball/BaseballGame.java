package baseball;


import baseball.utils.SystemOutPut;
import baseball.validation.InputValidation;
import java.util.List;

public class BaseballGame {
    private InputValidation validation = new InputValidation();

    public void startGame() {
        SystemOutPut.printStartMsg();

        while (true) {
            SystemOutPut.printInputMsg();
            List<Integer> word = validation.startInput();

            //랜덤값 입력값이랑 비교

            // 결과 출력 해주기

        }


    }
}
