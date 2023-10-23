package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

import static baseball.GamePrinter.printGameOverMsg;
import static baseball.GamePrinter.printGameStartMsg;
import static baseball.GameState.CONTINUE;
import static baseball.GameState.GAME_OVER;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = Computer.getInstance();
        User user = User.getInstance();
        Play play = Play.getInstance();
        int[] comNums = computer.setRandomNums();

        while(true) {
            System.out.println(Arrays.toString(comNums));
            printGameStartMsg();

            int[] userNums = user.setUserNum(Console.readLine());
            int gameStatus = Integer.parseInt(play.checkGameStatus(play.run(comNums, userNums)));
            if (gameStatus == GAME_OVER.getValue()) {
                printGameOverMsg();
                break;
            } else if (gameStatus == CONTINUE.getValue()) {
                computer.resetNums();
            }
        }
    }
}
