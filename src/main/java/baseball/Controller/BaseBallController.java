package baseball.Controller;

import baseball.View.BaseBallView;

public class BaseBallController {

//    프로그램 시작
    public void startProgram() {
        BaseBallView.displayStartProgram();
        inputNumData();
    }

    private void inputNumData() {
        BaseBallView.displayInputNumData();

    }
}
