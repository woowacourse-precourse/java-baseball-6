package baseball.domain;

import baseball.presentation.Message;
import baseball.utils.ComputerNumberCreator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    static int retry = 1;
    static int[] computerNumberArray;
    private static boolean gameEnd = false;
    private static final ComputerNumberCreator computerNumberCreator = new ComputerNumberCreator();
    private static final Ball ball = new Ball();
    private static final Judge judge = new Judge();
    private static final Result result = new Result();
    private static final Message message = new Message();

    public void start() {
        mound();
        game();
    }

    private static void mound() {
        retry = 1;
        message.printStartMessage();
    }

    private static void game() {
        while (retry == 1) {
            standBy();

            pitch();

            message.printRestartMessage();

            retry = Integer.parseInt(Console.readLine());

            if (retry == 2) {
                break;
            }
        }
    }

    private static void standBy() {
        gameEnd = false;
        computerNumberArray = computerNumberCreator.createComputerNumber();
    }

    private static void pitch() {
        while (!gameEnd) {
            int[] outcome = judge(computerNumberArray, inning());

            if (outcome[0] == 3) {
                message.printEndMessage();
                gameEnd = true;
            }
        }
    }

    private static Pitching inning() {
        message.printInputMessage();

        return new Pitching(ball);
    }

    private static int[] judge(int[] computerNumberArray, Pitching pitching) {
        Referee refree = new Referee(computerNumberArray, pitching, judge);

        int[] outcome = refree.result;
        result.printResult(outcome);

        return outcome;
    }


}
