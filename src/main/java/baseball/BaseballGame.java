package baseball;

import java.util.List;

public class BaseballGame {
    private static final BaseballReferee baseballReferee = new BaseballReferee();
    private static final InputReader inputReader = new InputReader();
    private static final NumberGenerator numberGenerator = new NumberGenerator();
    private static final OutputWriter outputWriter = new OutputWriter();

    public static void gameStart(){
        outputWriter.printGameStartMessage();

        while(true) {
            List<Integer> goal = numberGenerator.generateNumber();

            while (true) {
                outputWriter.printInputMessage();
                List<Integer> expect = inputReader.readUserGameInput();

                int[] result = baseballReferee.scoreInput(goal, expect);
                outputWriter.printResultOfInput(result[0], result[1]);

                if (result[1] == 3) break;
            }

            outputWriter.printGameFinishMessage();
            int restart = inputReader.readUserGameFinishInput();

            if(restart == 2) break;
        }

    }
}
