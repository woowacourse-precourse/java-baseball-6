package baseball.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.common.Common.*;
import static baseball.controller.Input.*;
import static baseball.domain.BallConst.*;
import static baseball.domain.GameConst.*;

public class GameService {

    private boolean exit = false;
    private static List<Integer> computerBalls;

    public void startGame() {
        System.out.println(START_MESSAGE);
        computerBalls = createComputerNumbers();
        while (!exit) {
            String inputNums = inputNums();
            List<Integer> inputBalls = parseInputToList(inputNums);
            int[] result = calculate(computerBalls, inputBalls);
            console(result);
        }
    }

    public static int[] calculate(List<Integer> answer, List<Integer> inputNums) {
        int[] result = new int[2];
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == inputNums.get(i)){
                result[0]++;
            } else if (answer.contains(inputNums.get(i)) && answer.get(i) != inputNums.get(i)){
                result[1]++;
            }
        }
        return result;
    }

    public void console(int[] result) {
        if (result[0] == MAX_STRIKE) {
            System.out.println(STRIKE_THREE);
            System.out.println(STRIKE_THREE_GAME_SET);
            System.out.println(RETRY_MESSAGE);
            checkRetry();
        }

        if (result[0] != MAX_STRIKE) {
            if (result[0] == NOTHING && result[1] == NOTHING) {
                System.out.println(NOTHING_MESSAGE);
            }
            if (result[0] != NOTHING || result[1] != NOTHING){
                System.out.println(result[1]+BALL_MESSAGE + result[0]+STRIKE_MESSAGE);
            }
        }
    }

    private void checkRetry() {
        String input = inputRetryNum();
        validateRetryInput(input);
        int parseRetryInput = Integer.parseInt(input);
        if (parseRetryInput == RETRY_YES) {
            exit = false;
            computerBalls = createComputerNumbers();
        }
        if (parseRetryInput == RETRY_NO) {
            exit = true;
            Console.close();
        }
    }
}
