package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

public class InteractionController {
    public String readInputData() {
        String inputData = Console.readLine();
        // TODO input data validate logic
        return inputData;
    }

    public Integer readChoiceData() {
        String choiceData = Console.readLine();
        // TODO choice data validate logic
        return Integer.valueOf(choiceData);
    }
}
