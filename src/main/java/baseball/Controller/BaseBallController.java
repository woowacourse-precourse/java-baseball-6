package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.User;
import baseball.View.BaseBallView;

import java.util.Arrays;
import java.util.List;

public class BaseBallController {

    Computer computer = new Computer();
    User user = new User();

//    프로그램 시작
    public void startProgram() {
        BaseBallView.displayStartProgram(); // 게임 시작 msg
//        무작위 숫자 생성 (3개)
        List<Integer> comNum = computer.setRandomNum(); // [a, b, c]
        inputNumData();
    }

    private void inputNumData() {
        BaseBallView.displayInputNumData(); // 숫자 입력 msg
//        사용자 숫자 입력
        String[] arr = user.inputNumValue();



    }
}
