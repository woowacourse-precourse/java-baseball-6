package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Computer computer = new Computer();
        User user = new User();
        Hint hint = new Hint();

        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해주세요 : ");

        user.userInput();

        List<Integer> randomNumbers = computer.selectNumber();
        List<Integer> userNumbers = user.userInput();

        hint.compareNumber(randomNumbers, userNumbers);
    }
}
