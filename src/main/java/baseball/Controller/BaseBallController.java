package baseball.Controller;

import baseball.View.BaseBallView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallController {

//    프로그램 시작
    public void startProgram() {
        BaseBallView.displayStartProgram();
        inputNumData();
    }

    private void inputNumData() {
        BaseBallView.displayInputNumData();
        String inputNum = Console.readLine();
    }
}
