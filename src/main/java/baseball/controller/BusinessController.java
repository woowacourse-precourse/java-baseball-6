package baseball.controller;

import baseball.model.Number;
import baseball.model.Result;
import baseball.model.ResultCase;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BusinessController {
    private final InteractionController interactionController;

    public BusinessController(InteractionController interactionController) {
        this.interactionController = interactionController;
    }

    public Number generateUserNumber() {
        String inputData = interactionController.readInputData();
        return Number.of(inputData);
    }

    public Number generateComputerNumber() {
        List<Integer> generateData = new ArrayList<>();
        while (generateData.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generateData.contains(randomNumber)) {
                generateData.add(randomNumber);
            }
        }
        return Number.of(generateData);
    }

    public Result compareUserNumberAndComputerNumber(Number userNumber, Number computerNumber) {
        List<Integer> userData = userNumber.getData();
        List<Integer> computerData = computerNumber.getData();
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < userData.size(); i++) {
            for (int j = 0; j < userData.size(); j++) {
                if (i == j) {
                    if (userData.get(i).equals(computerData.get(j))) {
                        strikeCount += 1;
                    }
                } else {
                    if (userData.get(i).equals(computerData.get(j))) {
                        ballCount += 1;
                    }
                }
            }
        }
        return calculateResult(strikeCount, ballCount);
    }

    private Result calculateResult(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            return Result.of(ResultCase.CORRECT, strikeCount, ballCount);
        } else if (strikeCount == 0 && ballCount == 0) {
            return Result.of(ResultCase.ALL_MISMATCH, strikeCount, ballCount);
        } else {
            return Result.of(ResultCase.PARTIAL_MISMATCH, strikeCount, ballCount);
        }
    }
}
