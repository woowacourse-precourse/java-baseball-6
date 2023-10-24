package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    final static int DIGIT_NUMBER = 3;

    public static void main(String[] args) {
        Prompt.GAME_START.println();
        Computer computer = new Computer(DIGIT_NUMBER);
        String targetNumber = String.valueOf(computer.generateRandomNumbers());

        do {
            Prompt.INPUT.print();
            String input = Console.readLine();
            String result = computer.evaluate(input, targetNumber);
            System.out.println(result);

            if (result.equals(Prompt.winningCond(DIGIT_NUMBER))) {
                Prompt.GAME_OVER.println();
                return;
            }
        } while (true);
    }
}
