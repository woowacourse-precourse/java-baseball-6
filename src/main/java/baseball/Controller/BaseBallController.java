package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.Number;
import baseball.View.BaseBallView;

import java.util.List;
import java.util.Map;

public class BaseBallController {

    Computer computer = new Computer();
    Number number = new Number();

//    프로그램 시작
    public void startProgram() {
        BaseBallView.displayStartProgram(); // 게임 시작 msg
//        무작위 숫자 생성 (3개)
        List<Integer> comNum = computer.setRandomNum(); // [a, b, c]
        inputNumData(comNum);
    }

    private void inputNumData(List<Integer> comNum) {
        BaseBallView.displayInputNumData(); // 숫자 입력 msg
//        사용자 숫자 입력 (어떤 자료형으로 받을건지 고민해보자)
        String[] userNumArr = number.inputNumValue(); // [x, y, z]
    }

}
