package baseball.service;

import baseball.domain.Message;
import baseball.domain.Result;
import baseball.view.OutputConsole;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public Result checkResult(List<Integer> computerNumber, List<Integer> inputNumber) {
        Message hintMessage = getHintMessage(computerNumber, inputNumber);
        OutputConsole.println(hintMessage.getMessage());
        if (hintMessage == Message.THREE_STRIKE) {
            return Result.CORRECT;
        }

        return Result.WRONG;
    }

    private Message getHintMessage(List<Integer> computerNumber, List<Integer> inputNumber) {
        int ballCount = getBallAndStrikeCountList(computerNumber, inputNumber).get(0);
        int strikeCount = getBallAndStrikeCountList(computerNumber, inputNumber).get(1);

        return Message.mappingHintMessage(ballCount, strikeCount);
    }

    private List<Integer> getBallAndStrikeCountList(List<Integer> computerNumber, List<Integer> inputNumber) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            for (int j = 0; j < inputNumber.size(); j++) {
                ballCount += checkBallCount(computerNumber, inputNumber, i, j);
                strikeCount += checkStrikeCount(computerNumber, inputNumber, i, j);
            }
        }

        List<Integer> countList = new ArrayList<>();
        countList.add(ballCount);
        countList.add(strikeCount);

        return countList;
    }

    private int checkBallCount(List<Integer> computerNumber, List<Integer> inputNumber, int i, int j) {
        if (i != j && computerNumber.get(i).equals(inputNumber.get(j))) {
            return 1;
        }
        return 0;
    }

    private int checkStrikeCount(List<Integer> computerNumber, List<Integer> inputNumber, int i, int j) {
        if (i == j && computerNumber.get(i).equals(inputNumber.get(j))) {
            return 1;
        }
        return 0;
    }

}
