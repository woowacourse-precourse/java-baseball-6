package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MessageManager extends Messages {
    private String userAnswerNumber;
    private String willContinueResponse;
    public void showIntro() {
        System.out.print(super.getIntroMessage());
        System.out.println();
    }

    public String getUserAnswerNumber() {
        System.out.print(super.getInputMessage());
        userAnswerNumber = readLine();
        System.out.println();

        return userAnswerNumber;
    }

    public void showAnswer(Data data, GameProcessor gameProcessor, MessageManager messageManager) {
        System.out.println(gameProcessor.generateAnswerText(data, messageManager));
    }

    public String getUserContinueResponse() {
        System.out.print(super.getOutroMessage());
        System.out.println();

        System.out.println(super.getWillRestartMessage());
        willContinueResponse = readLine();
        System.out.println();

        return willContinueResponse;
    }

//    public void showMessage(GameProcessor gameProcessor, String message) {
//        System.out.print(gameProcessor.getResult() + message);
//    }
}
