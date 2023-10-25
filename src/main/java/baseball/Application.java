package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int DIGIT_NUMBER = 3;
    private static final Computer computer = new Computer(DIGIT_NUMBER);
    private static boolean retry = true;

    public static void main(String[] args) {
        Prompt.GAME_START.println();

        do {
            Prompt.INPUT.print();
            String input = Console.readLine();
            String result = computer.evaluate(input);
            System.out.println(result);

            if (result.equals(Prompt.winningCond(DIGIT_NUMBER))) {
                // 승리 조건을 만족한 경우
                Prompt.GAME_OVER.println();
                Prompt.CONTINUE_OR.println();
                String option = Console.readLine();
                retry = computer.restartOrTerminate(option);
            }
        } while (retry);
    }
}
