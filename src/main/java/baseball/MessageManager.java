package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MessageManager extends Messages {

    private String userAnswerNumber;
    private String willContinueResponse;

    public void showIntro() {
        System.out.println(super.getIntroMessage());
    }

    public String getUserAnswerNumber() {
        System.out.print(super.getInputMessage());
        userAnswerNumber = readLine();
        return userAnswerNumber;
    }

    public void showAnswer(Data data, GameProcessor gameProcessor, MessageManager messageManager) {
        System.out.println(gameProcessor.generateResultText(data, messageManager));
    }

    public String getUserContinueResponse() {
        System.out.println(super.getWillRestartMessage());
        willContinueResponse = readLine();
        System.out.println();
        return willContinueResponse;
    }
}
