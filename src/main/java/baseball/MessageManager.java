package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MessageManager extends Messages {

    public void showIntro() {
        System.out.println(super.getIntroText());
    }

    public String getInputNumber() {
        System.out.print(super.getInputText());

        return readLine();
    }

    public void showAnswer(Data data, GameProcessor gameProcessor, MessageManager messageManager) {
        System.out.println(gameProcessor.generateResultText(data, messageManager));
    }

    public String getContinueResponse() {
        System.out.println(super.getWillRestartText());

        String continueResponse = readLine();
        System.out.println();

        return continueResponse;
    }
}
