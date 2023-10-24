package baseball.controller;

import baseball.model.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BusinessController {
    private final InteractionController interactionController;

    public BusinessController(InteractionController interactionController) {
        this.interactionController = interactionController;
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

    public Number generateUserNumber() {
        String inputData = interactionController.readInputData();
        return Number.of(inputData);
    }
}
