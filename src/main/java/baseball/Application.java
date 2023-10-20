package baseball;

import baseball.computer.domain.Computer;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();
        List<Integer> randomAnswer = computer.createRandomAnswer();

        try {
            String input = Console.readLine();
            computer.validateInput(input);
            System.out.println(computer.getHint(input));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Console.close();

    }

}
