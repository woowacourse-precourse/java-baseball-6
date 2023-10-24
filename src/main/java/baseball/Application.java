package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startGame();
        while (computer.getIsStarted()) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> numbers = computer.checkAnswer(input);
            computer.getResponse(numbers);
        }

    }
}
