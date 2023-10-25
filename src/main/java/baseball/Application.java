package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private final static int DIGIT_NUMBER = 3;
    private static final Computer computer = new Computer(DIGIT_NUMBER);

    public static void main(String[] args) {
        Prompt.GAME_START.println();
        String targetNumber = String.valueOf(computer.generateRandomNumbers());

        do {
            Prompt.INPUT.print();
            String input = Console.readLine();
            String result = computer.evaluate(input, targetNumber);
            System.out.println(result);

            if (result.equals(Prompt.winningCond(DIGIT_NUMBER))) {
                Prompt.GAME_OVER.println();
                Prompt.CONTINUE_OR.println();

                String option = Console.readLine();

                switch (option) {
                    case "1" -> targetNumber = String.valueOf(computer.generateRandomNumbers());
                    case "2" -> {
                        return;
                    }
                    default -> throw new IllegalArgumentException();
                }
            }
        } while (true);
    }
}
