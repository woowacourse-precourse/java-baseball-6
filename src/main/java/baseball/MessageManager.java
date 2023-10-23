package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MessageManager extends Messages {

    private String inputNumber;
    private String continueResponse;

    public void showIntro() {
        System.out.println(super.getIntroText());
    }

    public String getInputNumber() {
        System.out.print(super.getInputText());
        inputNumber = readLine();
        return inputNumber;
    }

    public void showAnswer(Data data, GameProcessor gameProcessor, MessageManager messageManager) {
        System.out.println(gameProcessor.generateResultText(data, messageManager));
    }

    public String getContinueResponse() {
        System.out.println(super.getWillRestartText());
        continueResponse = readLine();
        System.out.println();
        return continueResponse;
    }
}
