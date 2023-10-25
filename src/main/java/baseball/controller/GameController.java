package baseball.controller;

import static baseball.util.ConstantUtil.ALL_MATCH_NUMBER;
import static baseball.util.ConstantUtil.BOOL;
import static baseball.util.ConstantUtil.INPUT_MESSAGE;
import static baseball.util.ConstantUtil.NOTHING;
import static baseball.util.ConstantUtil.STRIKE;
import static baseball.util.FunctionUtil.generateRandomList;
import static baseball.util.FunctionUtil.isNumberExist;
import static baseball.util.FunctionUtil.stringToInt;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.model.MatchNumberModel;
import java.util.List;

public class GameController {

    CheckNumberController checkNumberController = new CheckNumberController();
    ExceptionController exceptionController = new ExceptionController();
    public void matchNumber() {
        List<Integer> randomNumberList = generateRandomList();
        int[] numberExist = isNumberExist(randomNumberList);

        while (checkNumberController.getStrikeNumber() < ALL_MATCH_NUMBER) {
            System.out.println(INPUT_MESSAGE);
            String inputData = readLine();
            exceptionController.validateInput(inputData);
            List<Integer> inputNumberList = stringToInt(inputData);
            checkNumberResult(inputNumberList, numberExist);
        }
    }

    private void checkNumberResult(List<Integer> inputNumberList, int[] numberExist) {
        checkNumberController.checkStrike(inputNumberList, numberExist);
        checkNumberController.checkBall(inputNumberList, numberExist);

        int strikeNumber = checkNumberController.getStrikeNumber();
        int ballNumber = checkNumberController.getBallNumber();

        printResult(strikeNumber, ballNumber);

    }

    private void printResult(int strikeNumber, int ballNumber) {
        if (strikeNumber > 0 && ballNumber > 0) {
            System.out.println(ballNumber + BOOL + ' ' + strikeNumber + STRIKE + '\n');
            return;
        }
        if (strikeNumber==0 && ballNumber==0) {
            System.out.println(NOTHING + '\n');
            return;
        }
        if (strikeNumber > 0) {
            System.out.println(strikeNumber + STRIKE + '\n');
            return;
        }
        if (ballNumber > 0) {
            System.out.println(ballNumber + BOOL + '\n');
        }
    }
}
