package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        User user = new User();
        Check check = new Check();
        List<Integer> comp_numbers = computer.randomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            List<Integer> user_numbers = user.inputNumber();
            check.resultCheck(comp_numbers, user_numbers);
            if(check.endingCheck()) {
                if(check.replayCheck()) {
                    comp_numbers = computer.randomNumber();
                }
                else {
                    break;
                }
            }
        }
    }
}