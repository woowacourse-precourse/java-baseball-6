package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class MessageManager extends Messages {
    private String inputResponse;
    public void showIntro() {
        System.out.print(super.getIntroMessage());
        System.out.println();
    }

    public String getUserInput() {
        System.out.print(super.getInputMessage());
        inputResponse = readLine();
        System.out.println();
        return inputResponse;
    }

    public void showAnswer(Data data, GameProcessor gameProcessor, MessageManager messageManager) {
        System.out.println(gameProcessor.generateAnswerText(data, messageManager));
    }

//    public void showMessage(GameProcessor gameProcessor, String message) {
//        System.out.print(gameProcessor.getResult() + message);
//    }
}
