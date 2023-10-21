package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> userInput() throws IllegalArgumentException {
        List<Integer> inputNumbers = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        for (int i = 0; i < input.length(); i++) {
            inputNumbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        return inputNumbers;
    }

    public void run() {
        while(true) {
            Computer computer = new Computer();
            computer.generateNumbers();

            boolean isCorrect = false;
            while(isCorrect) {
                String answer = computer.checkNumbers(userInput());
                System.out.println(answer);
            }
        }
    }
}
